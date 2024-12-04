package data_access;

import entity.Album;

import interface_adapter.spotify_auth.SpotifyAuthController;
import use_case.rec_album.RecAlbumUserDataAccessInterface;

import java.util.ArrayList;

/**
 * In-memory implementation of the DAO for storing album data. This implementation does
 * NOT persist data between runs of the program.
 */
public class InMemoryAlbumDataAccessObject implements RecAlbumUserDataAccessInterface {

    private Album album;
    private ArrayList<Album> newReleases;
    private SpotifyAuthController spotifyAuthController;

    public InMemoryAlbumDataAccessObject(SpotifyAuthController spotifyAuthController) {
        this.newReleases = new ArrayList<>();
        this.spotifyAuthController = spotifyAuthController;
    }

    @Override
    public void setAlbum(Album album) {
        this.album = album;
    }

    @Override
    public Album getAlbum() {
        return this.album;
    }

    @Override
    public ArrayList<Album> getNewReleases() {
        return spotifyAuthController.getNewReleases();
    }
}
