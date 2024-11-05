package use_case.rec_song;

/**
 * The Logout Interactor.
 */
public class RecSongInteractor implements RecSongInputBoundary {
    private final RecSongUserDataAccessInterface userDataAccessObject;
    private final RecSongOutputBoundary logoutPresenter;

    public RecSongInteractor(RecSongUserDataAccessInterface userDataAccessInterface,
                             RecSongOutputBoundary logoutOutputBoundary) {
        this.userDataAccessObject = userDataAccessInterface;
        this.logoutPresenter = logoutOutputBoundary;
    }

    @Override
    public void execute(RecSongInputData logoutInputData) {
        final String username = logoutInputData.getUsername();
        this.userDataAccessObject.setCurrentUsername(null);
        final RecSongOutputData logoutOutputData = new RecSongOutputData(username, false);
        logoutPresenter.prepareSuccessView(logoutOutputData);
    }
}

