package services;

import entity.Track
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import interface_adapter.spotify_auth.SpotifyApiClient;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlaylistService {

    private final SpotifyApiClient spotifyApiClient;

    public PlaylistService(TokenService tokenService) {
        this.spotifyApiClient = new SpotifyApiClient(tokenService);
    }

    public String createPlaylistForRecommendations(String userId, ArrayList<Track> tracks) {
        final String playlistResponse = spotifyApiClient.createPlaylist(userId, "Recommended Playlist");
        final JSONObject playlist = new JSONObject(playlistResponse);
        final String playlistId = playlist.getString("id");
        for (Track track : tracks) {
            spotifyApiClient.addTracksToPlaylist(playlistId, track.getUri());
        }
        return playlistId;
    }

    public String createArtistPlaylist(String userId, String artistId, JSONArray topTracks) {
        final String playlistResponse = spotifyApiClient.createPlaylist(userId, "Artist Playlist");
        final JSONObject playlist = new JSONObject(playlistResponse);
        final String playlistId = playlist.getString("id");

        spotifyApiClient.addTracksToPlaylist(playlistId, topTracks);
        return playlistId;
    }

    public void addTracksToPlaylist(String playlistId, String[] trackUris) {
        spotifyApiClient.addTracksToPlaylist(playlistId, trackUris);
    }

    public String getCurrentUserProfile() {
        return spotifyApiClient.getCurrentUserProfile();
    }

}
