package interface_adapter.rec_playlist;

import interface_adapter.ViewManagerModel;
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

    public RecPlaylistPresenter(ViewManagerModel viewManagerModel, RecPlaylistViewModel recPlaylistViewModel) {
        this.recPlaylistViewModel = recPlaylistViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(RecPlaylistOutputData outputData) {
        final JDialog dialog = new JDialog(new JFrame(),
                "Playlist Recommendation", true);
        final RecPlaylistView recPlaylistView = new RecPlaylistView();
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
