package interface_adapter.rec_artist;

import java.util.ArrayList;

import entity.Track;

/**
 * This state is for when an artist is recommended.
 */
public class RecArtistState {
    private String name;
    private ArrayList<Track> songs;

    // No uses yet
    public RecArtistState(RecArtistState copy) {
        name = copy.name;
        songs = copy.songs;
    }

    public RecArtistState() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Track> getSongs() {
        return songs;
    }

    public void setSongs(ArrayList<Track> songs) {
        this.songs = songs;
    }
}
