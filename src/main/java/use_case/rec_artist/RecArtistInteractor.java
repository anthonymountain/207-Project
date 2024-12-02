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
            // get top artist's ID
            final String artistId = spotifyAuthController.getUserTopArtists("artist", 1).get(0).getId();

            // fetching artist's related artists
            final ArrayList<Artist> relatedArtists = spotifyAuthController.getRelatedArtists(artistId);
            if (relatedArtists.isEmpty()) {
                throw new SpotifyApiException("No related artists found for the top artist.");
            }
            final Artist recommendedArtist = relatedArtists.get(0);

            // save recommended artist
            recArtistUserDataAccessObject.recommendArtist(recommendedArtist);

            // call presenter to prepare view
            final RecArtistOutputData outputData = new RecArtistOutputData(recommendedArtist.getName(), false);
            recArtistPresenter.prepareSuccessView(outputData);
        }
        catch (SpotifyApiException exception) {
            recArtistPresenter.prepareFailView("Error: " + exception.getMessage());
        }
    }

}
