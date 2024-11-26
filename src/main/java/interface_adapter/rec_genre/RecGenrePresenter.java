package interface_adapter.rec_genre;

import interface_adapter.ViewManagerModel;
import use_case.rec_genre.RecGenreOutputBoundary;
import use_case.rec_genre.RecGenreOutputData;

/**
 * This is a presenter for a recommended genre.
 */
public class RecGenrePresenter implements RecGenreOutputBoundary {

    private final RecGenreViewModel recGenreViewModel;
    private final ViewManagerModel viewManagerModel;

    public RecGenrePresenter(RecGenreViewModel recGenreViewModel, ViewManagerModel viewManagerModel) {
        this.recGenreViewModel = recGenreViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(RecGenreOutputData outputData) {
        this.viewManagerModel.setState(recGenreViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }
}
