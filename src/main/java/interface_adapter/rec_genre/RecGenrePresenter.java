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
        // Populate the ViewModel with data from the OutputData
        recGenreViewModel.setGenreType(outputData.getType());
        recGenreViewModel.setGenreDescription(outputData.getDescription());

        // Trigger state update for the View
        viewManagerModel.setState(recGenreViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailureView(String errorMessage) {
        // Populate the ViewModel with an error message
        recGenreViewModel.setError(errorMessage);

        // Trigger state update for the error view
        viewManagerModel.setState(recGenreViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}



//package interface_adapter.rec_genre;
//
//import interface_adapter.ViewManagerModel;
//import use_case.rec_genre.RecGenreOutputBoundary;
//import use_case.rec_genre.RecGenreOutputData;
//
///**
// * This is a presenter for a recommended genre.
// */
//public class RecGenrePresenter implements RecGenreOutputBoundary {
//
//    private final RecGenreViewModel recGenreViewModel;
//    private final ViewManagerModel viewManagerModel;
//
//    public RecGenrePresenter(RecGenreViewModel recGenreViewModel, ViewManagerModel viewManagerModel) {
//        this.recGenreViewModel = recGenreViewModel;
//        this.viewManagerModel = viewManagerModel;
//    }
//
//    @Override
//    public void prepareSuccessView(RecGenreOutputData outputData) {
//        this.viewManagerModel.setState(recGenreViewModel.getViewName());
//        this.viewManagerModel.firePropertyChanged();
//    }
//}
