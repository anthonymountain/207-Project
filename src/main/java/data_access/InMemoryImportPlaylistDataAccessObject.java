package data_access;

import entity.Track;
import services.StorePlaylistService;
import interface_adapter.spotify_auth.SpotifyAuthController;
import use_case.import_playlist.ImportPlaylistDataAccessInterface;
import java.util.ArrayList;
import java.util.List;

public class InMemoryImportPlaylistDataAccessObject implements ImportPlaylistDataAccessInterface {
    private SpotifyAuthController spotifyAuthController;
    private StorePlaylistService storePlaylistService;

    public InMemoryImportPlaylistDataAccessObject(SpotifyAuthController spotifyAuthController, StorePlaylistService storePlaylistService) {
        this.spotifyAuthController = spotifyAuthController;
        this.storePlaylistService = storePlaylistService;
    }

    @Override
    public void savePlaylistData(StorePlaylistService storePlaylistService) {
        try {
            // Convert track list to URI list
            String trackUris = "";
            for (Track track : storePlaylistService.getPlaylist()) {
                trackUris = trackUris.concat(track.getUri() + ",");
            }

            // Get Spotify user ID using the Auth controller
            String userId = spotifyAuthController.getCurrentUserProfile();

            // Create a new playlist
            spotifyAuthController.createPlaylist(userId, trackUris);

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to save playlist data: " + e.getMessage());
        }
    }
}
