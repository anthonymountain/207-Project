package entity;

import java.util.ArrayList;

/**
 * A simple implementation of the Song interface.
 */
public class CommonArtist implements Artist {

    private final String name;
    private final ArrayList<Song> songs;

    public CommonArtist(String name, ArrayList<Song> songs) {
        this.name = name;
        this.songs = songs;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public ArrayList<Song> getSongs() {
        return songs;
    }
}
