package data_access;

import entity.Genre;
import interface_adapter.spotify_auth.SpotifyAuthController;
import use_case.rec_genre.RecGenreUserDataAccessInterface;

/**
 * This DAO is going to get data for genres.
 */
public class InMemoryGenreDataAccessObject implements RecGenreUserDataAccessInterface {

    public static final int TEN = 10;
    private SpotifyAuthController spotifyAuthController;

    /**
     * Creates a controller for rec_genre.
     */
    public void inMemoryGenreUserDataAccessObject(SpotifyAuthController spotifyAuthController) {
        this.spotifyAuthController = spotifyAuthController;
    }

    @Override
    public Genre recommendGenre() {
        spotifyAuthController.recGenre();

        // Make API call to get recommendation

    }
}
