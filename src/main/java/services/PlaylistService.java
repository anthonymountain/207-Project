package services;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import interface_adapter.spotify_auth.SpotifyApiClient;

@Service
public class PlaylistService {

    private final SpotifyApiClient spotifyApiClient;

    public PlaylistService(TokenService tokenService) {
        this.spotifyApiClient = new SpotifyApiClient(tokenService);
    }

    public String createPlaylist(String userId, String tracks) {
        System.out.println("createPlaylist" + tracks);
        final String playlistResponse = spotifyApiClient.createPlaylist(userId, "Recommended Playlist 1");
        final JSONObject playlist = new JSONObject(playlistResponse);
        System.out.println(playlist);
        final String playlistId = playlist.getString("id");
        System.out.println("playlistId" + playlistId);
        spotifyApiClient.addTracksToPlaylist(playlistId, tracks);
        return playlistId;
    }

    public String getCurrentUserProfile() {
        return spotifyApiClient.getCurrentUserProfile();
    }

}
