package data_access;

import java.util.ArrayList;

import entity.Artist;
import entity.Track;
import interface_adapter.spotify_auth.SpotifyAuthController;
import use_case.rec_artist.RecArtistDataAccessInterface;

/**
 * In-memory implementation of the DAO for storing artist data. This implementation does
 * NOT persist data between runs of the program.
 */
public class InMemoryArtistDataAccessObject implements RecArtistDataAccessInterface {

    private Artist artist;
    private ArrayList<Track> tracks;
    private SpotifyAuthController spotifyAuthController;

    public InMemoryArtistDataAccessObject(SpotifyAuthController spotifyAuthController) {
        this.spotifyAuthController = spotifyAuthController;
        this.tracks = new ArrayList<>();
    }

    @Override
    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    @Override
    public Artist getArtist() {
        return this.artist;
    }

    @Override
    public ArrayList<Artist> getUserTopArtists() {
        return spotifyAuthController.getUserTopArtists();
    }

    @Override
    public ArrayList<Track> getArtistsTopTracks() {
        return spotifyAuthController.getArtistsTopTracks(this.artist.getId(), "");
    }

    /**
     * Sets the tracks of the artist.
     */
    public void setTracks() {
        this.tracks = getArtistsTopTracks();
    }
}
