package interface_adapter.import_playlist;

import use_case.import_playlist.ImportPlaylistInputBoundary;
import use_case.import_playlist.ImportPlaylistInputData;

public class ImportPlaylistController {
    private final ImportPlaylistInputBoundary inputBoundary;

    public ImportPlaylistController(ImportPlaylistInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    public void handleImportPlaylistRequest(String spotifyUserId, String playlistName, String[] trackIds) {
        ImportPlaylistInputData inputData = new ImportPlaylistInputData(spotifyUserId, playlistName, trackIds);
        inputBoundary.importPlaylist(inputData);
    }
}
