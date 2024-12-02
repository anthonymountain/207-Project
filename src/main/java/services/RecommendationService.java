package services;

import java.util.Random;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import entity.Track;
import interface_adapter.spotify_auth.SpotifyApiClient;

@Service
public class RecommendationService {

    private final SpotifyApiClient spotifyApiClient;

    public RecommendationService(TokenService tokenService) {
        this.spotifyApiClient = new SpotifyApiClient(tokenService);
    }

    /**
     * This gets random recommendations.
     * @param seedArtist helps recommend based off artists
     * @param seedGenre helps recommend based off genre
     * @param seedTrack helps recommend based off track
     * @return the tracks in a String format.
     */
    public String getRandomRecommendation(String seedArtist, String seedGenre, String seedTrack) {
        final String response = spotifyApiClient.getRecommendations(seedArtist, seedGenre, seedTrack);
        final JSONObject jsonResponse = new JSONObject(response);
        final JSONArray tracks = jsonResponse.getJSONArray("tracks");

        if (tracks.isEmpty()) {
            return "No recommendations found.";
        }
        else {
            final Random random = new Random();
            final JSONObject randomTrack = tracks.getJSONObject(random.nextInt(tracks.length()));
            return randomTrack.getString("name") + " by " + randomTrack.getJSONArray("artists")
                    .getJSONObject(0).getString("name");
        }
    }
}
