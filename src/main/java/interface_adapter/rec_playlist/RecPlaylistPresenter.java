package interface_adapter.rec_playlist;

import interface_adapter.ViewManagerModel;
import use_case.rec_song.RecSongOutputBoundary;
import use_case.rec_song.RecSongOutputData;

/**
 * This is a presenter for a recommended song.
 */
public class RecPlaylistPresenter implements RecSongOutputBoundary {

    private final RecPlaylistViewModel recSongViewModel;
    private final ViewManagerModel viewManagerModel;

    public RecPlaylistPresenter(ViewManagerModel viewManagerModel, RecPlaylistViewModel recSongViewModel) {
        this.recSongViewModel = recSongViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(RecSongOutputData outputData) {

        // This code tells the View Manager to switch to the RecSongView.
        this.viewManagerModel.setState(recSongViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String errorMessage) {
        // Apparently it can't fail... KABOOM
    }
}
