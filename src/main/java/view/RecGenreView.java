package view;

import javax.swing.*;
import java.awt.*;

import interface_adapter.like.LikeController;
import interface_adapter.rec_genre.RecGenreController;
import view.components.RoundedButton;

/**
 * The View for when the user generates a genre recommendation.
 */
public class RecGenreView {

    private static final String FONT = "Futura";
    private static final int TWENTY = 20;

    private static final Color DARK_BACKGROUND = new Color(24, 24, 32);
    private static final Color SPOTIFY_GREEN = new Color(30, 215, 96);
    private static final Color BUTTON_TEXT_COLOR = Color.WHITE;

    private static final Font HEADER_FONT = new Font(FONT, Font.BOLD, 18);
    private static final Font LABEL_FONT = new Font(FONT, Font.PLAIN, 14);

    private final JPanel view;
    private RecGenreController recGenreController;
    private LikeController likeController;

    /**
     * Constructs the view for the recommended genre.
     */
    public RecGenreView() {
        view = new JPanel();
        view.setLayout(new BoxLayout(view, BoxLayout.Y_AXIS));
        view.setBackground(DARK_BACKGROUND);
        view.setBorder(BorderFactory.createEmptyBorder(TWENTY, TWENTY, TWENTY, TWENTY));

        // Add a header label
        final JLabel headerLabel = new JLabel("Recommended Genre");
        headerLabel.setFont(HEADER_FONT);
        headerLabel.setForeground(SPOTIFY_GREEN);
        headerLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        view.add(headerLabel);

        view.add(Box.createRigidArea(new Dimension(0, TWENTY)));

        // Add genre label
        final JLabel genreLabel = new JLabel("New Genre: placeholder_name");
        genreLabel.setFont(LABEL_FONT);
        genreLabel.setForeground(BUTTON_TEXT_COLOR);
        genreLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        view.add(genreLabel);

        view.add(Box.createRigidArea(new Dimension(0, TWENTY)));
    }

    /**
     * Returns the main panel for the recommended genre view.
     *
     * @return the view as a JPanel
     */
    public JPanel getView() {
        return view;
    }

    /**
     * Sets the controller for managing genre recommendations.
     *
     * @param recGenreController the genre recommendation controller
     */
    public void setRecGenreController(RecGenreController recGenreController) {
        this.recGenreController = recGenreController;
    }
}
