package use_case.rec_artist;

import entity.Song;

import java.util.ArrayList;

/**
 * The Input Data for the RecArtist Use Case.
 */
public class RecArtistInputData {

    private final String name;
    private final ArrayList<Song> songs;

    public RecArtistInputData(String name, ArrayList<Song> songs) {
        this.name = name;
        this.songs = songs;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Song> getSongs() {
        return songs;
    }
}
