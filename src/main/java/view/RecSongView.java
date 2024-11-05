package view;

import interface_adapter.like.LikeController;
import interface_adapter.rec_song.RecSongController;
import interface_adapter.rec_song.RecSongViewModel;

import javax.swing.*;
import java.awt.*;


/**
 * The View for when the user generates a song.
 * //Note: if you want to figure out the correct format and structure, look at LoggedInView.java
 * //import interface_adapter.rec_song.RecSongState;  could be unnecessary
 */
public class RecSongView extends JPanel {

    private final String viewName = "song recommended";
    private final RecSongViewModel recSongViewModel;
    //      the recSongViewModel will be implemented later.
    private RecSongController recSongController;
    private LikeController likeController;
    // the likeController will be implemented later for when the likeButton is added

    private final JButton like;
    private final JButton addToPlaylist;

    public RecSongView(RecSongViewModel recSongViewModel) {
        this.recSongViewModel = recSongViewModel;
        this.recSongViewModel.addPropertyChangeListener(this);
        // Note: addPropertyChangeListener is not implemented, if you want to look into implementing this function,
        // just check LoggedInView for the right thing.

        final JLabel title = new JLabel("Recommended Song");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        final JLabel songInfo = new JLabel("New Song: ");

        final JPanel buttons = new JPanel();

        like = new JButton("Like");
        buttons.add(like);
        addToPlaylist = new JButton("Add to Playlist");
        buttons.add(addToPlaylist);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(songInfo);

        this.add(buttons);
    }

    public String getViewName() {
        return viewName;
    }

    public void setLikeController(LikeController likeController) {
        this.likeController = likeController;
    }

    public void setRecSongController(RecSongController recSongController) {
        this.recSongController = recSongController;
    }
}
