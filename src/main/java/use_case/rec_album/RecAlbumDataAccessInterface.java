package use_case.rec_album;

import entity.Album;

public interface RecAlbumDataAccessInterface {

        /**
        * Recommends an album for the user.
        */
        Album getRecommendations();
}
