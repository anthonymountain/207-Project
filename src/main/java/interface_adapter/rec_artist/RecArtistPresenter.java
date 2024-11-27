package interface_adapter.rec_artist;

import interface_adapter.ViewManagerModel;
import use_case.rec_artist.RecArtistOutputBoundary;
import use_case.rec_artist.RecArtistOutputData;

/**
 * This is a presenter for a recommended artist.
 */
public class RecArtistPresenter implements RecArtistOutputBoundary {

    private final RecArtistViewModel recArtistViewModel;
    private final ViewManagerModel viewManagerModel;

    public RecArtistPresenter(ViewManagerModel viewManagerModel, RecArtistViewModel recArtistViewModel) {
        this.recArtistViewModel = recArtistViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(RecArtistOutputData outputData) {

        // This code tells the View Manager to switch to the RecArtistView.
        this.viewManagerModel.setState(recArtistViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String errorMessage) {
        // Apparently it can't fail... KABOOM
    }
}
