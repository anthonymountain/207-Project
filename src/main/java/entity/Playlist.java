package entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a playlist.
 */
public class Playlist {
    private final String id;
    private final String name;
    private final ArrayList<Track> tracks;

    /**
     * Creates a playlist.
     *
     * @param id the id of the playlist
     * @param name the name of the playlist
     * @param tracks the tracks of the playlist
     */
    public Playlist(String id, String name, ArrayList<Track> tracks) {
        this.id = id;
        this.name = name;
        this.tracks = tracks;
    }

    /**
     * Null constructor for Playlist.
     */
    public Playlist() {
        this.id = null;
        this.name = null;
        this.tracks = new ArrayList<>();
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
    public List<Track> getTracks() {
        return tracks;
    }
}
