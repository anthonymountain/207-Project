package data_access;

import entity.Track;
import use_case.rec_playlist.RecPlaylistDataAccessInterface;

import java.util.ArrayList;

/**
 * This is a DAO for the unit test.
 */
public class TestPlaylistDataAccessObject implements RecPlaylistDataAccessInterface {
    @Override
    public ArrayList<Track> getRecommendations() {
        return null;
    }
}
