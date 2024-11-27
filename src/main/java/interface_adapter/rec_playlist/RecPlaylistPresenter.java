package interface_adapter.rec_playlist;

import interface_adapter.ViewManagerModel;
import use_case.rec_playlist.RecPlaylistOutputBoundary;
import use_case.rec_playlist.RecPlaylistOutputData;

/**
 * This is a presenter for a recommended song.
 */
public class RecPlaylistPresenter implements RecPlaylistOutputBoundary {

    private final RecPlaylistViewModel recPlaylistViewModel;
    private final ViewManagerModel viewManagerModel;

    public RecPlaylistPresenter(ViewManagerModel viewManagerModel, RecPlaylistViewModel recPlaylistViewModel) {
        this.recPlaylistViewModel = recPlaylistViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(RecPlaylistOutputData outputData) {
        // Tells the ViewManager to switch to the RecPlaylistView.
        this.viewManagerModel.setState(recPlaylistViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String errorMessage) {
        // Apparently it can't fail... KABOOM
    }
}
