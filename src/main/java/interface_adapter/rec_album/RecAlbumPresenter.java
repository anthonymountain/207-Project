package interface_adapter.rec_album;

import interface_adapter.ViewManagerModel;
import use_case.rec_album.RecAlbumOutputBoundary;
import use_case.rec_album.RecAlbumOutputData;
import view.RecAlbumView;

import javax.swing.*;

/**
 * Presenter for the Recommend Album Use Case.
 */
public class RecAlbumPresenter implements RecAlbumOutputBoundary {
    private final RecAlbumViewModel recAlbumViewModel;
    private final ViewManagerModel viewManagerModel;

    public RecAlbumPresenter(RecAlbumViewModel recAlbumViewModel, ViewManagerModel viewManagerModel) {
        this.recAlbumViewModel = recAlbumViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(RecAlbumOutputData outputData) {
        final JDialog dialog = new JDialog(new JFrame(),
                "Album Recommendation", true);
        final RecAlbumView recAlbumView = new RecAlbumView();
        recAlbumView.setAlbumName(outputData.getAlbumName());
        dialog.getContentPane().add(recAlbumView);
        dialog.pack();
        dialog.setResizable(false);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }

    @Override
    public void prepareFailView(RecAlbumOutputData outputData) {
        System.err.println("Error: " + outputData.getMessage());
    }
}