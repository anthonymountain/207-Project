package interface_adapter.import_playlist;

import entity.Track;
import use_case.import_playlist.ImportPlaylistInputBoundary;
import use_case.import_playlist.ImportPlaylistInputData;
import use_case.import_playlist.ImportPlaylistInteractor;

import java.util.ArrayList;

public class ImportPlaylistController {
    private final ImportPlaylistInputBoundary inputBoundary;
    private final ImportPlaylistInteractor interactor;


    public ImportPlaylistController(ImportPlaylistInputBoundary inputBoundary, ImportPlaylistInteractor interactor) {
        this.inputBoundary = inputBoundary;
        this.interactor = interactor;
    }

    public void execute(ArrayList<Track> tracks) {
        final ImportPlaylistInputData inputData = new ImportPlaylistInputData(tracks);
        inputBoundary.importPlaylist(inputData);
    }
}
