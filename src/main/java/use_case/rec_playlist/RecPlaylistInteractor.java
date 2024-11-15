package use_case.rec_playlist;

import entity.Playlist;

/**
 * The Import Playlist Interactor.
 */
public class RecPlaylistInteractor implements RecPlaylistInputBoundary {
    private final RecPlaylistUserDataAccessInterface importPlaylistUserDataAccessObject;
    private final RecPlaylistOutputBoundary importPlaylistPresenter;
    private final Playlist playlist;

    public RecPlaylistInteractor(RecPlaylistUserDataAccessInterface importPlaylistUserDataAccessInterface,
                                 RecPlaylistOutputBoundary importPlaylistOutputBoundary,
                                 Playlist playlist) {
        this.importPlaylistUserDataAccessObject = importPlaylistUserDataAccessInterface;
        this.importPlaylistPresenter = importPlaylistOutputBoundary;
        this.playlist = playlist;
    }

    @Override
    public void execute(RecPlaylistInputData importPlaylistInputData) {

    }
}

