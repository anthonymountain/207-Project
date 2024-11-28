package entity;

import java.util.ArrayList;

/**
 * A simple implementation of the Genre interface.
 */
public class Genre {
    private final ArrayList<String> genres;

    /**
     * Creates a genre.
     *
     * @param genres the genres
     */

    public Genre(ArrayList<String> genres) {
        this.genres = genres;
    }

    /**
     * Null constructor for Genre.
     */
    public Genre() {
        this.genres = new ArrayList<>();
    }

    /**
     * Returns the genres.
     *
     * @return the genres
     */
    public ArrayList<String> getGenres() {
        return genres;
    }
}
