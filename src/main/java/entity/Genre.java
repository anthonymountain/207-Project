package entity;

import java.util.ArrayList;

/**
 * A simple implementation of the Genre interface.
 */
public class Genre implements Genre {
    private final ArrayList<String> genres;

    public Genre(ArrayList<String> genres) {
        this.genres = genres;
    }

    @Override
    public ArrayList<String> getGenres() {
        return genres;
    }
}
