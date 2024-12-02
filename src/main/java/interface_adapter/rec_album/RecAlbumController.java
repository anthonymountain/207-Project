package interface_adapter.rec_album;

import java.util.ArrayList;

import use_case.rec_album.RecAlbumInputBoundary;
import use_case.rec_album.RecAlbumInputData;

/**
 * Controller for the Recommend Album Use Case.
 */
public class RecAlbumController {
    private final RecAlbumInputBoundary recAlbumInteractor;

    public RecAlbumController(RecAlbumInputBoundary inputBoundary) {
        this.recAlbumInteractor = inputBoundary;
    }

    /**
     * Sends the RecAlbumInputData to the Interactor.
     */
    @SuppressWarnings({"checkstyle:LocalFinalVariableName", "checkstyle:SuppressWarnings"})
    public void execute() {
        final String id = "";
        final String name = "";
        final ArrayList<String> artists = null;
        final String album_type = "";
        final ArrayList<Object> images = null;

        recAlbumInteractor.execute(new RecAlbumInputData(id, name, artists, album_type, images));
    }
}
