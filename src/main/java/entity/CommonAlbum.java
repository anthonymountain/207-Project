package entity;

import java.util.ArrayList;

/**
 * Implementation of an album.
 */
public class CommonAlbum implements Album {

    private final String name;
    private final int popularity;
    private final ArrayList<Artist> artists;

    public CommonAlbum(String name, int popularity, ArrayList<Artist> artists) {
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
