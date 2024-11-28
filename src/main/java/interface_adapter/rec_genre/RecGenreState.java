package interface_adapter.rec_genre;

import java.util.List;

/**
 * Represents the state for a recommended genre.
 */
public class RecGenreState {
    private final List<String> genres;

    public RecGenreState() {
        this.genres = List.of();
    }

    public RecGenreState(List<String> genres) {
        this.genres = genres;
    }

    public List<String> getGenres() {
        return genres;
    }
}

