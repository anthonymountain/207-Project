package entity;

/**
 * Factory for creating CommonGenre objects.
 */
public class CommonGenreFactory implements GenreFactory {

    @Override
    public Genre create(String type, String description) {
        return new CommonGenre(type, description);
    }
}
