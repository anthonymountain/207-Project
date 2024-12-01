package interface_adapter.rec_artist;

import java.util.ArrayList;

import entity.Genre;
import entity.Track;
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
     * Sends the RecArtistInputData to the Interactor.
     */
    public void execute() {
        final String id = "";
        final String name = "";
        final ArrayList<Track> songs = null;
        final ArrayList<Genre> genres = null;

        recArtistUseCaseInteractor.execute(new RecArtistInputData(id, name, songs, genres));
    }

    /**
     * Recommend a song from the artist.
     * Not implemented.
     */
    public void recSong() {
    }
}
