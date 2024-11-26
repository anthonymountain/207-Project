package entity;

/**
 * Factory for creating genres.
 */
public interface GenreFactory {
    /**
     * Creates a new Genre.
     * @param type the type of the new genre
     * @param description the description of the new genre
     * @return the new Genre
     */
    Genre create(String type, String description);

}
