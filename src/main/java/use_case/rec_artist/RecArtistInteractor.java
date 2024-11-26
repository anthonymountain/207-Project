package use_case.rec_artist;

import entity.Artist;

/**
 * The Recommend Artist Interactor.
 */
public class RecArtistInteractor implements RecArtistInputBoundary {
    private final RecArtistUserDataAccessInterface recArtistUserDataAccessObject;
    private final RecArtistOutputBoundary recArtistPresenter;
    private final ArtistFactory artistFactory;

    public RecArtistInteractor(RecArtistUserDataAccessInterface recArtistUserDataAccessInterface,
                             RecArtistOutputBoundary recArtistOutputBoundary,
                             ArtistFactory artistFactory) {
        this.recArtistUserDataAccessObject = recArtistUserDataAccessInterface;
        this.recArtistPresenter = recArtistOutputBoundary;
        this.artistFactory = artistFactory;
    }

    @Override
    public void execute(RecArtistInputData recArtistInputData) {
        final Artist artist = artistFactory.create(recArtistInputData.getName(), recArtistInputData.getSongs());
        recArtistUserDataAccessObject.recommendArtist(artist);
        final RecArtistOutputData recArtistOutputData = new RecArtistOutputData(artist.getName(), false);
        recArtistPresenter.prepareSuccessView(recArtistOutputData);
    }
}

