package view;

import javax.swing.*;

import entity.DisplayPlaylist;
import entity.Playlist;
import interface_adapter.loggedin.LoggedInViewModel;
import interface_adapter.rec_playlist.RecPlaylistController;
import interface_adapter.rec_playlist.RecPlaylistViewModel;

import java.awt.*;


/**
 * This View pops up when a playlist is recommended.
 */
public class RecPlaylistView extends JPanel {

    private final JPanel view;
    //    private ImportPlaylistController importPlaylistController;
    private DisplayPlaylist playlist;

    //    private static final String FONT = "Futura";
    private static final int TWENTY = 20;
    private JButton importPlaylist;

    private static final Color DARK_BACKGROUND = new Color(24, 24, 32);

    public RecPlaylistView() {
        final ViewBuilder builder = new ViewBuilder();

        builder.addLabel("New Playlist: Placeholder_name")
                .addLabel("Recommended Playlist, will this show up?")
                .addButton("importplaylist", "Import Playlist")
                .setViewName("Recommended Playlist");
        view = builder.build();
        this.add(view);
        this.setBackground(DARK_BACKGROUND);
        view.setBorder(BorderFactory.createEmptyBorder(TWENTY, TWENTY, TWENTY, TWENTY));

        importPlaylist = builder.getButton("goback");

    //        initializeButtonActions();
    }

    private void initializeButtonActions () {
        importPlaylist.addActionListener(evt -> handleImportPlaylistAction());
    }

    private void handleImportPlaylistAction () {
        // importPlaylistController.execute();
    }

    //    public void setImportPlaylistController(ImportPlaylistController importPlaylistController) {
    //        this.importPlaylistController = importPlaylistController;
    //    }

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
