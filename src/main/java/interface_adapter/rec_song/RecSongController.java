package interface_adapter.rec_song;

import java.util.ArrayList;

import entity.Album;
import entity.Artist;
import entity.Genre;
import entity.Track;
import use_case.rec_song.RecSongInputBoundary;
import use_case.rec_song.RecSongInputData;

/**
 * Controller for the Recommend Song Use Case.
 */
public class RecSongController {
    private final RecSongInputBoundary recSongUseCaseInteractor;

    public RecSongController(RecSongInputBoundary recSongUseCaseInteractor) {
        this.recSongUseCaseInteractor = recSongUseCaseInteractor;
    }

    /**
     * Sends the RecSongInputData to the Interactor.
     */
    public void execute() {
        final String id = "";
        final String name = "";
        final int popularity = 0;
        final Album album = null;
        final ArrayList<Artist> artists = null;

        recSongUseCaseInteractor.execute(new RecSongInputData(id, name, popularity, album, artists));
    }

    /**
     * Add a song to playlist.
     * Not implemented.
     */
    public void addToPlaylist() {
    }
}
