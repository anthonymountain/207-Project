package use_case.rec_song;

/**
 * Input Boundary for actions which are related to recommending songs.
 */
public interface RecSongInputBoundary {

    /**
     * Executes the Logout use case.
     * @param recSongInputData the input data
     */
    void execute(RecSongInputData recSongInputData);
}
