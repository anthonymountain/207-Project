package entity;

import java.util.ArrayList;

/**
 * Implementation of the Artist interface.
 */
public class CommonArtist implements Artist {
    private final String name;
    private final ArrayList<Track> tracks;

    public CommonArtist(String name, ArrayList<Track> tracks) {
        this.name = name;
        this.tracks = tracks;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public ArrayList<Track> getTracks() {
        return tracks;
    }
}
