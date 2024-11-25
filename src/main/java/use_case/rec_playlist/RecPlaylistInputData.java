package use_case.rec_playlist;

import entity.Playlist;

/**
 * The Input Data for the RecPlaylist Use Case.
 */
public class RecPlaylistInputData {

    private final Playlist playlist;

    public RecPlaylistInputData(Playlist playlist) {
        this.playlist = playlist;
    }

    public Playlist getPlaylist() {
        return playlist;
    }

}
