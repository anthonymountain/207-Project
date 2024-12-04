package interface_adapter.rec_playlist;

import interface_adapter.ViewManagerModel;
import services.StorePlaylistService;
import use_case.rec_playlist.RecPlaylistOutputBoundary;
import use_case.rec_playlist.RecPlaylistOutputData;
import view.RecPlaylistView;

import javax.swing.*;
import java.awt.*;

/**
 * This is a presenter for a recommended song.
 */
public class RecPlaylistPresenter implements RecPlaylistOutputBoundary {

    private final RecPlaylistViewModel recPlaylistViewModel;
    private final ViewManagerModel viewManagerModel;
    private StorePlaylistService storePlaylistService;

    public RecPlaylistPresenter(ViewManagerModel viewManagerModel, RecPlaylistViewModel recPlaylistViewModel, StorePlaylistService storePlaylistService) {
        this.recPlaylistViewModel = recPlaylistViewModel;
        this.viewManagerModel = viewManagerModel;
        this.storePlaylistService = storePlaylistService;
    }

    @Override
    public void prepareSuccessView(RecPlaylistOutputData outputData) {
        final JDialog dialog = new JDialog(new JFrame(),
                "Playlist Recommendation", true);
        final RecPlaylistView recPlaylistView = new RecPlaylistView(this.storePlaylistService);
        recPlaylistView.setPlaylist(outputData.getPlaylist());
        dialog.getContentPane().add(recPlaylistView);
        dialog.pack();
        dialog.setResizable(false);
        // Makes sure the dialog is centred in the screen.
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }

    @Override
    public void prepareFailView(String errorMessage) {
        // Apparently it can't fail... KABOOM
    }
}
