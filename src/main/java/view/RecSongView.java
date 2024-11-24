package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import interface_adapter.like.LikeController;
import interface_adapter.rec_song.RecSongController;
import view.components.RoundedButton;

/**
 * The View for when the user generates a song.
 */
public class RecSongView {

    private static final String FONT = "Futura";
    private static final int TWENTY = 20;

    private static final Color DARK_BACKGROUND = new Color(24, 24, 32);
    private static final Color SPOTIFY_GREEN = new Color(30, 215, 96);
    private static final Color BUTTON_TEXT_COLOR = Color.WHITE;

    private static final Font HEADER_FONT = new Font(FONT, Font.BOLD, 18);
    private static final Font LABEL_FONT = new Font(FONT, Font.PLAIN, 14);

    private final JPanel view;
    private RecSongController recSongController;
    private LikeController likeController;

    public RecSongView() {
        view = new JPanel();
        view.setLayout(new BoxLayout(view, BoxLayout.Y_AXIS));
        view.setBackground(DARK_BACKGROUND);
        view.setBorder(BorderFactory.createEmptyBorder(TWENTY, TWENTY, TWENTY, TWENTY));

        // Add a header label
        final JLabel headerLabel = new JLabel("Recommended Song");
        headerLabel.setFont(HEADER_FONT);
        headerLabel.setForeground(SPOTIFY_GREEN);
        headerLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        view.add(headerLabel);

        view.add(Box.createRigidArea(new Dimension(0, TWENTY)));

        // Add song label
        final JLabel songLabel = new JLabel("New Song: placeholder_name");
        songLabel.setFont(LABEL_FONT);
        songLabel.setForeground(BUTTON_TEXT_COLOR);
        songLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        view.add(songLabel);

        view.add(Box.createRigidArea(new Dimension(0, TWENTY)));

        // Add "Add to Playlist" button
        final JButton addToPlaylistButton = new RoundedButton("Add to Playlist");
        addToPlaylistButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        view.add(addToPlaylistButton);
    }

    public JPanel getView() {
        return view;
    }

    public void setRecSongController(RecSongController recSongController) {
        this.recSongController = recSongController;
    }
}


// package view;
//
//import java.awt.*;
//import java.beans.PropertyChangeEvent;
//import java.beans.PropertyChangeListener;
//
//import javax.swing.*;
//
//import interface_adapter.like.LikeController;
//import interface_adapter.rec_song.RecSongController;
//import interface_adapter.rec_song.RecSongState;
//import interface_adapter.rec_song.RecSongViewModel;
//
///**
// * The View for when the user generates a song.
// * //Note: if you want to figure out the correct format and structure, look at LoggedInView.java
// * //import interface_adapter.rec_song.RecSongState;  could be unnecessary
// */
//public class RecSongView {
//
//    private final JPanel view;
//    private RecSongController recSongController;
//    private LikeController likeController;
//
//    public RecSongView() {
//        final ViewBuilder builder = new ViewBuilder("Recommended Song");
//
//        // New Song: placeholder_name
//        builder.addLabel("New Song: placeholder_name");
//
//        builder.addButton("addToPlaylist", "Add to Playlist");
//
//        view = builder.build();
//    }
//
//    public JPanel getView() {
//        return view;
//    }
//
//    public void setRecSongController(RecSongController recSongController) {
//        this.recSongController = recSongController;
//    }
//}
