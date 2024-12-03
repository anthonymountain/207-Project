package services;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import entity.*;

@Service
public class TrackService {

    /**
     * Parses the JSON object response from the API.
     * @param trackJson the response from the API.
     * @return the artist.
     */
    public Track parseTrackFromJson(JSONObject trackJson) {
        final String id = trackJson.getString("id");
        final String name = trackJson.getString("name");
        final int popularity = trackJson.getInt("popularity");

        // WIP
        final Album album = null;

        // Extract artist details
        final JSONArray artistJsonArray = trackJson.getJSONArray("artists");
        final ArrayList<Artist> artists = parseArtistsFromJson(artistJsonArray);

        // Create and return the Track object
        return new Track(id, name, popularity, album, artists);
    }

    /**
     * Parses a JSON array of artists and creates a list of `Artist` entities.
     *
     * @param artistJsonArray The JSON array containing artist details.
     * @return A list of `Artist` entities.
     */
    private ArrayList<Artist> parseArtistsFromJson(JSONArray artistJsonArray) {
        final ArrayList<Artist> artists = new ArrayList<>();
        for (int i = 0; i < artistJsonArray.length(); i++) {
            final JSONObject artistJson = artistJsonArray.getJSONObject(i);
            final String id = artistJson.getString("id");
            final String name = artistJson.getString("name");
            artists.add(new Artist(id, name, new ArrayList<>()));
        }
        return artists;
    }
}
