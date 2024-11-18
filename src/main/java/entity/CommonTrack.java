package entity;

import java.util.ArrayList;

/**
 * Represents a track.
 */
public class CommonTrack implements Track {
    private final String name;
    private final int popularity;
    private final ArrayList<Artist> artists;

    public CommonTrack(String name, int popularity, ArrayList<Artist> artists) {
        this.name = name;
        this.popularity = popularity;
        this.artists = artists;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getPopularity() {
        return popularity;
    }

    @Override
    public ArrayList<Artist> getArtists() {
        return artists;
    }

}
