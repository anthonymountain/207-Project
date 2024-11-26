package entity;

import java.util.ArrayList;

/**
 * Represents a playlist.
 */
public class Playlist {
    private final String id;
    private final String name;
    private final ArrayList<Track> tracks;

    public Playlist(String id, String name, ArrayList<Track> tracks) {
        this.id = id;
        this.name = name;
        this.tracks = tracks;
    }

    /**
     * Returns the id of the playlist.
     *
     * @return the id of the playlist
     */
    public String getId() {
        return id;
    }

    /**
     * Returns the name of the playlist.
     *
     * @return the name of the playlist
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the tracks of the playlist.
     *
     * @return the tracks of the playlist
     */
    public ArrayList<Track> getTracks() {
        return tracks;
    }
}
