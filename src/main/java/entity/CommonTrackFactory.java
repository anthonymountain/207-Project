package entity;

import java.util.ArrayList;

/**
 * A factory for creating CommonTrack objects.
 */
public class CommonTrackFactory implements TrackFactory {
    @Override
    public Track create(String name, int popularity, ArrayList<Artist> artists) {
        return new CommonTrack(name, popularity, artists);
    }
}
