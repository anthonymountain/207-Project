package data_access;

import entity.Track;
import interface_adapter.spotify_auth.SpotifyAuthController;
import use_case.rec_song.RecSongDataAccessInterface;

/**
 * In-memory implementation of the DAO for storing song data. This implementation does
 * NOT persist data between runs of the program.
 */
public class InMemorySongDataAccessObject implements RecSongDataAccessInterface {

    private Track track;
    private SpotifyAuthController spotifyAuthController;

    public InMemorySongDataAccessObject(SpotifyAuthController spotifyAuthController) {
        this.spotifyAuthController = spotifyAuthController;
    }

    @Override
    public void setTrack(Track track) {
        this.track = track;
    }
}
