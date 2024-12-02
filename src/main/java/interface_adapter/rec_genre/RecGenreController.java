package interface_adapter.rec_genre;

import java.util.ArrayList;

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
     */
    public void execute() {
        final ArrayList<String> genres = new ArrayList<>();
        recGenreUseCaseInteractor.execute(new RecGenreInputData(genres));
    }
}
