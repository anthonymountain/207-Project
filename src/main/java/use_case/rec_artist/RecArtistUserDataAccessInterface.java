package use_case.rec_artist;

import entity.Artist;

/**
 * DAO for the Recommend Artist Use Case.
 */
public interface RecArtistUserDataAccessInterface {

    /**
     * Recommends an Artist for the user.
     * @param artist the new Artist
     */
    void recommendArtist(Artist artist);
    // add duplicate check
    // add previous recommended Artist retrieval (from list)
    // add recommendation saving (to list)
}
