package use_case.import_playlist;

import entity.Song;

/**
 * DAO for the Recommend Song Use Case.
 */
public interface ImportPlaylistUserDataAccessInterface {

    /**
     * Recommends a song for the user.
     * @param song the new song
     */
    void recommend(Song song);
    // add duplicate check
    // add previous recommended song retrieval (from list)
    // add recommendation saving (to list)
}
