package use_case.rec_genre;

import entity.Genre;

/**
 * DAO for the Recommend Song Use Case.
 */
public interface RecGenreUserDataAccessInterface {

    /**
     * Recommends a song for the user.
     * @return returns a genre
     */
    Genre recommendGenre();
    // add duplicate check
    // add previous recommended song retrieval (from list)
    // add recommendation saving (to list)
}
