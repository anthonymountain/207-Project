package use_case.rec_playlist;

import entity.DisplayPlaylist;
import entity.Playlist;

/**
 * Output Data for the RecPlaylist Use Case.
 */
public class RecPlaylistOutputData {

    private final DisplayPlaylist playlist;
    private final boolean useCaseFailed;

    public RecPlaylistOutputData(DisplayPlaylist playlist, boolean useCaseFailed) {
        this.playlist = playlist;
        this.useCaseFailed = useCaseFailed;
    }

    public DisplayPlaylist getPlaylist() {
        return playlist;
    }

    //    public boolean isUseCaseFailed() {
    //        return useCaseFailed;
    //    }
}
