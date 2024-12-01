package view;

import javax.swing.JPanel;

import entity.DisplayPlaylist;
import entity.Playlist;
import interface_adapter.rec_playlist.RecPlaylistController;
import interface_adapter.rec_playlist.RecPlaylistViewModel;

import java.util.ArrayList;
import java.util.Objects;

/**
 * This View pops up when a playlist is recommended.
 */
public class RecPlaylistView {

    private final JPanel view;
    private RecPlaylistController recPlaylistController;
    private DisplayPlaylist playlist;

    public RecPlaylistView(DisplayPlaylist playlist) {
        final ViewBuilder builder = new ViewBuilder();
        this.playlist = playlist;

        for (int i = 0; i < playlist.size(); i++) {
            builder.addLabel("New Playlist: Placeholder_name")
                    .addLabel("Recommended Playlist, will this show up?")
                    .addLabel(playlist.playlistItem(i))
                    .addButton("IDK", "what's up")
                    .setViewName("Recommended Playlist");
        }

        view = builder.build();
    }

    public JPanel getView() {
        return view;
    }

    public void setRecPlaylistController(RecPlaylistController recPlaylistController) {
        this.recPlaylistController = recPlaylistController;
    }

    public void setPlaylist(DisplayPlaylist playlist) {
        this.playlist = playlist;
    }

    public DisplayPlaylist getPlaylist() {
        return playlist;
    }

}
