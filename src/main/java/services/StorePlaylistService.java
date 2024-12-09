package services;

import java.util.ArrayList;

import entity.Track;
import org.springframework.stereotype.Service;

import entity.AccessToken;

@Service
public class StorePlaylistService {

    private ArrayList<Track> tracks;

    /**
     * Constructor for TokenService.
     */
    public StorePlaylistService() {
        this.tracks = null;
    }

    public void storePlaylist(ArrayList<Track> tracks) {

        this.tracks = tracks;
    }

    /**
     * Get the stored access token.
     *
     * @return The stored access token.
     * @throws IllegalStateException if the token is expired or not available.
     */
    public ArrayList<Track> getPlaylist() {
        return tracks;
    }
}
