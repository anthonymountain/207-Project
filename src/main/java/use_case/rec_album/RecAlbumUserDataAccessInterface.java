package use_case.rec_album;

import entity.Album;

import java.util.ArrayList;

/**
 * DAO for the Recommend Album Use Case.
 */
public interface RecAlbumUserDataAccessInterface {

    /**
     * Sets the album to be stored.
     * @param album the new Album
     */
    void setAlbum(Album album);

    /**
     * Retrieve the album.
     * @return the album.
     */
    Album getAlbum();

    /**
     * Get new album releases on Spotify.
     * @return new album releases
     */
    ArrayList<Album> getNewReleases();
}
