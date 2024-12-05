package use_case.rec_track;

import entity.Track;

import java.util.ArrayList;

/**
 * DAO for the Recommend Song Use Case.
 */
public interface RecTrackDataAccessInterface {

    /**
     * Sets a song.
     * @param track the new song
     */
    void setTrack(Track track);

    /**
     * Retrieves the track.
     * @return the track.
     */
    Track getTrack();

    /**
     * Retrieves user's top tracks.
     * @return the user's top tracks.
     */
    ArrayList<Track> getUserTopTracks();
    // add duplicate check
    // add previous recommended song retrieval (from list)
    // add recommendation saving (to list)
}
