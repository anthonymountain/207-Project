package use_case.rec_genre;

import java.util.ArrayList;

import entity.Artist;
import entity.Genre;

/**
 * DAO interface for the Recommend Song Use Case.
 */
public interface RecGenreDataAccessInterface {

    /**
     * Recommends a song for the user.
     * @param genre the new song
     */
    void recommendGenre(Genre genre);

    /**
     * Retrive the genre.
     * @return the genre.
     */
    Genre getGenre();

    /**
     * Retrieve the user's top artists.
     * @return the user's top artists.
     */
    ArrayList<Artist> getUserTopArtists();
}
