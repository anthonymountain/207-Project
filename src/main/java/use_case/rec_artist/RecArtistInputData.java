package use_case.rec_artist;

import java.lang.reflect.Array;
import java.util.ArrayList;

import entity.*;

/**
 * The Input Data for the RecArtist Use Case.
 * This class encapsulates the data needed to recommend an artist.
 */
public class RecArtistInputData {
    private final String id;
    private final String name;
    private final ArrayList<Track> tracks;
    private final ArrayList<Genre> genres;

    /**
     * Constructor for RecArtistInputData.
     *
     * @param id     The unique identifier for the artist.
     * @param name   The name of the artist.
     * @param tracks A list of track names associated with the artist.
     * @param genres A list of genres associated with the artist.
     */
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

    @Override
    public String toString() {
        return "RecArtistInputData{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", tracks=" + tracks +
                ", genres=" + genres +
                '}';
    }
}
