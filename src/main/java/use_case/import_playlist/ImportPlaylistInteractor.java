package use_case.import_playlist;

import entity.Song;
import entity.SongFactory;

/**
 * The Recommend Song Interactor.
 */
public class ImportPlaylistInteractor implements ImportPlaylistInputBoundary {
    private final ImportPlaylistUserDataAccessInterface recSongUserDataAccessObject;
    private final ImportPlaylistOutputBoundary recSongPresenter;
    private final SongFactory songFactory;

    public ImportPlaylistInteractor(ImportPlaylistUserDataAccessInterface recSongUserDataAccessInterface,
                                    ImportPlaylistOutputBoundary recSongOutputBoundary,
                                    SongFactory songFactory) {
        this.recSongUserDataAccessObject = recSongUserDataAccessInterface;
        this.recSongPresenter = recSongOutputBoundary;
        this.songFactory = songFactory;
    }

    @Override
    public void execute(ImportPlaylistInputData recSongInputData) {
        final Song song = songFactory.create(recSongInputData.getName(), recSongInputData.getArtist(),
                recSongInputData.getGenre());
        recSongUserDataAccessObject.recommend(song);
        final ImportPlaylistOutputData recSongOutputData = new ImportPlaylistOutputData(song.getName(), false);
        recSongPresenter.prepareSuccessView(recSongOutputData);
    }
}

