package use_case.import_playlist;

import entity.Track;

import java.util.ArrayList;

public interface ImportPlaylistDataAccessInterface {
    void savePlaylistData(ArrayList<Track> tracks);
}
