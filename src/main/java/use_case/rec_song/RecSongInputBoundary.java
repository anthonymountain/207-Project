package use_case.rec_song;

/**
 * Input Boundary for actions which are related to logging in.
 */
public interface RecSongInputBoundary {

    /**
     * Executes the Logout use case.
     * @param LogoutInputData the input data
     */
    void execute(RecSongInputData LogoutInputData);
}
