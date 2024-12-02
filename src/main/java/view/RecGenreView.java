package view;

import java.awt.*;

import javax.swing.*;

import interface_adapter.rec_genre.RecGenreController;
import use_case.rec_genre.RecGenreOutputData;

/**
 * The View for when the user generates a genre recommendation.
 */
public class RecGenreView {

    private static final String FONT = "Futura";
    private static final Color DARK_BACKGROUND = new Color(24, 24, 32);
    private static final Color SPOTIFY_GREEN = new Color(30, 215, 96);
    private static final Color BUTTON_TEXT_COLOR = Color.WHITE;

    private final JPanel view;
    private JLabel genreLabel;
    private RecGenreController recGenreController;

    /**
     * Constructs the view for the recommended genre using ViewBuilder.
     */
    public RecGenreView() {
        // Create a ViewBuilder instance
        final ViewBuilder viewBuilder = new ViewBuilder();

        // Add a header label
        viewBuilder.addLabel("Recommended Genre");

        // Create the genre label and add it directly here
        genreLabel = new JLabel("New Genre: placeholder_name");
        genreLabel.setFont(new Font(FONT, Font.PLAIN, 14));
        genreLabel.setForeground(BUTTON_TEXT_COLOR);
        genreLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        viewBuilder.add(genreLabel);

        // Build the view
        this.view = viewBuilder.build();
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
