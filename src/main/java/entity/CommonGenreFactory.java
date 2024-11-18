package entity;

import java.util.ArrayList;

/**
 * A factory for creating CommonGenre objects.
 */
public class CommonGenreFactory implements GenreFactory {
    @Override
    public Genre create(ArrayList<String> genres) {
        return new CommonGenre(genres);
    }
}
