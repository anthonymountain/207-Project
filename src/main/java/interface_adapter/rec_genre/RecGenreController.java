package interface_adapter.rec_genre;

import use_case.rec_genre.RecGenreInputBoundary;
import use_case.rec_genre.RecGenreInputData;

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
     */
    public void execute() {
        final RecGenreInputData recGenreInputData = new RecGenreInputData();
        recGenreUseCaseInteractor.execute(recGenreInputData);
    }
}
