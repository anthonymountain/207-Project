package view;

import javax.swing.*;

import entity.DisplayPlaylist;
import entity.Playlist;
import interface_adapter.rec_playlist.RecPlaylistController;
import interface_adapter.rec_playlist.RecPlaylistViewModel;

import java.awt.*;


/**
 * This View pops up when a playlist is recommended.
 */
public class RecPlaylistView extends JFrame {

    private final JPanel view;
    private RecPlaylistController recPlaylistController;
    private DisplayPlaylist playlist;

    public RecPlaylistView() {
        final ViewBuilder builder = new ViewBuilder();

        builder.addLabel("New Playlist: Placeholder_name")
                .addLabel("Recommended Playlist, will this show up?")
                .addButton("IDK", "what's up")
                .setViewName("Recommended Playlist");
        view = builder.build();
    }

    public void setRecPlaylistController(RecPlaylistController recPlaylistController) {
        this.recPlaylistController = recPlaylistController;
    }

    /**
     * This sets the playlist and also makes the labels that puts it in the frame.
     * @param playlist is the playlist dummy.
     */
    public void setPlaylist(DisplayPlaylist playlist) {
        this.playlist = playlist;
        for (int i = 0; i < playlist.size(); i++) {
            final JLabel playlistLabel = new JLabel(playlist.playlistItem(i));
            playlistLabel.setFont(ViewBuilder.LABEL_FONT);
            playlistLabel.setForeground(ViewBuilder.BUTTON_TEXT_COLOR);
            playlistLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            this.add(playlistLabel);
            this.add(Box.createRigidArea(new Dimension(0, 10)));
        }
    }

    public DisplayPlaylist getPlaylist() {
        return playlist;
    }

}
