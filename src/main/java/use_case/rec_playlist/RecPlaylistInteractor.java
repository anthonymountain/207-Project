package use_case.rec_playlist;

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
        // We are also going to have to use our List of Tracks, change it into an ArrayList of songs, and then create
        // a Playlist object that will be passed as Output Data.
        //        recPlaylistPresenter.prepareFailView("error, playlist was not generated, please try again.");
        // Note: the below might have to be a Spotify API client call instead.
        final Playlist playlist = recPlaylistUserDataAccessObject.getRecommendations();
        final RecPlaylistOutputData recPlaylistOutputData = new RecPlaylistOutputData(playlist, false);
        recPlaylistPresenter.prepareSuccessView(recPlaylistOutputData);
    }
}

