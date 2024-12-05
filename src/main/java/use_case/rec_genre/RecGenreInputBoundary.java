package use_case.rec_genre;

/**
 * Input Boundary for actions which are related to recommending a genre.
 */
public interface RecGenreInputBoundary {

    /**
     * Executes the RecGenre use case.
     * @param recGenreInputData the input data
     */
    void execute(RecGenreInputData recGenreInputData);
}
