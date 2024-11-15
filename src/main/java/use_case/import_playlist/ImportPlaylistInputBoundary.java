package use_case.import_playlist;

/**
 * Input Boundary for actions which are related to logging in.
 */
public interface ImportPlaylistInputBoundary {

    /**
     * Executes the Logout use case.
     * @param recSongInputData the input data
     */
    void execute(ImportPlaylistInputData recSongInputData);
}
