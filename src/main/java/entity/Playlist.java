package entity;

import java.util.ArrayList;

/**
 * Represents a playlist.
 */
public class Playlist implements Playlist {
    private final String name;
    private final ArrayList<Track> tracks;

    public Playlist(String name, ArrayList<Track> tracks) {
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
