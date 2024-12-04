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
        final String playlistResponse = spotifyApiClient.createPlaylist(userId, "Recommended Playlist");
        final JSONObject playlist = new JSONObject(playlistResponse);
        final String playlistId = playlist.getString("id");
        spotifyApiClient.addTracksToPlaylist(playlistId, tracks);
        return playlistId;
    }

    public String getCurrentUserProfile() {
        return spotifyApiClient.getCurrentUserProfile();
    }

}
