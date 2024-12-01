package interface_adapter.rec_genre;

import java.util.List;

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
        // Update the ViewModel with data from OutputData
        final List<String> genres = outputData.getGenre().getGenres();
        recGenreViewModel.updateGenres(genres);

        // Trigger state update for the View
        viewManagerModel.setState(recGenreViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}

//    @Override
//    public void prepareFailureView(String errorMessage) {
//        // Populate the ViewModel with an error message
//        recGenreViewModel.setError(errorMessage);
//
//        // Trigger state update for the error view
//        viewManagerModel.setState(recGenreViewModel.getViewName());
//        viewManagerModel.firePropertyChanged();
//    }

