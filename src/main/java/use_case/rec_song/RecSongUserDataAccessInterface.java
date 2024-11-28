package use_case.rec_song;

import entity.Track;

/**
 * DAO for the Recommend Song Use Case.
 */
public interface RecSongUserDataAccessInterface {

    /**
     * Recommends a song for the user.
     * @param track the new song
     */
    void recommendSong(Track track);
    // add duplicate check
    // add previous recommended song retrieval (from list)
    // add recommendation saving (to list)
}
