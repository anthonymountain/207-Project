package services;

import entity.*;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import entity.Album;
import interface_adapter.spotify_auth.SpotifyApiClient;

import java.lang.reflect.Array;
import java.util.ArrayList;

@Service
public class AlbumService {

    private final SpotifyApiClient spotifyApiClient;

    public AlbumService(TokenService tokenService) {
        this.spotifyApiClient = new SpotifyApiClient(tokenService);
    }

    /**
     * Gets the most popular new release.
     * @return the most popular new release.
     */
    public Album getMostPopularNewRelease(JSONObject albumJson) {

        final ArtistService artistService = new ArtistService();
        final TrackService trackService = new TrackService();
        final JSONObject jsonObject = new JSONObject(response);
        final JSONArray albums = jsonObject.getJSONObject("albums").getJSONArray("items");

        Album mostPopularAlbum;
        int highestPopularity = -1;

        for (int i = 0; i < albums.length(); i++) {
            final JSONObject albumJson = albums.getJSONObject(i);
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
