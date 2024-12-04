package view;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

import entity.*;
import interface_adapter.rec_track.RecTrackController;

/**
 * The View for when the user generates a track.
 * //Note: if you want to figure out the correct format and structure, look at LoggedInView.java
 * //import interface_adapter.rec_track.RecTrackState;  could be unnecessary
 */
public class RecTrackView extends JPanel {

    // UI
    private static final Color DARK_BACKGROUND = new Color(24, 24, 32);
    private static final int TEN = 10;
    private static final String FONT = "Futura";

    private final ViewBuilder builder = new ViewBuilder();

    private final JPanel view;
    private RecTrackController recTrackController;
    private JButton recSong;
    private Track track;

    public RecTrackView() {
        builder.addLabel("Recommended Track:")

                .setViewName("Recommended Track");

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
     * Set the track and make the labels.
     * @param track the track to be set.
     */
    public void setTrack(Track track) {
        this.track = track;
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        final JPanel trackPanel = new JPanel();
        trackPanel.setBackground(DARK_BACKGROUND);

        builder.addHeaderLabel(this.track.getName());
        final JLabel trackLabel = builder.getLabel(this.track.getName());
        trackLabel.setFont(ViewBuilder.LABEL_FONT);
        trackLabel.setForeground(ViewBuilder.BUTTON_TEXT_COLOR);
        trackLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        this.add(trackLabel);
    }
}
