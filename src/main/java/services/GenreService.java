package services;

import java.util.ArrayList;
import java.util.List;

/**
 * GenreService provides methods for managing genres such as adding, retrieving, and listing genres.
 */
public class GenreService {

    private final List<String> genres;

    /**
     * Constructs a GenreService with initial genres.
     */
    public GenreService() {
        this.genres = new ArrayList<>();
    }

    /**
     * Adds a genre to the genre list.
     *
     * @param genre The genre to add.
     */
    public void addGenre(String genre) {
        if (genre != null && !genre.trim().isEmpty() && !genres.contains(genre.toLowerCase())) {
            genres.add(genre.toLowerCase());
        }
    }

    /**
     * Removes a genre from the genre list.
     *
     * @param genre The genre to remove.
     * @return true if the genre was removed, false if it was not found.
     */
    public boolean removeGenre(String genre) {
        return genres.remove(genre.toLowerCase());
    }

    /**
     * Retrieves all genres currently in the genre list.
     *
     * @return A list of all genres.
     */
    public ArrayList<String> getGenres() {
        return new ArrayList<>(genres);
    }

    /**
     * Checks if a genre is in the genre list.
     *
     * @param genre The genre to check.
     * @return true if the genre is present, false otherwise.
     */
    public boolean containsGenre(String genre) {
        return genres.contains(genre.toLowerCase());
    }
}
