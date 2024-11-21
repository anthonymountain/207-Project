package view;

import interface_adapter.rec_playlist.RecPlaylistController;
import interface_adapter.rec_playlist.RecPlaylistViewModel;

import javax.swing.JPanel;

/**
 * This View pops up when a playlist is recommended.
 */
public class RecPlaylistView {

    private final JPanel view;
    private RecPlaylistController recPlaylistController;

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
}
