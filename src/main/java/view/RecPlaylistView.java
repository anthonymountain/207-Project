package view;

import javax.swing.JPanel;

import entity.Playlist;
import interface_adapter.rec_playlist.RecPlaylistController;

/**
 * This View pops up when a playlist is recommended.
 */
public class RecPlaylistView {

    private final JPanel view;
    private RecPlaylistController recPlaylistController;
    private Playlist playlist;

    public RecPlaylistView() {
        final ViewBuilder builder = new ViewBuilder();

        builder.addLabel("New Playlist: Placeholder_name")
                .addButton("IDK", "what's up")
                .setViewName("Recommended Playlist");

        view = builder.build();
    }

    public JPanel getView() {
        return view;
    }

    public void setRecPlaylistController(RecPlaylistController recPlaylistController) {
        this.recPlaylistController = recPlaylistController;
    }

    public void setPlaylist(Playlist playlist) {
        this.playlist = playlist;
    }

    public Playlist getPlaylist() {
        return playlist;
    }

}
