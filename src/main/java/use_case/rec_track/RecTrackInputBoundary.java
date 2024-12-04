package use_case.rec_track;

/**
 * Input Boundary for actions which are related to recommending songs.
 */
public interface RecTrackInputBoundary {

    /**
     * Executes the RecSong use case.
     * @param recSongInputData the input data
     */
    void execute(RecTrackInputData recSongInputData);
}
