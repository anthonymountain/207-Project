package entity;

import java.util.ArrayList;

/**
 * Factory for creating Artist objects.
 */
public interface ArtistFactory {
    /**
     * Creates a new Artist.
     * @param name the name of the new artist
     * @param tracks the top tracks of the new artist
     * @return the new artist
     */
    Artist create(String name, ArrayList<Track> tracks);
}
