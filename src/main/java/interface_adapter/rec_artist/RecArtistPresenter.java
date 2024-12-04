package interface_adapter.rec_artist;

import javax.swing.*;

import interface_adapter.ViewManagerModel;
import use_case.rec_artist.*;
import view.RecArtistView;

/**
 * This is a presenter for a recommended song.
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
        final JDialog dialog = new JDialog(new JFrame(),
                "Artist Recommendation", true);
        final RecArtistView recArtistView = new RecArtistView();
        recArtistView.setArtist(outputData.getArtist());
        dialog.getContentPane().add(recArtistView);
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
