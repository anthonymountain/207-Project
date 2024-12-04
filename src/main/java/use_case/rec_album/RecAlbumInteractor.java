package use_case.rec_album;

import java.util.ArrayList;

import entity.Album;
import services.AlbumService;

/**
 * An Interactor for recommending an album.
 */
public class RecAlbumInteractor implements RecAlbumInputBoundary {
    private final RecAlbumOutputBoundary recAlbumPresenter;
    private final RecAlbumUserDataAccessInterface dataAccessObject;

    public RecAlbumInteractor(RecAlbumOutputBoundary recAlbumPresenter, RecAlbumUserDataAccessInterface dataAccessObject) {
        this.recAlbumPresenter = recAlbumPresenter;
        this.dataAccessObject = dataAccessObject;
    }

    @Override
    public void execute(RecAlbumInputData inputData) {
        // Step 1: Get new releases from Spotify
        final ArrayList<Album> newReleases = this.dataAccessObject.getNewReleases();

        // Find the album with the highest popularity
        final Album mostPopularAlbum = newReleases.stream()
                .max((album1, album2) -> Integer.compare(album1.getPopularity(), album2.getPopularity()))
                .orElse(null);

        // present output (successfully recommend album)
        final RecAlbumOutputData outputData = new RecAlbumOutputData(mostPopularAlbum.getId(),
                mostPopularAlbum.getName(), true, "Album recommended successfully.");
        recAlbumPresenter.prepareSuccessView(outputData);
    }
}
