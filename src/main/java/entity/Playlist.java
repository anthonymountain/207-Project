package entity;

import java.util.ArrayList;

/**
 * The representation of a playlist in our program.
 */
public interface Playlist {

    /**
     * Returns the name of the song.
     */
    ArrayList<Song> getSongs();

    /**
     * Adds a song to the playlist.
     * @param song the song to be added.
     */
    void addSong(Song song);
}
