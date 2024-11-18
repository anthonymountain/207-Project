package entity;

import java.util.ArrayList;

/**
 * Factory for creating genres.
 */
public interface GenreFactory {
    /**
     * Creates a new Genre.
     * @param genres the genres of the new genre
     * @return the new genre
     */
    Genre create(ArrayList<String> genres);
}
