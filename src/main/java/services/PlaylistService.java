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

    public String createPlaylistForRecommendations(String userId, JSONArray recommendedTracks) {
        final String playlistResponse = spotifyApiClient.createPlaylist(userId, "Recommended Playlist");
        final JSONObject playlist = new JSONObject(playlistResponse);
        final String playlistId = playlist.getString("id");

        spotifyApiClient.addTracksToPlaylist(playlistId, recommendedTracks);
        return playlistId;
    }

    public String createArtistPlaylist(String userId, String artistId, JSONArray topTracks) {
        final String playlistResponse = spotifyApiClient.createPlaylist(userId, "Artist Playlist");
        final JSONObject playlist = new JSONObject(playlistResponse);
        final String playlistId = playlist.getString("id");

        spotifyApiClient.addTracksToPlaylist(playlistId, topTracks);
        return playlistId;
    }
}
