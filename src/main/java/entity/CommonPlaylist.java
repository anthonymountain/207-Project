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

    @Override
    public ArrayList<Song> getSongs() {
        return songs;
    }

    @Override
    public void addSong(Song song) {
        songs.add(song);
    }

}
