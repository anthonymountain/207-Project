package use_case.rec_track;

/**
 * The output boundary for the RecTrack Use Case.
 */
public interface RecTrackOutputBoundary {
    /**
     * Prepares the success view for the RecTrack Use Case.
     * @param outputData the output data
     */
    void prepareSuccessView(RecTrackOutputData outputData);

    /**
     * Prepares the failure view for the RecTrack Use Case.
     * @param errorMessage the explanation of the failure
     */
    void prepareFailView(String errorMessage);
}
