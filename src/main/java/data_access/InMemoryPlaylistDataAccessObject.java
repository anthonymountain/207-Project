package data_access;

import entity.Artist;
import entity.DisplayPlaylist;
import entity.Track;
import interface_adapter.spotify_auth.SpotifyAuthController;
import org.json.JSONObject;
import services.JSONParser;
import use_case.rec_playlist.RecPlaylistDataAccessInterface;

import java.util.ArrayList;

/**
 * This DAO is going to get data for playlists.
 */
public class InMemoryPlaylistDataAccessObject implements RecPlaylistDataAccessInterface {

    public static final int TEN = 10;
    private SpotifyAuthController spotifyAuthController;

    public InMemoryPlaylistDataAccessObject(SpotifyAuthController spotifyAuthController) {
        this.spotifyAuthController = spotifyAuthController;
    }

    @Override
    public ArrayList<Track> getRecommendations() {

        // Make API call to get recommendation - to be figured out later.
        //        spotifyAuthController.getUserTopItems()

        // Get artist seed
        final ArrayList<Artist> artists = new ArrayList<>();
        final String artistSeed = "";

        // Make the artist seed
        for (int i = 0; i < artists.size(); i++) {
            artistSeed.concat("," + artists.get(i).getId());
        }

        final String seedGenre = "classical,country";
        final String seedTrack = "0c6xIDDpzE81m2q797ordA";
        final ArrayList<Track> displayPlaylist = new ArrayList<>();

        // Get the tracks and add them to the display
        for (int i = 0; i < 10; i++) {
            final JSONObject jsonResponse = spotifyAuthController.getRandomRecommendation(artistSeed, seedGenre, seedTrack);
            final JSONParser jsonParser = new JSONParser();
            final Track track = jsonParser.parse(jsonResponse);
            displayPlaylist.add(track);
        }

        return displayPlaylist;
    }
}
