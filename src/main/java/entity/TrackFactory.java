package entity;

import java.util.ArrayList;

/**
 * Represents a factory for creating Track objects.
 */
public interface TrackFactory {
    /**
     * Creates a new Track object.
     * @param name the name of the track
     * @param popularity the popularity of the track
     * @param artists the artists of the track
     * @return a new Track object
     */
    Track create(String name, int popularity, ArrayList<Artist> artists);
}