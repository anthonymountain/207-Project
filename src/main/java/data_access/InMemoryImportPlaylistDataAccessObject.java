package data_access;

import entity.Track;
import services.PlaylistService;
import interface_adapter.spotify_auth.SpotifyAuthController;
import use_case.import_playlist.ImportPlaylistDataAccessInterface;
import java.util.ArrayList;
import java.util.List;

public class InMemoryImportPlaylistDataAccessObject implements ImportPlaylistDataAccessInterface {
    private final SpotifyAuthController spotifyAuthController;

    public ImportPlaylistDataAccessObject(SpotifyAuthController spotifyAuthController, ArrayList<Track> trackList) {
        this.spotifyAuthController = spotifyAuthController;
    }

    @Override
    public void savePlaylistData(String playlistName, ArrayList<Track> trackList) {
        try {
            // Convert track list to URI list
            final List<String> trackUris = new ArrayList<>();
            for (Track track : trackList) {
                trackUris.add(track.getUri());
            }

            // Get Spotify user ID using the Auth controller
            final String userId = spotifyAuthController.getCurrentUserProfile();

            // Create a new playlist
            final String playlistId = spotifyAuthController.createPlaylist(userId, playlistName);

            // Add tracks to the playlist
            spotifyAuthController.addTracksToPlaylist(playlistId, trackUris.toArray(new String[0]));

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to save playlist data: " + e.getMessage());
        }
    }
}
