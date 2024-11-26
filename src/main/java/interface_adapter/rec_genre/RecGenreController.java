package interface_adapter.rec_genre;

import entity.CommonGenre;
import use_case.rec_genre.RecGenreInputBoundary;
import use_case.rec_genre.RecGenreInputData;
import use_case.rec_genre.RecGenreOutputData;
import use_case.rec_song.RecSongInputData;
import view.RecGenreView;

import javax.swing.*;

/**
 * Controller for the Recommend Genre Use Case.
 */
public class RecGenreController {

    private final RecGenreInputBoundary recGenreUseCaseInteractor;

    public RecGenreController(RecGenreInputBoundary recGenreUseCaseInteractor) {
        this.recGenreUseCaseInteractor = recGenreUseCaseInteractor;
    }

    /**
     * Executes the Recommend Song Use Case.
     * @param type the genre type
     * @param description the description of the genre
     */
    public void execute(String type, String description) {
        final RecGenreInputData recGenreInputData = new RecGenreInputData(type, description);
        recGenreUseCaseInteractor.execute(recGenreInputData);
    }
}
