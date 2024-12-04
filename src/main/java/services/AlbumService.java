package services;

import entity.*;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import entity.Album;

import java.util.ArrayList;

@Service
public class AlbumService {

    /**
     * Parses a single album JSON object into an Album entity.
     * @param albumJson the JSON object representing a single album.
     * @return an Album object.
     */
    public Album getMostPopularNewRelease(JSONObject albumJson) {
        final ArtistService artistService = new ArtistService();
        final TrackService trackService = new TrackService();

        // Extract artists
        final ArrayList<Artist> artists = new ArrayList<>();
        final JSONArray artistArray = albumJson.getJSONArray("artists");
        for (int j = 0; j < artistArray.length(); j++) {
            final JSONObject artistJson = artistArray.getJSONObject(j);
            artists.add(artistService.parseArtistFromJson(artistJson));
        }

        // Tracks are not always included directly in the album JSON; handle gracefully
        final ArrayList<Track> tracks = new ArrayList<>();
        if (albumJson.has("tracks") && albumJson.getJSONObject("tracks").has("items")) {
            final JSONArray trackArray = albumJson.getJSONObject("tracks").getJSONArray("items");
            for (int j = 0; j < trackArray.length(); j++) {
                final JSONObject trackJson = trackArray.getJSONObject(j);
                tracks.add(trackService.parseTrackFromJson(trackJson));
            }
        }

        // Construct the Album object
        return new Album(
                albumJson.getString("id"),
                albumJson.getString("name"),
                albumJson.optInt("popularity", 0),
                // Use 0 as a default if popularity is missing
                artists,
                tracks
        );
    }
}
