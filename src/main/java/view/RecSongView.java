package view;

import java.awt.*;

import javax.swing.*;

import interface_adapter.rec_song.RecSongController;
import view.components.RoundedButton;

/**
 * The View for when the user generates a song.
 */
public class RecSongView {

    private static final String FONT = "Futura";

    private static final Color DARK_BACKGROUND = new Color(24, 24, 32);
    private static final Color SPOTIFY_GREEN = new Color(30, 215, 96);
    private static final Color BUTTON_TEXT_COLOR = Color.WHITE;

    private final JPanel view;
    private RecSongController recSongController;

    public RecSongView() {
        final ViewBuilder viewBuilder = new ViewBuilder();

        // Add a header label
        viewBuilder.addLabel("Recommended Song");

        // Add the song label (placeholder for now)
        viewBuilder.addLabel("New Song: placeholder_name");

        // Add "Add to Playlist" button
        viewBuilder.addButton("addToPlaylist", "Add to Playlist");

        // Build the view
        this.view = viewBuilder.build();
    }

    public JPanel getView() {
        return view;
    }

    public void setRecSongController(RecSongController recSongController) {
        this.recSongController = recSongController;
        // Optionally, you can bind controller actions to buttons here
        final JButton addToPlaylistButton = ((ViewBuilder) view).getButton("addToPlaylist");
        addToPlaylistButton.addActionListener(e -> {
//            if (recSongController != null) {
//                recSongController.execute(); // Example action
//            }
        });
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
