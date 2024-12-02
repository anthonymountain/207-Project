package view;

import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.swing.*;

import entity.*;
import interface_adapter.rec_artist.*;
import interface_adapter.rec_song.RecSongController;
import interface_adapter.spotify_auth.*;
import services.*;

/**
 * The View for when the user generates a artist.
 * //Note: if you want to figure out the correct format and structure, look at LoggedInView.java
 * //import interface_adapter.rec_artist.RecArtistState;  could be unnecessary
 */
public class RecArtistView {

    private final JPanel view;
    private Artist artist;
    private ArrayList<Artist> artists;
    private TokenService tokenService = new TokenService();
    private String token = tokenService.getToken();
    private SpotifyApiClient spotifyApiClient = new SpotifyApiClient(tokenService);
    private String user = spotifyApiClient.getCurrentUserProfile();
    private RecArtistController recArtistController;
    private RecSongController recSongController;
    private JButton recSong;

    public RecArtistView() {
        final ViewBuilder builder = new ViewBuilder();

        final String top = spotifyApiClient.getUserTopArtists("artist", 1).get(0).getId();
        artists = spotifyApiClient.getRelatedArtists(top);
        artist = artists.get(0);

        builder.addLabel("New Artist: " + this.artist.getName())
                .addButton("recSong", "Recommend Song")
                .setViewName("Recommended Artist");

        recSong = builder.getButton("recSong");
        recSong.addActionListener(evt -> recSongController.execute());
        view = builder.build();
    }

    public JPanel getView() {
        return view;
    }

    public void setRecArtistController(RecArtistController recArtistController) {
        this.recArtistController = recArtistController;
    }
}
