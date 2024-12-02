package use_case.rec_artist;

import entity.Artist;
import interface_adapter.spotify_auth.SpotifyAuthController;

/**
 * DAO for the Recommend Artist Use Case.
 */
public interface RecArtistUserDataAccessInterface {

    /**
     * Set the artist to recommend.
     * @param artist to be recommended.
     * @param spotifyAuthController the authorization controller.
     */
    void setArtist(Artist artist, SpotifyAuthController spotifyAuthController);

    /**
     * Recommends an Artist for the user.
     */
    Artist getArtist();
}
