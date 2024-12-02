package interface_adapter.rec_artist;

import java.util.ArrayList;

import entity.*;
import use_case.rec_artist.RecArtistInputBoundary;
import use_case.rec_artist.RecArtistInputData;

public class RecArtistController {
    private final RecArtistInputBoundary interactor;

    public RecArtistController(RecArtistInputBoundary interactor) {
        this.interactor = interactor;
    }

    /**
     * Handles the user action to recommend an artist.
     *
     * @param id    The artist's ID.
     * @param name  The artist's name.
     * @param tracks A list of track names.
     * @param genres A list of genre names.
     */
    public void execute(String id, String name, ArrayList<Track> tracks, ArrayList<Genre> genres) {
        final RecArtistInputData inputData = new RecArtistInputData(id, name, tracks, genres);
        interactor.execute(inputData);
    }
}
