package interface_adapter.rec_artist;

import javax.swing.*;

import interface_adapter.ViewManagerModel;
import use_case.rec_artist.RecArtistInteractor;
import use_case.rec_artist.RecArtistOutputBoundary;
import use_case.rec_artist.RecArtistOutputData;
import view.LoggedInView;
import view.RecArtistView;
import view.RecPlaylistView;

/**
 * This is a presenter for a recommended artist.
 */
public class RecArtistPresenter implements RecArtistOutputBoundary {
    private final RecArtistView recArtistView;

    public RecArtistPresenter(RecArtistView recArtistView) {
        this.recArtistView = recArtistView;
    }

    @Override
    public void prepareSuccessView(RecArtistOutputData outputData) {
        // handled by controller and view
    }

    @Override
    public void prepareFailView(String errorMessage) {
        // ¯\_(ツ)_/¯
    }
}
