package entity;

import java.util.ArrayList;

/**
 * Factory for creating Album objects.
 */
public interface AlbumFactory {
    /**
     * Creates a new Album.
     * @param name the name of the new album
     * @param popularity the popularity of the new album
     * @param artists the artists of the new album
     * @return the new album
     */
    Album create(String name, int popularity, ArrayList<Artist> artists);
}
