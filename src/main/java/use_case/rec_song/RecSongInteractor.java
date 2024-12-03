package use_case.rec_song;

import entity.Track;

/**
 * The Recommend Song Interactor.
 */
public class RecSongInteractor implements RecSongInputBoundary {
    private final RecSongDataAccessInterface recSongUserDataAccessObject;
    private final RecSongOutputBoundary recSongPresenter;

    public RecSongInteractor(RecSongDataAccessInterface recSongUserDataAccessInterface,
                             RecSongOutputBoundary recSongOutputBoundary) {
        this.recSongUserDataAccessObject = recSongUserDataAccessInterface;
        this.recSongPresenter = recSongOutputBoundary;
    }

    @Override
    public void execute(RecSongInputData recSongInputData) {
        final Track track = new Track(recSongInputData.getId(), recSongInputData.getName(),
                recSongInputData.getPopularity(), recSongInputData.getAlbum(), recSongInputData.getArtists());
        recSongUserDataAccessObject.setTrack(track);
        final RecSongOutputData recSongOutputData = new RecSongOutputData(track.getName(), false);
        recSongPresenter.prepareSuccessView(recSongOutputData);
    }
}

