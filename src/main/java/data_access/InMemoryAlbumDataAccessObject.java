package data_access;

import entity.Album;
import interface_adapters.spotify_auth.SpotifyAuthController;
import use_case.rec_album.RecAlbumUserDataAccessInterface;


public class InMemoryAlbumDataAccessObject implements RecAlbumDataAccessInterface {
    private final SpotifyAuthController spotifyAuthController;

    public InMemoryAlbumDataAccessObject(SpotifyAuthController spotifyAuthController) {
        this.spotifyAuthController = spotifyAuthController;
    }

    @Override
    public Album recommendAlbum(Album album) {
}
