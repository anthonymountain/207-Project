package use_case.rec_song;

import java.util.ArrayList;

import entity.Album;
import entity.Artist;

/**
 * The Input Data for the RecSong Use Case.
 */
public class RecSongInputData {

    private final String id;
    private final String name;
    private final int popularity;
    private final Album album;
    private final ArrayList<Artist> artists;

    public RecSongInputData(String id, String name, int popularity, Album album, ArrayList<Artist> artists) {
        this.id = id;
        this.name = name;
        this.popularity = popularity;
        this.album = album;
        this.artists = artists;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPopularity() {
        return popularity;
    }

    public Album getAlbum() {
        return album;
    }

    public ArrayList<Artist> getArtists() {
        return artists;
    }

}
