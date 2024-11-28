package use_case.rec_artist;

import java.util.ArrayList;

import entity.Genre;
import entity.Track;

/**
 * The Input Data for the RecArtist Use Case.
 */
public class RecArtistInputData {

    private final String id;
    private final String name;
    private final ArrayList<Track> tracks;
    private final ArrayList<Genre> genres;

    public RecArtistInputData(String id, String name, ArrayList<Track> tracks, ArrayList<Genre> genres) {
        this.id = id;
        this.name = name;
        this.tracks = tracks;
        this.genres = genres;
    }
    
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Track> getTracks() {
        return tracks;
    }

    public ArrayList<Genre> getGenres() {
        return genres;
    }
}
