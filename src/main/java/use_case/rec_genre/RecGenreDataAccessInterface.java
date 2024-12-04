package use_case.rec_genre;

import entity.Genre;

/**
 * DAO interface for the Recommend Song Use Case.
 */
public interface RecGenreDataAccessInterface {

    /**
     * Retrive the genre.
     * @return the genre.
     */
    Genre getGenre();

    /**
     * Sets the genre.
     * @param genre the genre to be set
     */
    void setGenre(Genre genre);
}
