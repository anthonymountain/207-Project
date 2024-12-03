package view;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

import entity.*;
import interface_adapter.rec_artist.RecArtistController;

/**
 * The View for when the user generates a artist.
 * //Note: if you want to figure out the correct format and structure, look at LoggedInView.java
 * //import interface_adapter.rec_artist.RecArtistState;  could be unnecessary
 */
public class RecArtistView extends JPanel {

    // UI
    private static final Color DARK_BACKGROUND = new Color(24, 24, 32);
    private static final int TEN = 10;
    private static final String FONT = "Futura";

    private final ViewBuilder builder = new ViewBuilder();

    private final JPanel view;
    private RecArtistController recArtistController;
    private JButton recSong;
    private Artist artist;

    public RecArtistView() {
        builder.addLabel("Recommended Artist:")

                .addButton("recSong", "Recommend Song")
                .setViewName("Recommended Artist");

        builder.setPreferredSize(400,400);
        view = builder.build();
        this.add(view);
        this.setBackground(DARK_BACKGROUND);
        view.setBorder(BorderFactory.createEmptyBorder(TEN, TEN, TEN, TEN));

        recSong = builder.getButton("recSong");
    }

    private void initializeButtonActions() {
        recSong.addActionListener(evt -> handleRecSong());
    }

    private void handleRecSong() {
        // RecSongController.execute();
    }

    //    public void setRecSongController(RecSongController recSongController) {
    //        this.recSongController = recSongController;
    //    }

    /**
     * Set the artist and make the labels.
     * @param artist the artist to be set.
     */
    public void setArtist(Artist artist) {
        this.artist = artist;
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        final JPanel artistPanel = new JPanel();
        artistPanel.setBackground(DARK_BACKGROUND);

        builder.addHeaderLabel(this.artist.getName());
        final JLabel artistLabel = builder.getLabel(this.artist.getName());
        artistLabel.setFont(ViewBuilder.LABEL_FONT);
        artistLabel.setForeground(ViewBuilder.BUTTON_TEXT_COLOR);
        artistLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        this.add(artistLabel);
    }
}
