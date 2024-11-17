package entity;

import java.util.ArrayList;

/**
 * Represents an artist.
 */
public interface Artist {
    /**
     * Returns the name of the artist.
     * @return the name of the artist
     */
    String getName();

    /**
     * Returns the top tracks of the artist.
     * @return the top tracks of the artist
     */
    ArrayList<Track> getTracks();
}
