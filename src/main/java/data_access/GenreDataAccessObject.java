package data_access;

import entity.Genre;
import interface_adapter.spotify_auth.SpotifyAuthController;
import use_case.rec_genre.RecGenreDataAccessInterface;

/**
 * This DAO is going to get data for genres.
 */
public class GenreDataAccessObject implements RecGenreDataAccessInterface {

    private Genre genre;
    private SpotifyAuthController spotifyAuthController;

    public GenreDataAccessObject(SpotifyAuthController spotifyAuthController) {
        this.spotifyAuthController = spotifyAuthController;
    }

    @Override
    public Genre getGenre() {
        return new Genre(spotifyAuthController.getGenres());
    }

    @Override
    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}
