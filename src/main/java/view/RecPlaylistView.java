package view;

import javax.swing.*;

import entity.DisplayPlaylist;
import entity.Playlist;
import entity.Track;
import interface_adapter.loggedin.LoggedInViewModel;
import interface_adapter.rec_playlist.RecPlaylistController;
import interface_adapter.rec_playlist.RecPlaylistViewModel;

import java.awt.*;
import java.util.ArrayList;


/**
 * This View pops up when a playlist is recommended.
 */
public class RecPlaylistView extends JPanel {

    private final JPanel view;
    //    private ImportPlaylistController importPlaylistController;
    private ArrayList<Track> playlist;

    //    private static final String FONT = "Futura";
    private static final int TWENTY = 20;
    private JButton importPlaylist;

    private static final Color DARK_BACKGROUND = new Color(24, 24, 32);

    public RecPlaylistView() {
        final ViewBuilder builder = new ViewBuilder();

        builder.addLabel("playlistName", "New Playlist: Recommended Playlist")
                .addButton("importplaylist", "Import Playlist")
                .setViewName("Recommended Playlist");
        view = builder.build();
        this.setLayout(new GridLayout(0, 1));
        this.add(view);
        this.setBackground(DARK_BACKGROUND);
//        view.setBorder(BorderFactory.createEmptyBorder(TWENTY, TWENTY, TWENTY, TWENTY));

        importPlaylist = builder.getButton("importplaylist");

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
    public void setPlaylist(ArrayList<Track> playlist) {
        this.playlist = playlist;
        final JPanel playlistPanel = new JPanel();
        playlistPanel.setBackground(DARK_BACKGROUND);

        for (int i = 0; i < playlist.size(); i++) {
            final Track currentTrack = playlist.get(i);
            //            final JLabel playlistLabel = new JLabel(currentTrack.getName() + "by " + currentTrack.getArtists().get(0).getName());
            final JLabel playlistLabel = new JLabel(currentTrack.getName());
            playlistLabel.setFont(ViewBuilder.LABEL_FONT);
            playlistLabel.setForeground(ViewBuilder.BUTTON_TEXT_COLOR);
            playlistLabel.setAlignmentY(Component.TOP_ALIGNMENT);
            playlistPanel.add(playlistLabel);
            playlistPanel.add(Box.createRigidArea(new Dimension(10, 10)));
        }
        playlistPanel.setLayout(new GridLayout(0, 1));
        this.add(playlistPanel);

    }
}
