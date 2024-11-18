package entity;

import java.util.ArrayList;

/**
 * Represents an album.
 */
public interface Album {
    /**
     * Returns the name of the album.
     * @return the name of the album
     */
    String getName();

    /**
     * Returns the popularity of the album.
     * The value will be between 0 and 100 with 100 being the most popular
     * @return the popularity of the album
     */
    int getPopularity();

    /**
     * Returns the artists of the album.
     * @return the artists of the album
     */
    ArrayList<Artist> getArtists();
}
