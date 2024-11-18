package entity;

import java.util.ArrayList;

/**
 * Factory for creating playlists.
 */
public class CommonPlaylistFactory implements PlaylistFactory {
    @Override
    public Playlist create(String name, ArrayList<Track> tracks) {
        return new CommonPlaylist(name, tracks);
    }
}
