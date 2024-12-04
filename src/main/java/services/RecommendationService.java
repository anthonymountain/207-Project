package services;

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
    public Track getRandomRecommendation(String seedArtist, String seedGenre, String seedTrack) {
        final String response = spotifyApiClient.getUserTopItems("", "");
        final JSONObject jsonResponse = new JSONObject(response);
        final JSONArray tracks = jsonResponse.getJSONArray("items");
        final JSONParser jsonParser = new JSONParser();

        final Random random = new Random();
        final JSONObject track = tracks.getJSONObject(random.nextInt(tracks.length()));
        return jsonParser.parse(track);

//        if (tracks.isEmpty()) {
//            //            return null;
//        }
//        else {
//            final Random random = new Random();
//            final JSONObject track = tracks.getJSONObject(random.nextInt(tracks.length()));
//            return jsonParser.parse(track);
//            //            return randomTrack.getString("name") + " by " + randomTrack.getJSONArray("artists")
//            //                    .getJSONObject(0).getString("name");
//        }

    }

    public ArrayList<Artist> getUserTopArtists() {
        return spotifyApiClient.getUserTopArtists();
    }

    public ArrayList<Track> getUserTopTracks() {
        return spotifyApiClient.getUserTopTracks();
    }

    /**
     * Retrieves the artist's top tracks.
     * @param artistId the Spotify ID of the artist.
     * @param market the market for the songs.
     * @return the artist's tracks.
     */
    public ArrayList<Track> getArtistsTopTracks(String artistId, String market) {
        return spotifyApiClient.getArtistTopTracks(artistId, market);
    }

}
