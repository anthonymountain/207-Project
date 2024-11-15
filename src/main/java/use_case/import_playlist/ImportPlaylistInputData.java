package use_case.import_playlist;

import java.util.List;

import entity.Song;

/**
 * The Input Data for the Logout Use Case.
 */
public class ImportPlaylistInputData {

    private final List<Song> playlist;

    public ImportPlaylistInputData(List<Song> playlist) {
        this.playlist = playlist;
    }

    public List<Song> getPlaylist() {
        return playlist;
    }

}
