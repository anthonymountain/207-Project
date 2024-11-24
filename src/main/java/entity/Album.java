package entity;

import java.util.ArrayList;

/**
 * Implementation of an album.
 */
public class Album {

    private final String name;
    private final int popularity;
    private final ArrayList<Artist> artists;

    public Album(String name, int popularity, ArrayList<Artist> artists) {
        this.name = name;
        this.popularity = popularity;
        this.artists = artists;
    }

    /**
     * Returns the name of the album.
     *
     * @return the name of the album
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the popularity of the album. The popularity is a value between 0 and 100.
     *
     * @return the popularity of the album
     */
    public int getPopularity() {
        return popularity;
    }

    /**
     * Returns the artists of the album.
     *
     * @return the artists of the album
     */
    public ArrayList<Artist> getArtists() {
        return artists;
    }

}
