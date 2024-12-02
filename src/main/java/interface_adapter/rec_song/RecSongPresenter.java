package interface_adapter.rec_song;

import javax.swing.*;

import interface_adapter.ViewManagerModel;
import use_case.rec_song.RecSongOutputBoundary;
import use_case.rec_song.RecSongOutputData;
import view.RecSongView;

/**
 * This is a presenter for a recommended song.
 */
public class RecSongPresenter implements RecSongOutputBoundary {

    private final RecSongViewModel recSongViewModel;
    private final ViewManagerModel viewManagerModel;

    public RecSongPresenter(ViewManagerModel viewManagerModel, RecSongViewModel recSongViewModel) {
        this.recSongViewModel = recSongViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(RecSongOutputData outputData) {

        // This code tells the View Manager to switch to the RecSongView.
        //        this.viewManagerModel.setState(recSongViewModel.getViewName());
        //        this.viewManagerModel.firePropertyChanged();
        final JDialog dialog = new JDialog(new JFrame(),
                "Song Recommendation", true);
        final RecSongView recSongView = new RecSongView();
        dialog.getContentPane().add(recSongView.getView());
        dialog.pack();
        dialog.setResizable(false);
        //        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }

    @Override
    public void prepareFailView(String errorMessage) {
        // Apparently it can't fail... KABOOM
    }
}
