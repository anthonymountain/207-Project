package entity;

import java.util.ArrayList;

/**
 *  Represents a playlist.
 */
public interface Playlist {
    /**
     * Returns the name of the playlist.
     * @return the name of the playlist
     */
    String getName();
    /**
     * Returns the tracks of the playlist.
     * @return the tracks of the playlist
     */
    ArrayList<Track> getTracks();
}
