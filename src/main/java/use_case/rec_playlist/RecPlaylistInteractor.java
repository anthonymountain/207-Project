package use_case.rec_playlist;

import entity.CommonPlaylist;
import entity.Playlist;

/**
 * The Recommend Playlist Interactor.
 */
public class RecPlaylistInteractor implements RecPlaylistInputBoundary {
    private final RecPlaylistDataAccessInterface recPlaylistUserDataAccessObject;
    private final RecPlaylistOutputBoundary recPlaylistPresenter;

    public RecPlaylistInteractor(RecPlaylistDataAccessInterface recPlaylistUserDataAccessInterface,
                                 RecPlaylistOutputBoundary recPlaylistOutputBoundary) {
        this.recPlaylistUserDataAccessObject = recPlaylistUserDataAccessInterface;
        this.recPlaylistPresenter = recPlaylistOutputBoundary;
    }

    @Override
    public void execute(RecPlaylistInputData recPlaylistInputData) {
        // Note: eventually we will have to take our input data and insert it into our DAO so that we can get a proper
        // recommendation.
        recPlaylistPresenter.prepareFailView("error, playlist was not generated, please try again.");
        final Playlist playlist = new CommonPlaylist();
        recPlaylistUserDataAccessObject.recommend();
        final RecPlaylistOutputData recPlaylistOutputData = new RecPlaylistOutputData(playlist, false);
        recPlaylistPresenter.prepareSuccessView(recPlaylistOutputData);
    }
}
