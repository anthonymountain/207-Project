package entity;

import java.util.ArrayList;

/**
 * Implementation of the Artist interface.
 */
public class Artist {
    private final String name;
    private final ArrayList<Track> tracks;

    public Artist(String name, ArrayList<Track> tracks) {
        this.name = name;
        this.tracks = tracks;
    }

    /**
     * Returns the name of the artist.
     *
     * @return the name of the artist
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the tracks of the artist.
     *
     * @return the tracks of the artist
     */
    public ArrayList<Track> getTracks() {
        return tracks;
    }
}
