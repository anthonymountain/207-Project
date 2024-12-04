package use_case.import_playlist;

import use_case.import_playlist.ImportPlaylistDataAccessInterface;

public class ImportPlaylistInteractor implements ImportPlaylistInputBoundary {
    private final ImportPlaylistDataAccessInterface dataAccess;
    private final ImportPlaylistOutputBoundary outputdata;

    public ImportPlaylistInteractor(ImportPlaylistDataAccessInterface dataAccess, ImportPlaylistOutputBoundary outputdata) {
        this.dataAccess = dataAccess;
        this.outputdata = outputdata;
    }

    @Override
    public void importPlaylist(ImportPlaylistInputData inputData) {
        try {
            dataAccess.savePlaylistData(inputData.getTracks());
            outputdata.presentOutput(new ImportPlaylistOutputData(true, "Playlist imported successfully"));
        } catch (Exception e) {
            outputdata.presentOutput(new ImportPlaylistOutputData(false, "Failed to import playlist: " + e.getMessage()));
        }
    }

}
