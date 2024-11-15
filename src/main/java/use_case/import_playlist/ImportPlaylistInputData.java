package use_case.import_playlist;

import entity.Playlist;

/**
 * The Input Data for the Logout Use Case.
 */
public class ImportPlaylistInputData {

    private final Playlist playlist;

    public ImportPlaylistInputData(Playlist playlist) {
        this.playlist = playlist;
    }

    public Playlist getPlaylist() {
        return playlist;
    }

}
