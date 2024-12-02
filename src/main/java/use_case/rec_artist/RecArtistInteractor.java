package use_case.rec_artist;

import java.util.ArrayList;

import entity.Artist;
import interface_adapter.spotify_auth.SpotifyAuthController;
import services.*;

/**
 * The Recommend Artist Interactor.
 */
public class RecArtistInteractor implements RecArtistInputBoundary {
    private final RecArtistUserDataAccessInterface recArtistUserDataAccessObject;
    private final RecArtistOutputBoundary recArtistPresenter;
    private final SpotifyAuthController spotifyAuthController;

    public RecArtistInteractor(RecArtistUserDataAccessInterface recArtistUserDataAccessInterface,
                               RecArtistOutputBoundary recArtistOutputBoundary,
                               SpotifyAuthController spotifyAuthController) {
        this.recArtistUserDataAccessObject = recArtistUserDataAccessInterface;
        this.recArtistPresenter = recArtistOutputBoundary;
        this.spotifyAuthController = spotifyAuthController;
    }

    @Override
    public void execute(RecArtistInputData recArtistInputData) {
        try {
            // fetch top artists
            final ArrayList<Artist> artists = spotifyAuthController.getUserTopArtists("artist", 50);

            // choose a random artist
            final int random = (int) (Math.random() * artists.size());
            final Artist artist = artists.get(random);

            // Save the artist in the DAO
            recArtistUserDataAccessObject.setArtist(artist, spotifyAuthController);

            // Notify the presenter
            final RecArtistOutputData outputData = new RecArtistOutputData(artist.getName(), false);
            recArtistPresenter.prepareSuccessView(outputData);
        }
        catch (SpotifyApiException exception) {
            recArtistPresenter.prepareFailView("Error: Unable to recommend artist. " + exception.getMessage());
        }
    }

    @Override
    public Artist getArtist() {
        return recArtistUserDataAccessObject.getArtist();
    }

}
