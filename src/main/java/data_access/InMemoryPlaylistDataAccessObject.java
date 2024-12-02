package data_access;

import entity.Artist;
import entity.DisplayPlaylist;
import entity.Track;
import interface_adapter.spotify_auth.SpotifyAuthController;
import org.json.JSONObject;
import services.JSONParser;
import use_case.rec_playlist.RecPlaylistDataAccessInterface;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

/**
 * This DAO is going to get data for playlists.
 */
public class InMemoryPlaylistDataAccessObject implements RecPlaylistDataAccessInterface {

    public static final int TEN = 10;
    private ArrayList<Track> tracks;
    private SpotifyAuthController spotifyAuthController;

    public InMemoryPlaylistDataAccessObject(SpotifyAuthController spotifyAuthController) {
        this.spotifyAuthController = spotifyAuthController;
        this.tracks = new ArrayList<>();
    }

    @Override
    public DisplayPlaylist getRecommendations() {
        //        final SpotifyApiClient spotifyApiClient = new SpotifyApiClient(tokenService);
        //        final RecommendationService recommendationService = new RecommendationService(spotifyApiClient);
        //
        //        // Make API call to get recommendation
        //        final ArrayList<String> displayStuff = new ArrayList<>();
        //        for (int i = 0; i < TEN; i++) {
        //            displayStuff.add(recommendationService.getRandomRecommendation("", "", ""));
        //        }

        // Make API call to get recommendation - to be figured out later.
        // final seed trackSeed = spotifyAuthController.getUserTopItems();
        // final String jsonResponse = spotifyAuthController.getRandomRecommendation(trackSeed);
        // JSONParser jsonParser = new JSONParser();
        // final Playlist playlist = jsonParser.parse(jsonResponse);
        // return playlist;


        // return playlist;
        //        final ArrayList<String> displayStuff = new ArrayList<>();
        //        for (int i = 0; i < TEN; i++) {
        //            displayStuff.add(spotifyAuthController.getRandomRecommendation("", "", "", ""));
        //        }
        //        return new DisplayPlaylist(displayStuff);
        return new DisplayPlaylist(new ArrayList<>());
//        public ArrayList<Track> getRecommendations() {
//
//            // Make API call to get recommendation
//            tracks = new ArrayList<>();
//            final int playlistSize = 10;
//            int counter = 0;
//            boolean addToTracks;
//            while (counter < playlistSize) {
//                addToTracks = true;
//                final Track track = spotifyAuthController.getRandomRecommendation("", "", "");
//                for (Track value : tracks) {
//                    if (Objects.equals(value.getName(), track.getName())) {
//                        addToTracks = false;
//                        break;
//                    }
//                }
//                if (addToTracks) {
//                    tracks.add(track);
//                    counter++;
//                }
//            }
//            return tracks;

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