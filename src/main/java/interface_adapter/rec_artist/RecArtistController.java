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
     * @param inputData the input data for the interactor
     */
    public void execute(RecArtistInputData inputData) {
        interactor.execute(inputData);
    }

}
