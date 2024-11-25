package services;

import interface_adapter.spotifyauth.SpotifyApiClient;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class RecommendationService {

    private final SpotifyApiClient spotifyApiClient;

    public RecommendationService(SpotifyApiClient spotifyApiClient) {
        this.spotifyApiClient = spotifyApiClient;
    }

    public String getRandomRecommendation(String accessToken, String seedArtist, String seedGenre, String seedTrack) {
        String response = spotifyApiClient.getRecommendations(accessToken, seedArtist, seedGenre, seedTrack);
        JSONObject jsonResponse = new JSONObject(response);
        JSONArray tracks = jsonResponse.getJSONArray("tracks");

        if (tracks.isEmpty()) {
            return "No recommendations found.";
        }

        Random random = new Random();
        JSONObject randomTrack = tracks.getJSONObject(random.nextInt(tracks.length()));
        return randomTrack.getString("name") + " by " + randomTrack.getJSONArray("artists").getJSONObject(0).getString("name");
    }
}
