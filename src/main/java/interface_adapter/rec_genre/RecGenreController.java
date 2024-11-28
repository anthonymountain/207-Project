package interface_adapter.rec_genre;

import use_case.rec_genre.RecGenreInputBoundary;
import use_case.rec_genre.RecGenreInputData;
import use_case.rec_genre.RecGenreOutputData;

/**
 * Controller for the Recommend Genre Use Case.
 */
public class RecGenreController {

    private final RecGenreInputBoundary recGenreUseCaseInteractor;

    public RecGenreController(RecGenreInputBoundary recGenreUseCaseInteractor) {
        this.recGenreUseCaseInteractor = recGenreUseCaseInteractor;
    }

    /**
     * Executes the Recommend Genre Use Case.
     * @return returns the output data for RecGenre.
     */
    public RecGenreOutputData execute() {
        final RecGenreInputData recGenreInputData = new RecGenreInputData();
        return recGenreUseCaseInteractor.execute(recGenreInputData);
    }
}
