package entity;

import java.util.ArrayList;

/**
 * Implementation of an album.
 */
public class Album {
    private final String id;
    private final String name;
    private final int popularity;
    private final ArrayList<Artist> artists;
    private final ArrayList<Track> tracks;
    private final ArrayList<Genre> genres;

    public Album(String id, String name, int popularity, ArrayList<Artist> artists, ArrayList<Track> tracks, ArrayList<Genre> genres) {
        this.id = id;
        this.name = name;
        this.popularity = popularity;
        this.artists = artists;
        this.tracks = tracks;
        this.genres = genres;
    }

    /**
     * Returns the id of the album.
     *
     * @return the id of the album
     */
    public String getId() {
        return id;
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

    /**
     * Returns the tracks of the album.
     *
     * @return the tracks of the album
     */
    public ArrayList<Track> getTracks() {
        return tracks;
    }

    /**
     * Returns the genres of the album.
     *
     * @return the genres of the album
     */
    public ArrayList<Genre> getGenres() {
        return genres;
    }

}
