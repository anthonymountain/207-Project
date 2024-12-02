package use_case.rec_playlist;

import entity.DisplayPlaylist;
import entity.Playlist;
import entity.Track;

import java.util.ArrayList;

/**
 * Output Data for the RecPlaylist Use Case.
 */
public class RecPlaylistOutputData {

    private final ArrayList<Track> playlist;
    private final boolean useCaseFailed;

    public RecPlaylistOutputData(ArrayList<Track> playlist, boolean useCaseFailed) {
        this.playlist = playlist;
        this.useCaseFailed = useCaseFailed;
    }

    public ArrayList<Track> getPlaylist() {
        return playlist;
    }

    //    public boolean isUseCaseFailed() {
    //        return useCaseFailed;
    //    }
}
