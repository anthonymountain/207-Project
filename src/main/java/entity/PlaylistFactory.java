package entity;

import java.util.ArrayList;

/**
 * Factory for creating playlists.
 */
public interface PlaylistFactory {
    /**
     * Creates a new Playlist.
     * @param name the name of the new playlist
     * @param tracks the tracks of the new playlist
     * @return the new playlist
     */
    Playlist create(String name, ArrayList<Track> tracks);
}
