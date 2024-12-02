package use_case.rec_album;

import java.util.ArrayList;

import entity.Album;
import services.AlbumService;

/**
 * An Interactor for recommending an album.
 */
public class RecAlbumInteractor implements RecAlbumInputBoundary {
    private final RecAlbumOutputBoundary recAlbumPresenter;
    private final RecAlbumDataAccessInterface dataAccessObject;
    private final AlbumService albumService;

    public RecAlbumInteractor(RecAlbumOutputBoundary recAlbumPresenter,
                              AlbumService albumService, RecAlbumDataAccessInterface dataAccessObject) {
        this.recAlbumPresenter = recAlbumPresenter;
        this.albumService = albumService;
        this.dataAccessObject = dataAccessObject;
    }

    @Override
    public void execute(RecAlbumInputData inputData) {
        // Step 1: Get new releases from Spotify
        final ArrayList<Album> newReleases = albumService.getNewReleases();

        if (newReleases.isEmpty()) {
            recAlbumPresenter.prepareFailView(new RecAlbumOutputData(null, null, false, "No new releases found."));
        }

        // Find the album with the highest popularity
        final Album mostPopularAlbum = newReleases.stream()
                .max((album1, album2) -> Integer.compare(album1.getPopularity(), album2.getPopularity()))
                .orElse(null);

        if (mostPopularAlbum == null) {
            recAlbumPresenter.prepareFailView(new RecAlbumOutputData(null, null, false, "No suitable album found for recommendation."));
        }

        // present output (successfully recommend album)
        final RecAlbumOutputData outputData = new RecAlbumOutputData(mostPopularAlbum.getId(), mostPopularAlbum.getName(), true, "Album recommended successfully.");
        recAlbumPresenter.prepareSuccessView(outputData);
    }
}
