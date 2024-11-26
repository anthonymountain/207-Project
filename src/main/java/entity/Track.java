package entity;

import java.util.ArrayList;

/**
 * Represents a track.
 */
public class Track {
    private final String id;
    private final String name;
    private final int popularity;
    private final Album album;
    private final ArrayList<Artist> artists;

    public Track(String id, String name, int popularity, Album album, ArrayList<Artist> artists) {
        this.id = id;
        this.name = name;
        this.popularity = popularity;
        this.album = album;
        this.artists = artists;
    }

    /**
     * Returns the id of the track.
     *
     * @return the id of the track
     */
    public String getId() {
        return id;
    }

    /**
     * Returns the name of the track.
     *
     * @return the name of the track
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the popularity of the track. The popularity is a value between 0 and 100.
     *
     * @return the popularity of the track
     */
    public int getPopularity() {
        return popularity;
    }

    /**
     * Returns the artists of the track.
     *
     * @return the artists of the track
     */
    public ArrayList<Artist> getArtists() {
        return artists;
    }

    /**
     * Returns the album of the track.
     *
     * @return the album of the track
     */
    public Album getAlbum() {
        return album;
    }
}
