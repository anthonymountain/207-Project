package use_case.rec_song;

import entity.Song;
import entity.SongFactory;

/**
 * The Recommend Song Interactor.
 */
public class RecSongInteractor implements RecSongInputBoundary {
    private final RecSongUserDataAccessInterface recSongUserDataAccessObject;
    private final RecSongOutputBoundary recSongPresenter;
    private final SongFactory songFactory;

    public RecSongInteractor(RecSongUserDataAccessInterface recSongUserDataAccessInterface,
                             RecSongOutputBoundary recSongOutputBoundary,
                             SongFactory songFactory) {
        this.recSongUserDataAccessObject = recSongUserDataAccessInterface;
        this.recSongPresenter = recSongOutputBoundary;
        this.songFactory = songFactory;
    }

    @Override
    public void execute(RecSongInputData recSongInputData) {
        final Song song = songFactory.create(recSongInputData.getName(), recSongInputData.getArtist(),
                recSongInputData.getGenre());
        recSongUserDataAccessObject.recommend(song);
        final RecSongOutputData recSongOutputData = new RecSongOutputData(song.getName(), false);
        recSongPresenter.prepareSuccessView(recSongOutputData);
    }
}

