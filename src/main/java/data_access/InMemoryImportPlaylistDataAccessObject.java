package data_access;

import entity.Track;
import services.PlaylistService;
import interface_adapter.spotify_auth.SpotifyAuthController;
import use_case.import_playlist.ImportPlaylistDataAccessInterface;
import java.util.ArrayList;
import java.util.List;

public class InMemoryImportPlaylistDataAccessObject implements ImportPlaylistDataAccessInterface {
    private final SpotifyAuthController spotifyAuthController;

    public InMemoryImportPlaylistDataAccessObject(SpotifyAuthController spotifyAuthController, ArrayList<Track> tracks) {
        this.spotifyAuthController = spotifyAuthController;
    }

    @Override
    public void savePlaylistData(ArrayList<Track> trackList) {
        try {
            // Convert track list to URI list
            String trackUris = "";
            for (Track track : trackList) {
                trackUris = trackUris.concat(track.getUri() + ",");
            }

            // Get Spotify user ID using the Auth controller
            final String userId = spotifyAuthController.getCurrentUserProfile();

            // Create a new playlist
            spotifyAuthController.createPlaylist(userId, trackUris);

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to save playlist data: " + e.getMessage());
        }
    }
}
