package use_case.rec_playlist;

import entity.DisplayPlaylist;

/**
 * DAO for the Recommend Playlist Use Case.
 */
public interface RecPlaylistDataAccessInterface {

    /**
     * Recommends a playlist for the user.
     */
    DisplayPlaylist getRecommendations();
    // add duplicate check
    // add previous recommended song retrieval (from list)
    // add recommendation saving (to list)
}
