package interface_adapter.rec_album;

import use_case.rec_album.RecAlbumOutputBoundary;
import use_case.rec_album.RecAlbumOutputData;

/**
 * Presenter for the Recommend Album Use Case.
 */
public class RecAlbumPresenter implements RecAlbumOutputBoundary {
    @Override
    public void prepareSuccessView(RecAlbumOutputData outputData) {
        System.out.println("Recommended Album: " + outputData.getAlbumName());
    }

    @Override
    public void prepareFailView(RecAlbumOutputData outputData) {
        System.err.println("Error: " + outputData.getMessage());
    }
}