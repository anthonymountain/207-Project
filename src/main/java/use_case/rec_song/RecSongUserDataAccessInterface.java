package use_case.rec_song;

import entity.Song;

/**
 * DAO for the Recommend Song Use Case.
 */
public interface RecSongUserDataAccessInterface {

    /**
     * Recommends a song for the user.
     * @param song the new song
     */
    void recommendSong(Song song);
    // add duplicate check
    // add previous recommended song retrieval (from list)
    // add recommendation saving (to list)
}
