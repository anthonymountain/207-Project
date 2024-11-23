package entity;

import java.util.ArrayList;

/**
 * The representation of an artist in our program.
 */
public interface Artist {

    /**
     * Returns the name of the artist.
     * @return the name of the artist.
     */
    String getName();

    /**
     * Returns the artist's songs.
     * @return the list of the artists songs.
     */
    ArrayList<Song> getSongs();
}
