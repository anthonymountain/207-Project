package use_case.rec_artist;

import java.util.ArrayList;

import entity.Artist;

/**
 * The Recommend Artist Interactor.
 */
public class RecArtistInteractor implements RecArtistInputBoundary {
    private final RecArtistDataAccessInterface recArtistUserDataAccessObject;
    private final RecArtistOutputBoundary recArtistPresenter;

    public RecArtistInteractor(RecArtistDataAccessInterface recArtistUserDataAccessInterface,
                               RecArtistOutputBoundary recArtistOutputBoundary) {
        this.recArtistUserDataAccessObject = recArtistUserDataAccessInterface;
        this.recArtistPresenter = recArtistOutputBoundary;
    }

    @Override
    public void execute(RecArtistInputData recArtistInputData) {
        final ArrayList<Artist> artists = this.recArtistUserDataAccessObject.getUserTopArtists();
        final Artist artist;
        final int min = 0;
        final int max = artists.size();
        final int random = min + (int) (Math.random() * ((max - min)));
        if (artists.isEmpty()) {
            // Handle null artist (e.g., create a default artist or return a failure response)
            artist = new Artist("default-id", "Peewee", new ArrayList<>());
            recArtistUserDataAccessObject.setArtist(artist);
        }
        else {
            artist = artists.get(random);
            recArtistUserDataAccessObject.setArtist(artist);
        }
        final RecArtistOutputData recArtistOutputData = new RecArtistOutputData(artist, false);
        recArtistPresenter.prepareSuccessView(recArtistOutputData);
    }
}
