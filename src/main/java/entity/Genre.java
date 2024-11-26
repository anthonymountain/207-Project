package entity;

import java.util.ArrayList;

/**
 * A simple implementation of the Genre interface.
 */
public class Genre {
    private final ArrayList<String> genres;

    public Genre(ArrayList<String> genres) {
        this.genres = genres;
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
