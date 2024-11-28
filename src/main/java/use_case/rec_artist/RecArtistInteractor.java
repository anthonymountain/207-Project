package use_case.rec_artist;

import entity.Artist;

/**
 * The Recommend Artist Interactor.
 */
public class RecArtistInteractor implements RecArtistInputBoundary {
    private final RecArtistUserDataAccessInterface recArtistUserDataAccessObject;
    private final RecArtistOutputBoundary recArtistPresenter;

    public RecArtistInteractor(RecArtistUserDataAccessInterface recArtistUserDataAccessInterface,
                             RecArtistOutputBoundary recArtistOutputBoundary) {
        this.recArtistUserDataAccessObject = recArtistUserDataAccessInterface;
        this.recArtistPresenter = recArtistOutputBoundary;
    }

    @Override
    public void execute(RecArtistInputData recArtistInputData) {
        final Artist artist = new Artist(recArtistInputData.getId(), recArtistInputData.getName(), 
            recArtistInputData.getTracks(), recArtistInputData.getGenres());
        recArtistUserDataAccessObject.recommendArtist(artist);
        final RecArtistOutputData recArtistOutputData = new RecArtistOutputData(artist.getName(), false);
        recArtistPresenter.prepareSuccessView(recArtistOutputData);
    }
}

