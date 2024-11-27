package data_access;

import entity.Playlist;
import use_case.rec_playlist.RecPlaylistDataAccessInterface;

/**
 * This DAO is going to get data for playlists.
 */
public class InMemoryPlaylistDataAccessObject implements RecPlaylistDataAccessInterface {

    private Playlist playlist;

    @Override
    public Playlist recommend() {
        // Make API call to get recommendation
        // Returns a playlist
        // this.playlist = playlist;
        return null;
    }
}
