package entity;

import java.util.ArrayList;

/**
 * Represents a track.
 */
public interface Track {
    /**
     * Returns the name of the track.
     * @return the name of the track
     */
    String getName();
    /**
     * Returns the popularity of the track.
     * The value will be between 0 and 100 with 100 being the most popular
     * @return the popularity of the track
     */

    int getPopularity();
    /**
     * Returns the artists of the track.
     *
     * @return the artists of the track
     */

    ArrayList<Artist> getArtists();
}
