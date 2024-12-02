package services;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import entity.*;

import java.util.ArrayList;

@Service
public class TrackService {

    /**
     * Parses the JSON object response from the API.
     *
     * @param trackJson the response from the API.
     * @return the Track entity.
     */
    public Track parseTrackFromJson(JSONObject trackJson) {
        // Extract basic fields
        final String id = trackJson.getString("id");
        final String name = trackJson.getString("name");
        final int popularity = trackJson.getInt("popularity");

        //        // Extract nested album information
        //        final JSONObject albumJson = trackJson.getJSONObject("album");
        //        final String albumName = albumJson.getString("name");

        final JSONArray artistJsonArray = trackJson.getJSONArray("artists");
        final ArrayList<Artist> artists = new ArrayList<>();
        final ArtistService artistService = new ArtistService();
        for (int i = 0; i < artistJsonArray.length(); i++) {
            final JSONObject artistJson = artistJsonArray.getJSONObject(i);
            final Artist artist = artistService.parseArtistFromJson(artistJson);
            artists.add(artist);
        }

        return new Track(id, name, popularity, null, artists);
    }
}
