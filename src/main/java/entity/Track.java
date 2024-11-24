package entity;

import java.util.ArrayList;

/**
 * Represents a track.
 */
public class Track {
    private final String name;
    private final int popularity;
    private final ArrayList<Artist> artists;

    public Track(String name, int popularity, ArrayList<Artist> artists) {
        this.name = name;
        this.popularity = popularity;
        this.artists = artists;
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

}
