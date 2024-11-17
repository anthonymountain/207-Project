package use_case.rec_playlist;

import entity.Playlist;

/**
 * DAO for the Recommend Playlist Use Case.
 */
public interface RecPlaylistUserDataAccessInterface {

    /**
     * Recommends a playlist for the user.
     * @param playlist the playlist.
     */
    Playlist recommend();
    // add duplicate check
    // add previous recommended song retrieval (from list)
    // add recommendation saving (to list)
}
