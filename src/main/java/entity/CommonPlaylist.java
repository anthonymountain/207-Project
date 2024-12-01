package entity;

import java.util.ArrayList;

/**
 * This is a common playlist.
 */
public class CommonPlaylist implements Playlist {
    private final ArrayList<Song> songs;

    public CommonPlaylist(ArrayList<Song> songs) {
        this.songs = songs;
    }

    public CommonPlaylist() {
        this.songs = null;
        // Nothing yet, this is just to create a Playlist entity.
    }

    @Override
    public ArrayList<Song> getSongs() {
        return songs;
    }

    @Override
    public void addSong(Song song) {
        songs.add(song);
    }

}
