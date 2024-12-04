package interface_adapter.rec_track;

import javax.swing.*;

import interface_adapter.ViewManagerModel;
import use_case.rec_track.*;
import view.RecTrackView;

/**
 * This is a presenter for a recommended track.
 */
public class RecTrackPresenter implements RecTrackOutputBoundary {

    private final RecTrackViewModel recTrackViewModel;
    private final ViewManagerModel viewManagerModel;

    public RecTrackPresenter(ViewManagerModel viewManagerModel, RecTrackViewModel recTrackViewModel) {
        this.recTrackViewModel = recTrackViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(RecTrackOutputData outputData) {
        final JDialog dialog = new JDialog(new JFrame(),
                "Track Recommendation", true);
        final RecTrackView recTrackView = new RecTrackView();
        recTrackView.setTrack(outputData.getTrack());
        dialog.getContentPane().add(recTrackView);
        dialog.pack();
        dialog.setResizable(false);
        // Makes sure the dialog is centred in the screen.
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }

    @Override
    public void prepareFailView(String errorMessage) {
        // ¯\_(ツ)_/¯
    }
}
