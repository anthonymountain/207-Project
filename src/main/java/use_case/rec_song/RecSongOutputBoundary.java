package use_case.rec_song;

/**
 * The output boundary for the RecSong Use Case.
 */
public interface RecSongOutputBoundary {
    /**
     * Prepares the success view for the RecSong Use Case.
     * @param outputData the output data
     */
    void prepareSuccessView(RecSongOutputData outputData);

    /**
     * Prepares the failure view for the RecSong Use Case.
     * @param errorMessage the explanation of the failure
     */
    void prepareFailView(String errorMessage);
}
