package use_case.rec_album;

import entity.Album;

/**
 * DAO for the Recommend Album Use Case.
 */
public interface RecAlbumUserDataAccessInterface {

    void recommedAlbum(Album album);
}
