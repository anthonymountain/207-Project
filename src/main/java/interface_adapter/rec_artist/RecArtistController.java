package interface_adapter.rec_artist;

import entity.Artist;
import use_case.rec_artist.RecArtistInputBoundary;
import use_case.rec_artist.RecArtistInputData;

/**
 * Controller for the Recommend Artist Use Case.
 */
public class RecArtistController {
    private final RecArtistInputBoundary recArtistUseCaseInteractor;

    public RecArtistController(RecArtistInputBoundary recArtistUseCaseInteractor) {
        this.recArtistUseCaseInteractor = recArtistUseCaseInteractor;
    }

    /**
     * Executes the Recommend Artist Use Case.
     * Highly recommend looking at the Recommend Song Use Case to see how to properly use recArtistInputData.
     */
    public void execute() {
        final RecArtistInputData recArtistInputData = new RecArtistInputData();

        recArtistUseCaseInteractor.execute(recArtistInputData);
    }
}
