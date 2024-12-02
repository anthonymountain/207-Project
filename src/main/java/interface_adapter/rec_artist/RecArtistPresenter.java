package interface_adapter.rec_artist;

import javax.swing.*;

import interface_adapter.ViewManagerModel;
import use_case.rec_artist.RecArtistInteractor;
import use_case.rec_artist.RecArtistOutputBoundary;
import use_case.rec_artist.RecArtistOutputData;
import view.LoggedInView;
import view.RecArtistView;
import view.RecPlaylistView;
import view.RecSongView;

/**
 * This is a presenter for a recommended artist.
 */
public class RecArtistPresenter implements RecArtistOutputBoundary {

    private final RecArtistViewModel recArtistViewModel;
    private final ViewManagerModel viewManagerModel;

    public RecArtistPresenter(ViewManagerModel viewManagerModel, RecArtistViewModel recArtistViewModel, RecArtistView recArtistView) {
        this.recArtistViewModel = recArtistViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(RecArtistOutputData outputData) {

        // This code tells the View Manager to switch to the RecArtistView.
        //        this.viewManagerModel.setState(recArtistViewModel.getViewName());
        //        this.viewManagerModel.firePropertyChanged();
        final JDialog dialog = new JDialog(new JFrame(),
                "Artist Recommendation", true);
        final RecArtistView recArtistView = new RecArtistView();
        dialog.getContentPane().add(recArtistView.getView());
        dialog.pack();
        dialog.setResizable(false);
        //        dialog.setLocationRelativeTo(dialog);
        dialog.setVisible(true);
    }

    @Override
    public void prepareFailView(String errorMessage) {
        // ¯\_(ツ)_/¯
    }
}
