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

    /**
     * Converts the genres to a string.
     * @return the genres as a string
     * @see Object#toString()
     * @see ArrayList#toString()
     */
    @Override
    public String toString() {
        return genres.toString();
    }

    /**
     * Converts the genres to a string.
     * @param index the length of the genres.
     * @return the genres as a string
     */
    public String get(int index) {
        return genres.get(index);
    }
}
