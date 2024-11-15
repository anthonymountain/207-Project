package use_case.rec_playlist;

import entity.Playlist;

/**
 * The Recommend Playlist Interactor.
 */
public class RecPlaylistInteractor implements RecPlaylistInputBoundary {
    private final RecPlaylistUserDataAccessInterface recPlaylistUserDataAccessObject;
    private final RecPlaylistOutputBoundary recPlaylistPresenter;
    private final Playlist playlist;

    public RecPlaylistInteractor(RecPlaylistUserDataAccessInterface recPlaylistUserDataAccessInterface,
                                 RecPlaylistOutputBoundary recPlaylistOutputBoundary,
                                 Playlist playlist) {
        this.recPlaylistUserDataAccessObject = recPlaylistUserDataAccessInterface;
        this.recPlaylistPresenter= recPlaylistOutputBoundary;
        this.playlist = playlist;
    }

    @Override
    public void execute(RecPlaylistInputData importPlaylistInputData) {
        // Nothing yet
    }
}

