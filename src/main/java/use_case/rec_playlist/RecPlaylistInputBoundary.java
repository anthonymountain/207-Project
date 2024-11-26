package use_case.rec_playlist;

/**
 * Input Boundary for actions which are related to recommending a playlist.
 */
public interface RecPlaylistInputBoundary {

    /**
     * Executes the RecPlaylist use case.
     * @param recPlaylistInputData the input data
     */
    void execute(RecPlaylistInputData recPlaylistInputData);
}
