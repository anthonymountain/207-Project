package data_access;

import entity.Playlist;
import use_case.rec_playlist.RecPlaylistUserDataAccessInterface;

/**
 * This DAO is going to get data for playlists.
 */
public class InMemoryPlaylistDataAccessObject implements RecPlaylistUserDataAccessInterface {

    @Override
    public Playlist recommend() {
        // Make API call to get recommendation
        // Returns a playlist
    }
}
