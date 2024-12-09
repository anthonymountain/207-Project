package use_case.import_playlist;

import entity.Track;
import services.PlaylistService;
import services.StorePlaylistService;

import java.util.ArrayList;

public class ImportPlaylistInputData {
    private final StorePlaylistService service;

    public ImportPlaylistInputData(StorePlaylistService service) {

        this.service = service;
    }

    public StorePlaylistService getTracks() {
        return service;
    }
}
