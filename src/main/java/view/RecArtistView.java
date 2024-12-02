package view;

import javax.swing.*;

import entity.*;
import interface_adapter.rec_artist.*;
import interface_adapter.spotify_auth.SpotifyAuthController;
import use_case.rec_artist.*;

/**
 * The View for when the user generates an artist.
 */
public class RecArtistView {
    private final JPanel view;
    private final ViewBuilder builder;
    private RecArtistController recArtistController;

    public RecArtistView() {

        this.builder = new ViewBuilder();

        // fetch the recommended artist from the controller
        final Artist artist = recArtistController.getArtist();

        // Build the view
        builder.addLabel("artistName", "Recommended Artist: " + artist.getName())
                .setViewName("Recommended Artist");

        view = builder.build();
    }

    public JPanel getView() {
        return view;
    }

    public void setRecArtistController(RecArtistController recArtistController) {
        this.recArtistController = recArtistController;
    }
}
