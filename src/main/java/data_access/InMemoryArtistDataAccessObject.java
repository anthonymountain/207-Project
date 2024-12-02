package data_access;

import java.util.ArrayList;

import entity.Artist;
import interface_adapter.spotify_auth.SpotifyAuthController;
import use_case.rec_artist.RecArtistUserDataAccessInterface;

/**
 * In-memory implementation of the DAO for storing artist data.
 */
public class InMemoryArtistDataAccessObject implements RecArtistUserDataAccessInterface {
    private Artist recommendedArtist;

    @Override
    public void setArtist(Artist artist, SpotifyAuthController spotifyAuthController) {
        this.recommendedArtist = artist;
    }

    @Override
    public Artist getArtist() {
        return this.recommendedArtist;
    }
}
