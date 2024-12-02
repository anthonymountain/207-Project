package use_case.rec_album;

import entity.Album;

/**
 * DAO for the Recommend Album Use Case.
 */
public interface RecAlbumDataAccessInterface {
        /**
        * Recommends an album for the user.
        */
        Album getRecommendations();
}
