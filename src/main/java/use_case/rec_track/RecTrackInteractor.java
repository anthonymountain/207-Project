package use_case.rec_track;

import entity.Track;

import java.util.ArrayList;

/**
 * The Recommend Track Interactor.
 */
public class RecTrackInteractor implements RecTrackInputBoundary {
    private final RecTrackDataAccessInterface recTrackUserDataAccessObject;
    private final RecTrackOutputBoundary recTrackPresenter;

    public RecTrackInteractor(RecTrackDataAccessInterface recTrackUserDataAccessInterface,
                              RecTrackOutputBoundary recTrackOutputBoundary) {
        this.recTrackUserDataAccessObject = recTrackUserDataAccessInterface;
        this.recTrackPresenter = recTrackOutputBoundary;
    }

    @Override
    public void execute(RecTrackInputData recTrackInputData) {
        final ArrayList<Track> tracks = this.recTrackUserDataAccessObject.getUserTopTracks();
        final Track track;
        final int min = 0;
        final int max = tracks.size();
        final int random = min + (int) (Math.random() * ((max - min)));
        if (tracks.isEmpty()) {
            // Handle null track (e.g., create a default track or return a failure response)
            track = new Track("default-id", "Peewee", 0, null, new ArrayList<>());
            recTrackUserDataAccessObject.setTrack(track);
        }
        else {
            track = tracks.get(random);
            recTrackUserDataAccessObject.setTrack(track);
        }
        final RecTrackOutputData recTrackOutputData = new RecTrackOutputData(track, false);
        recTrackPresenter.prepareSuccessView(recTrackOutputData);
    }
}
