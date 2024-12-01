package data_access;

import entity.Playlist;
import interface_adapter.spotify_auth.SpotifyApiClient;
import services.RecommendationService;
import services.TokenService;
import use_case.rec_playlist.RecPlaylistDataAccessInterface;

import java.util.ArrayList;

/**
 * This DAO is going to get data for playlists.
 */
public class InMemoryPlaylistDataAccessObject implements RecPlaylistDataAccessInterface {

    public static final int TEN = 10;
    private TokenService tokenService;

    public InMemoryPlaylistDataAccessObject(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @Override
    public ArrayList<String> getRecommendations() {
        final SpotifyApiClient spotifyApiClient = new SpotifyApiClient(tokenService);
        final RecommendationService recommendationService = new RecommendationService(spotifyApiClient);

        // Make API call to get recommendation
        final ArrayList<String> displayStuff = new ArrayList<>();
        for (int i = 0; i < TEN; i++) {
            displayStuff.add(recommendationService.getRandomRecommendation("", "", ""));
        }

        return displayStuff;
    }
}
