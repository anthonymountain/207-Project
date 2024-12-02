package entity;

import java.util.ArrayList;

/**
 * This is just to get ArrayList for a display.
 */
public class DisplayPlaylist {
    private final ArrayList<String> dPlaylist;

    /**
     * Constructor dude.
     * @param displayPlaylist is for display.
     */
    public DisplayPlaylist(ArrayList<String> displayPlaylist) {
        this.dPlaylist = displayPlaylist;
    }

    /**
     * Size of playlist to iterate.
     * @return the size of the playlist.
     */
    public int size() {
        return dPlaylist.size();
    }

    /**
     * Gets ith item of playlist.
     * @return the ith item of playlist
     */
    public String playlistItem(int i) {
        return dPlaylist.get(i);
    }
}
