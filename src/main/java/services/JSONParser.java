package services;

import java.util.ArrayList;

import entity.Artist;
import entity.Track;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * This JsonParser will help parse through the response.
 */
public class JSONParser {

    /**
     * Helps us solve response.
     * @param jsonResponse gives us the argument.
     * @return the playlist we want.
     * @throws RuntimeException if something goes wrong.
     */
    public Track parse(JSONObject jsonResponse) {
        try {
            final ArtistService artistService = new ArtistService();
            // Retrieve the "tracks" JSONArray from the JSONObject
            final JSONArray artistsArray = jsonResponse.getJSONArray("artists");
            final int popularity = jsonResponse.getInt("popularity");
            final String name = jsonResponse.getString("name");
            final String id = jsonResponse.getString("id");

            // Still need to figure out how to parse through the album...
            //            final JSONObject album = jsonResponse.getJSONObject("album");

            final ArrayList<Artist> artists = new ArrayList<>();
            // Iterate through the artists array
            for (int i = 0; i < artistsArray.length(); i++) {
                final JSONObject artist = artistsArray.getJSONObject(i);
                artists.add(artistService.parseArtistFromJson(artist));
            }

            return new Track(id, name, popularity, null, artists);
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
