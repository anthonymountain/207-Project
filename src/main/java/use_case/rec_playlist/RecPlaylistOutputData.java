package use_case.rec_playlist;

import entity.Playlist;

/**
 * Output Data for the RecPlaylist Use Case.
 */
public class RecPlaylistOutputData {

    private final Playlist playlist;
    private final boolean useCaseFailed;

    public RecPlaylistOutputData(Playlist playlist, boolean useCaseFailed) {
        this.playlist = playlist;
        this.useCaseFailed = useCaseFailed;
    }

    public Playlist getPlaylist() {
        return playlist;
    }

    public boolean isUseCaseFailed() {
        return useCaseFailed;
    }
}
