package use_case.rec_artist;

/**
 * The output boundary for the RecArtist Use Case.
 */
public interface RecArtistOutputBoundary {
    /**
     * Prepares the success view for the RecArtist Use Case.
     * @param outputData the output data
     */
    void prepareSuccessView(RecArtistOutputData outputData);

    /**
     * Prepares the failure view for the RecArtist Use Case.
     * @param errorMessage the explanation of the failure
     */
    void prepareFailView(String errorMessage);
}
