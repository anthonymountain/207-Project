package interface_adapter.import_playlist;

import use_case.import_playlist.ImportPlaylistOutputBoundary;
import use_case.import_playlist.ImportPlaylistOutputData;

public class ImportPlaylistPresenter implements ImportPlaylistOutputBoundary {
    @Override
    public void presentOutput(ImportPlaylistOutputData outputData) {
        if (outputData.isSuccess()) {
            System.out.println("Success: " + outputData.getMessage());
        } else {
            System.err.println("Error: " + outputData.getMessage());
        }
    }
}
