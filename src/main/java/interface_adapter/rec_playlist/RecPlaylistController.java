package interface_adapter.rec_playlist;

import use_case.rec_song.RecSongInputBoundary;
import use_case.rec_song.RecSongInputData;

/**
 * Controller for the Recommend Song Use Case.
 */
public class RecPlaylistController {
    private final RecSongInputBoundary recSongUseCaseInteractor;

    public RecPlaylistController(RecSongInputBoundary recSongUseCaseInteractor) {
        this.recSongUseCaseInteractor = recSongUseCaseInteractor;
    }

    /**
     * Executes the Recommend Song Use Case.
     * @param name the song name
     * @param artist the artist of the song
     * @param genre the genre of the song
     */
    public void execute(String name, String artist, String genre) {
        final RecSongInputData recSongInputData = new RecSongInputData(name, artist, genre);

        recSongUseCaseInteractor.execute(recSongInputData);
    }
}
