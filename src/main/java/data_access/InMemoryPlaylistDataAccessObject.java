package data_access;

import entity.DisplayPlaylist;
import interface_adapter.spotify_auth.SpotifyAuthController;
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
        //        final ArrayList<String> displayStuff = new ArrayList<>();
        //        for (int i = 0; i < TEN; i++) {
        //            displayStuff.add(spotifyAuthController.getRandomRecommendation("", "", "", ""));
        //        }
        //        return new DisplayPlaylist(displayStuff);
        return new DisplayPlaylist(new ArrayList<>());
    }
}
