package interface_adapter.rec_song;

import java.util.ArrayList;

import entity.Album;
import entity.Artist;
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
     * Executes the Recommend Song Use Case.
     * @param id the song's id
     * @param name the song's name
     * @param popularity the song's popularity
     * @param album the song's album
     * @param artists the song's artists
     */
    public void execute(String id, String name, int popularity, Album album, ArrayList<Artist> artists) {
        final RecSongInputData recSongInputData = new RecSongInputData(id, name, popularity, album, artists);

        recSongUseCaseInteractor.execute(recSongInputData);
    }

    /**
     * Add a song to playlist.
     * Not implemented.
     */
    public void addToPlaylist() {
    }
}
