package entity;

import java.util.ArrayList;

/**
 * A simple implementation of the Genre interface.
 */
public class CommonGenre implements Genre {
    private final ArrayList<String> genres;

    public CommonGenre(ArrayList<String> genres) {
        this.genres = genres;
    }

    @Override
    public ArrayList<String> getGenres() {
        return genres;
    }
}
