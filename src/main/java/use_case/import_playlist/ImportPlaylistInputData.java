package use_case.import_playlist;

import entity.Track;

import java.util.ArrayList;

public class ImportPlaylistInputData {
    private final ArrayList<Track> tracks;

    public ImportPlaylistInputData(ArrayList<Track> tracks) {
        this.tracks = tracks;
    }

    public ArrayList<Track> getTracks() {
        return tracks;
    }
}
