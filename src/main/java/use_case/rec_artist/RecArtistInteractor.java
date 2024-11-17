package use_case.rec_artist;

import entity.Artist;
import entity.ArtistFactory;

/**
 * The Recommend Artist Interactor.
 */
public class RecArtistInteractor implements RecArtistInputBoundary {
    private final RecArtistUserDataAccessInterface recArtistUserDataAccessObject;
    private final RecArtistOutputBoundary recArtistPresenter;
    private final ArtistFactory artistFactory;

    public RecArtistInteractor(RecArtistUserDataAccessInterface recArtistUserDataAccessInterface,
                             RecArtistOutputBoundary recArtistOutputBoundary,
                             ArtistFactory ArtistFactory) {
        this.recArtistUserDataAccessObject = recArtistUserDataAccessInterface;
        this.recArtistPresenter = recArtistOutputBoundary;
        this.artistFactory = ArtistFactory;
    }

    @Override
    public void execute(RecArtistInputData recArtistInputData) {
        final Artist artist = artistFactory.create(recArtistInputData.getName(), recArtistInputData.getSongs());
        recArtistUserDataAccessObject.recommend(artist);
        final RecArtistOutputData recArtistOutputData = new RecArtistOutputData(artist.getName(), false);
        recArtistPresenter.prepareSuccessView(recArtistOutputData);
    }
}

