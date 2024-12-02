package interface_adapter.rec_artist;

import javax.swing.*;

import interface_adapter.ViewManagerModel;
import use_case.rec_artist.RecArtistOutputBoundary;
import use_case.rec_artist.RecArtistOutputData;
import view.RecArtistView;

/**
 * This is a presenter for a recommended artist.
 */
public class RecArtistPresenter implements RecArtistOutputBoundary {
    private RecArtistView recArtistView;

    public RecArtistPresenter(RecArtistView recArtistView) {
        this.recArtistView = recArtistView;
    }

    @Override
    public void prepareSuccessView(RecArtistOutputData recArtistOutputData) {
        recArtistView.updateArtistName(recArtistOutputData.getName());
    }

    @Override
    public void prepareFailView(String errorMessage) {
        recArtistView.updateArtistName("Failed to recommend artist");
    }
}
