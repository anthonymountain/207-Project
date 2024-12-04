package data_access;

import java.util.ArrayList;

import entity.Track;
import interface_adapter.spotify_auth.SpotifyAuthController;
import use_case.rec_track.RecTrackDataAccessInterface;

/**
 * In-memory implementation of the DAO for storing track data. This implementation does
 * NOT persist data between runs of the program.
 */
public class InMemoryTrackDataAccessObject implements RecTrackDataAccessInterface {

    private Track track;
    private SpotifyAuthController spotifyAuthController;

    public InMemoryTrackDataAccessObject(SpotifyAuthController spotifyAuthController) {
        this.spotifyAuthController = spotifyAuthController;
    }

    @Override
    public void setTrack(Track track) {
        this.track = track;
    }

    @Override
    public ArrayList<Track> getUserTopTracks() {
        return spotifyAuthController.getUserTopTracks();
    }
}
