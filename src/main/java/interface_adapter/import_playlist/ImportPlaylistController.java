package interface_adapter.import_playlist;

import entity.Playlist;
import entity.Track;
import services.StorePlaylistService;
import use_case.import_playlist.ImportPlaylistInputBoundary;
import use_case.import_playlist.ImportPlaylistInputData;
import use_case.import_playlist.ImportPlaylistInteractor;

import java.util.ArrayList;

public class ImportPlaylistController {
    private final ImportPlaylistInputBoundary interactor;

    public ImportPlaylistController(ImportPlaylistInputBoundary inputBoundary) {
        this.interactor = inputBoundary;
    }

    public void execute(StorePlaylistService service) {
        final ImportPlaylistInputData inputData = new ImportPlaylistInputData(service);
        interactor.importPlaylist(inputData);
    }
}
