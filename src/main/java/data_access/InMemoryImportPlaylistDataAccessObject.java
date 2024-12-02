package data_access;

import entity.Track;
import services.PlaylistService;
import interface_adapter.spotify_auth.SpotifyAuthController;
import java.util.ArrayList;
import java.util.List;

public class InMemoryImportPlaylistDataAccessObject implements ImportPlaylistDataAccessInterface {
    private final SpotifyAuthController spotifyAuthController;
    private final PlaylistService playlistService;

    public ImportPlaylistDataAccessObject(SpotifyAuthController spotifyAuthController, PlaylistService playlistService) {
        this.spotifyAuthController = spotifyAuthController;
        this.playlistService = playlistService;
    }

    @Override
    public void savePlaylistData(String playlistName, ArrayList<Track> trackList) {
        try {
            // Convert track list to URI list
            List<String> trackUris = new ArrayList<>();
            for (Track track : trackList) {
                trackUris.add(track.getUri());
            }

            // Get Spotify user ID using the Auth controller
            final String userId = spotifyAuthController.getUserProfile().getId();

            // Create a new playlist
            final String playlistId = playlistService.createPlaylist(userId, playlistName);

            // Add tracks to the playlist
            playlistService.addTracksToPlaylist(playlistId, trackUris.toArray(new String[0]));

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to save playlist data: " + e.getMessage());
        }
    }
}
