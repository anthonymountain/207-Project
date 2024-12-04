package use_case.import_playlist;

import entity.Track;
import services.StorePlaylistService;

import java.util.ArrayList;

public interface ImportPlaylistDataAccessInterface {
    void savePlaylistData(StorePlaylistService service);
}
