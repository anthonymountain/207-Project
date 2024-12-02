package services;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import entity.*;
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
    public JSONObject getRandomRecommendation(String seedArtist, String seedGenre, String seedTrack) {
        final String response = spotifyApiClient.getRecommendations(seedArtist, seedGenre, seedTrack);
        System.out.println(response + "hello");
        final JSONObject jsonResponse = new JSONObject(response);
        final JSONArray tracks = jsonResponse.getJSONArray("tracks");

        if (tracks.isEmpty()) {
            return null;
        }
        else {
            final Random random = new Random();
            return tracks.getJSONObject(random.nextInt(tracks.length()));
            //            return randomTrack.getString("name") + " by " + randomTrack.getJSONArray("artists")
            //                    .getJSONObject(0).getString("name");
        }
    }

    /**
     * Retrieves the user's top artists.
     * @param limit the number of items to get.
     * @return the list of artists.
     */
    public ArrayList<Artist> getUserTopArtists(int limit) {
        return spotifyApiClient.getUserTopArtists(limit);
    }

    /**
     * Retrieves the user's top tracks.
     * @param limit the number of items to get.
     * @return the list of tracks.
     */
    public ArrayList<Track> getUserTopTracks(int limit) {
        return spotifyApiClient.getUserTopTracks(limit);
    }

    /**
     * Retrieve the artist's related artists.
     * @param artistId the ID of the artist.
     * @return related artists.
     */
    public ArrayList<Artist> getRelatedArtists(String artistId) {
        return spotifyApiClient.getRelatedArtists(artistId);
    }
}
