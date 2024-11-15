package use_case.rec_playlist;

/**
 * Input Boundary for actions which are related to logging in.
 */
public interface RecPlaylistInputBoundary {

    /**
     * Executes the Logout use case.
     * @param recSongInputData the input data
     */
    void execute(RecPlaylistInputData recSongInputData);
}
