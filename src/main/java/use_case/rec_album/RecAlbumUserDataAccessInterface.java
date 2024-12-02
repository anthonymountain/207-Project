package use_case.rec_album;

import entity.Album;

/**
 * DAO for the Recommend Album Use Case.
 */
public interface RecAlbumUserDataAccessInterface {

    /**
     * Recommends an Album for the user.
     * @param album the new Album
     */
    void recommendAlbum(Album album);
    // add duplicate check
    // add previous recommended Album retrieval (from list)
    // add recommendation saving (to list)
}
