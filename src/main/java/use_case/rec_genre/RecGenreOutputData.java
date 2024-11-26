package use_case.rec_genre;

import entity.Genre;

/**
 * Output Data for the RecGenre Use Case.
 */
public class RecGenreOutputData {
    private final Genre genre;

    public RecGenreOutputData(Genre genre) {
        this.genre = genre;
    }

    public Genre getGenre() {
        return this.genre;
    }

    public String getType() {
        return this.genre.getType();
    }
}
