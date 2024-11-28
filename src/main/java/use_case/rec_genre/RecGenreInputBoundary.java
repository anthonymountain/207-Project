package use_case.rec_genre;

/**
 * Input Boundary for actions which are related to recommending a song.
 */
public interface RecGenreInputBoundary {

    /**
     * Executes the Logout use case.
     * @param recGenreInputData the input data
     * @return returns the output data
     */
    RecGenreOutputData execute(RecGenreInputData recGenreInputData);
}
