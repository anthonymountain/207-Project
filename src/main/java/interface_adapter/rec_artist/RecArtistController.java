package interface_adapter.rec_artist;

import java.util.ArrayList;

import entity.Song;
import use_case.rec_artist.RecArtistInputBoundary;
import use_case.rec_artist.RecArtistInputData;

/**
 * Controller for the Recommend Artist Use Case.
 */
public class RecArtistController {
    private final RecArtistInputBoundary recArtistUseCaseInteractor;

    public RecArtistController(RecArtistInputBoundary recArtistUseCaseInteractor) {
        this.recArtistUseCaseInteractor = recArtistUseCaseInteractor;
    }

    /**
     * Executes the Recommend Artist Use Case.
     * @param name the artist name
     * @param songs the artist's songs
     */
    public void execute(String name, ArrayList<Song> songs) {
        final RecArtistInputData recArtistInputData = new RecArtistInputData(name, songs);

        recArtistUseCaseInteractor.execute(recArtistInputData);
    }

    /**
     * Recommend a song from the artist.
     * Not implemented.
     */
    public void recSong() {
    }
}
