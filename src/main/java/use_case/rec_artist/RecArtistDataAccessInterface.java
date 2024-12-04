package use_case.rec_artist;

import java.util.ArrayList;

import entity.Artist;
import entity.Track;

/**
 * DAO for the Recommend Artist Use Case.
 */
public interface RecArtistDataAccessInterface {

    /**
     * Sets the artist to be stored.
     * @param artist the new Artist
     */
    void setArtist(Artist artist);

    /**
     * Retrieve the artist.
     * @return the artist.
     */
    Artist getArtist();

    /**
     * Retrieve the user's top artists.
     * @return the user's top artists (duh).
     */
    ArrayList<Artist> getUserTopArtists();

    /**
     * Retrieve the given artist's top tracks.
     * @return the artist's top tracks (I wonder what this could do ¯\_(ツ)_/¯).
     */
    ArrayList<Track> getArtistsTopTracks();
}
