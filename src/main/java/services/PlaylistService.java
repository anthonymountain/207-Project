package services;

import interface_adapter.spotifyauth.SpotifyApiClient;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class PlaylistService {

    private final SpotifyApiClient spotifyApiClient;

    public PlaylistService(SpotifyApiClient spotifyApiClient) {
        this.spotifyApiClient = spotifyApiClient;
    }

    public String createPlaylistForRecommendations(String accessToken, String userId, JSONArray recommendedTracks) {
        final String playlistResponse = spotifyApiClient.createPlaylist(accessToken, userId, "Recommended Playlist");
        final JSONObject playlist = new JSONObject(playlistResponse);
        final String playlistId = playlist.getString("id");

        spotifyApiClient.addTracksToPlaylist(accessToken, playlistId, recommendedTracks);
        return playlistId;
    }

    public String createArtistPlaylist(String accessToken, String userId, String artistId, JSONArray topTracks) {
        final String playlistResponse = spotifyApiClient.createPlaylist(accessToken, userId, "Artist Playlist");
        final JSONObject playlist = new JSONObject(playlistResponse);
        final String playlistId = playlist.getString("id");

        spotifyApiClient.addTracksToPlaylist(accessToken, playlistId, topTracks);
        return playlistId;
    }
}
