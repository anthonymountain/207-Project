package data_access;

import entity.CommonPlaylist;
import entity.Playlist;
import use_case.rec_playlist.RecPlaylistDataAccessInterface;

/**
 * This DAO is going to get data for playlists.
 */
public class InMemoryPlaylistDataAccessObject implements RecPlaylistDataAccessInterface {

    private Playlist playlist;

    @Override
    public Playlist getRecommendations() {
        // Make API call to get recommendation
        final Playlist playlist1 = new CommonPlaylist();
        this.playlist = playlist1;
        // He has a point that the local variable playlist1 is useless.
        // Returns a playlist
        // this.playlist = playlist;
        return null;
    }
}
