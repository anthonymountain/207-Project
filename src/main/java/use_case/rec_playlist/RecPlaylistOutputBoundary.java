package use_case.rec_playlist;

/**
 * The output boundary for the RecPlaylist Use Case.
 */
public interface RecPlaylistOutputBoundary {
    /**
     * Prepares the success view for the RecPlaylist Use Case.
     * @param outputData the output data
     */
    void prepareSuccessView(RecPlaylistOutputData outputData);

    /**
     * Prepares the failure view for the RecPlaylist Use Case.
     * @param errorMessage the explanation of the failure
     */
    void prepareFailView(String errorMessage);
}
