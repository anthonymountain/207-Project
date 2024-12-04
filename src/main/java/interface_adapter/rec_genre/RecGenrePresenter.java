package interface_adapter.rec_genre;

import use_case.rec_genre.RecGenreOutputBoundary;
import use_case.rec_genre.RecGenreOutputData;
import view.RecGenreView;

/**
 * This is a presenter for a recommended genre.
 */
public class RecGenrePresenter implements RecGenreOutputBoundary {

    private final RecGenreViewModel recGenreViewModel;
    private final RecGenreView recGenreView;

    public RecGenrePresenter(RecGenreViewModel recGenreViewModel, RecGenreView recGenreView) {
        this.recGenreViewModel = recGenreViewModel;
        this.recGenreView = recGenreView;
    }

    @Override
    public void prepareSuccessView(RecGenreOutputData outputData) {
        // Update the view model with the data
        recGenreViewModel.setGenreName(outputData.getGenreName());

        // Notify the view with updated data
        recGenreView.update(recGenreViewModel);
    }

    @Override
    public void prepareFailView(String errorMessage) {
        // Update the ViewModel with the error message
        recGenreViewModel.setErrorMessage(errorMessage);
        recGenreView.update(recGenreViewModel);
    }
}

