package services;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import entity.Album;
import interface_adapter.spotify_auth.SpotifyApiClient;

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
    public Album getMostPopularNewRelease() {
        final ArrayList<Album> response = spotifyApiClient.getNewReleases();
        final JSONObject jsonObject = new JSONObject(response);
        final JSONArray albums = jsonObject.getJSONObject("albums").getJSONArray("items");

        Album mostPopularAlbum = null;
        int highestPopularity = -1;

        for (int i = 0; i < albums.length(); i++) {
            final JSONObject albumJson = albums.getJSONObject(i);
            final int popularity = albumJson.getInt("popularity");

            if (popularity > highestPopularity) {
                highestPopularity = popularity;
                mostPopularAlbum = new Album(
                        albumJson.getString("id"),
                        albumJson.getString("name"),
                        albumJson.getInt("popularity"),
                        albumJson.getJSONArray("artists"),
                        albumJson.getJSONArray("tracks"),
                        albumJson.getJSONArray("genres")
                );
            }
        }

        return mostPopularAlbum;
    }
}
