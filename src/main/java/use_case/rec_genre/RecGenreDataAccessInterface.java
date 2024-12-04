package use_case.rec_genre;

import entity.Genre;

/**
 * DAO interface for the Recommend Song Use Case.
 */
public interface RecGenreDataAccessInterface {

    /**
     * Recommends a song for the user.
     * @param genre the new song
     */
    void recommendGenre(Genre genre);
    // add duplicate check
    // add previous recommended song retrieval (from list)
    // add recommendation saving (to list)
}
