package data_access;

import entity.Artist;
import entity.DisplayPlaylist;
import entity.Track;
import interface_adapter.spotify_auth.SpotifyAuthController;
import org.json.JSONObject;
import services.JSONParser;
import use_case.rec_playlist.RecPlaylistDataAccessInterface;

import java.util.ArrayList;
import java.util.Random;

/**
 * This DAO is going to get data for playlists.
 */
public class InMemoryPlaylistDataAccessObject implements RecPlaylistDataAccessInterface {

    public static final int TEN = 10;
    private final ArrayList<Track> tracks;
    private SpotifyAuthController spotifyAuthController;

    public InMemoryPlaylistDataAccessObject(SpotifyAuthController spotifyAuthController) {
        this.spotifyAuthController = spotifyAuthController;
        this.tracks = new ArrayList<>();
    }

    @Override
    public ArrayList<Track> getRecommendations() {

        // Make API call to get recommendation - to be figured out later.
        //        spotifyAuthController.getUserTopItems(50)
        final int playlistSize = 10;
        int counter = 0;
        boolean addToTracks = true;
        while (counter < playlistSize) {
            final Track track = spotifyAuthController.getRandomRecommendation("", "", "");
            for (Track value : tracks) {
                if (value == track) {
                    addToTracks = false;
                    break;
                }
                else {
                    addToTracks = true;
                }
            }
            if (addToTracks) {
                tracks.add(track);
                counter++;
            }
        }
        return tracks;

//        final ArrayList<Artist> listArtist = new ArrayList<>();
//
//        final ArrayList<Artist> artists = new ArrayList<>();
//
//        //        Random rand = new Random();
//        //        for (int i = 0; i < 10; i++) {
//        //            final int randInt = rand.nextInt(50);
//        //
//        //            // Get artist seed
//        //            artists.add(listArtist.get(randInt));
//        //        }
//
//        final String artistSeed = "";
//        // Make the artist seed
//        for (int i = 0; i < artists.size(); i++) {
//            artistSeed.concat("," + artists.get(i).getId());
//        }
//
//        final String seedGenre = "classical,country";
//        final String seedTrack = "0c6xIDDpzE81m2q797ordA";
//        final ArrayList<Track> displayPlaylist = new ArrayList<>();
//
//        // Get the tracks and add them to the display
//        for (int i = 0; i < 10; i++) {
//            final JSONObject jsonResponse = spotifyAuthController.getRandomRecommendation(artistSeed, seedGenre, seedTrack);
//            final JSONParser jsonParser = new JSONParser();
//            final Track track = jsonParser.parse(jsonResponse);
//            displayPlaylist.add(track);
//        }
//
//        return displayPlaylist;
    }

    public ArrayList<Track> getTracks() {
        return tracks;
    }
}
