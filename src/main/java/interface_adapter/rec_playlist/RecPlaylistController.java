package interface_adapter.rec_playlist;

import entity.Playlist;
import use_case.rec_playlist.RecPlaylistInputBoundary;
import use_case.rec_playlist.RecPlaylistInputData;

/**
 * Controller for the Recommend Playlist Use Case.
 */
public class RecPlaylistController {
    private final RecPlaylistInputBoundary recPlaylistUseCaseInteractor;

    public RecPlaylistController(RecPlaylistInputBoundary recPlaylistUseCaseInteractor) {
        this.recPlaylistUseCaseInteractor = recPlaylistUseCaseInteractor;
    }

    /**
     * Executes the Recommend Playlist Use Case.
     * Highly recommend looking at the Recommend Song Use Case to see how to properly use recPlaylistInputData.
     */
    public void execute() {
        final RecPlaylistInputData recPlaylistInputData = new RecPlaylistInputData();

        recPlaylistUseCaseInteractor.execute(recPlaylistInputData);
    }
}
