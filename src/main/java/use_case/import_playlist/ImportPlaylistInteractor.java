package use_case.import_playlist;

import entity.Playlist;
import entity.SongFactory;

/**
 * The Import Playlist Interactor.
 */
public class ImportPlaylistInteractor implements ImportPlaylistInputBoundary {
    private final ImportPlaylistUserDataAccessInterface importPlaylistUserDataAccessObject;
    private final ImportPlaylistOutputBoundary importPlaylistPresenter;
    private final Playlist playlist;

    public ImportPlaylistInteractor(ImportPlaylistUserDataAccessInterface importPlaylistUserDataAccessInterface,
                                    ImportPlaylistOutputBoundary importPlaylistOutputBoundary,
                                    Playlist playlist) {
        this.importPlaylistUserDataAccessObject = importPlaylistUserDataAccessInterface;
        this.importPlaylistPresenter = importPlaylistOutputBoundary;
        this.playlist = playlist;
    }

    @Override
    public void execute(ImportPlaylistInputData importPlaylistInputData) {
        importPlaylistUserDataAccessObject.importPlaylist(playlist);
//        final ImportPlaylistOutputData recSongOutputData = new ImportPlaylistOutputData(song.getName(), false);
//        importPlaylistPresenter.prepareSuccessView(recSongOutputData);
    }
}

