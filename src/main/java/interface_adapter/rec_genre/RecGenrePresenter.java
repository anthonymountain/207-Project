package interface_adapter.rec_genre;

import interface_adapter.ViewManagerModel;
import use_case.rec_genre.RecGenreOutputBoundary;
import use_case.rec_genre.RecGenreOutputData;
import view.RecGenreView;

import javax.swing.*;

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
        final JDialog dialog = new JDialog(new JFrame(), "Genre Recommendation", true);
        final RecGenreView recGenreView = new RecGenreView();
        recGenreView.setGenre(outputData.getGenre());
        dialog.getContentPane().add(recGenreView);
        dialog.pack();
        dialog.setResizable(false);
        // Makes sure the dialog is centred in the screen.
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }
}

//    @Override
//    public void prepareFailureView(String errorMessage) {
//        // can't have bugs if you don't test for them.

    //}

