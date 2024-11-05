package interface_adapter.rec_song;

import interface_adapter.ViewManagerModel;
import interface_adapter.change_password.LoggedInViewModel;
import interface_adapter.login.LoginViewModel;
import use_case.rec_song.RecSongOutputBoundary;
import use_case.rec_song.RecSongOutputData;

public class RecSongPresenter implements RecSongOutputBoundary {

    private final RecSongViewModel recSongViewModel;
    private final ViewManagerModel viewManagerModel;

    public RecSongPresenter(ViewManagerModel viewManagerModel, RecSongViewModel recSongViewModel) {
        this.recSongViewModel = recSongViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(RecSongOutputData outputData) {

        // This code tells the View Manager to switch to the LoginView.
        this.viewManagerModel.setState(recSongViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String errorMessage) {

    }
}
