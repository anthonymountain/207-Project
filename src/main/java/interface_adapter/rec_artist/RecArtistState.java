package interface_adapter.rec_artist;

import java.util.ArrayList;

import entity.Song;

/**
 * This state is for when an artist is recommended.
 */
public class RecArtistState {
    private String name;
    private ArrayList<Song> songs;

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

    public ArrayList<Song> getSongs() {
        return songs;
    }

    public void setSongs(ArrayList<Song> songs) {
        this.songs = songs;
    }
}
