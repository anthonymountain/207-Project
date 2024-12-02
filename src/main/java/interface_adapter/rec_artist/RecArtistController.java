package interface_adapter.rec_artist;

import java.util.ArrayList;

import entity.*;
import use_case.rec_artist.*;

public class RecArtistController {
    private final RecArtistInputBoundary interactor;
    private Artist artist;

    public RecArtistController(RecArtistInputBoundary interactor) {
        this.interactor = interactor;
    }

    public void execute() {
        final RecArtistInputData inputData = new RecArtistInputData("", "", null, null);
        interactor.execute(inputData);

        // fetch the recommended artist from the DAO or interactor (updated by execute())
        this.artist = getArtist();
    }

    public Artist getArtist() {
        return interactor.getArtist();
    }
}
