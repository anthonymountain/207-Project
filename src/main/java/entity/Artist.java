package entity;

import java.util.ArrayList;

/**
 * Implementation of the Artist interface.
 */
public class Artist {
    private final String id;
    private final String name;
    private final ArrayList<Track> tracks;
    private final ArrayList<Genre> genres;

    /**
     * Creates an artist.
     *
     * @param id the id of the artist
     * @param name the name of the artist
     * @param tracks the tracks of the artist
     * @param genres the genres of the artist
     */

    public Artist(String id, String name, ArrayList<Track> tracks, ArrayList<Genre> genres) {
        this.id = id;
        this.name = name;
        this.tracks = tracks;
        this.genres = genres;
    }

    /**
     * Null constructor for Artist.
     */
    public Artist() {
        this.id = null;
        this.name = null;
        this.tracks = new ArrayList<>();
        this.genres = new ArrayList<>();
    }

    /**
     * Returns the id of the artist.
     *
     * @return the id of the artist
     */
    public String getId() {
        return id;
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

    /**
     * Returns the genres of the artist.
     *
     * @return the genres of the artist
     */
    public ArrayList<Genre> getGenres() {
        return genres;
    }
}
