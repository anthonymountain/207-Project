package use_case.rec_genre;

// import use_case.rec_genre.RecGenreOutputData;

/**
 * The output boundary for the RecGenre Use Case.
 */
public interface RecGenreOutputBoundary {
    /**
     * Prepares the success view for the RecGenre Use Case.
     * @param outputData the output data
     */
    void prepareSuccessView(RecGenreOutputData outputData);

    /**
     * Prepares the failure view for the RecGenre Use Case.
     * @param errorMessage the explanation of the failure
     */
    void prepareFailView(String errorMessage);
}