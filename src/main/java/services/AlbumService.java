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
     * Gets the most popular new release.
     * @param albumJson the JSON object response from the API.
     * @return the most popular new release.
     */
    public Album getMostPopularNewRelease(JSONObject albumJson) {

        final ArtistService artistService = new ArtistService();
        final TrackService trackService = new TrackService();
        final JSONArray albums = albumJson.getJSONArray("items");

        Album mostPopularAlbum = new Album("", "", 0, new ArrayList<Artist>(), new ArrayList<Track>());
        int highestPopularity = -1;

        for (int i = 0; i < albums.length(); i++) {
            final int popularity = albumJson.getInt("popularity");

            if (popularity > highestPopularity) {
                highestPopularity = popularity;
                final ArrayList<Artist> artists = new ArrayList<>();
                final JSONArray artistArray = albumJson.getJSONArray("artists");
                for (int j = 0; j < artistArray.length(); j++) {
                    final JSONObject artistJson = artistArray.getJSONObject(j);
                    artists.add(artistService.parseArtistFromJson(artistJson));
                }
                final ArrayList<Track> tracks = new ArrayList<>();
                final JSONArray trackArray = albumJson.getJSONObject("tracks").getJSONArray("items");
                for (int j = 0; j < trackArray.length(); j++) {
                    final JSONObject trackJson = trackArray.getJSONObject(j);
                    tracks.add(trackService.parseTrackFromJson(trackJson));
                }
                mostPopularAlbum = new Album(
                        albumJson.getString("id"),
                        albumJson.getString("name"),
                        albumJson.getInt("popularity"),
                        artists,
                        tracks
                );
            }
        }

        return mostPopularAlbum;
    }
}
