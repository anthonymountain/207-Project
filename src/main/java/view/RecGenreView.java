package view;

import java.awt.*;

import javax.swing.*;

import entity.Artist;
import entity.Genre;
import interface_adapter.rec_artist.RecArtistController;
import interface_adapter.rec_genre.RecGenreController;
import interface_adapter.rec_genre.RecGenreViewModel;
import use_case.rec_genre.RecGenreOutputData;

/**
 * The View for when the user generates a genre recommendation.
 */
public class RecGenreView extends JPanel {

    private static final String FONT = "Futura";
    private static final int TEN = 10;
    private static final int FOUR_HUNDERED = 400;
    private static final Color DARK_BACKGROUND = new Color(24, 24, 32);
    private static final Color SPOTIFY_GREEN = new Color(30, 215, 96);
    private static final Color BUTTON_TEXT_COLOR = Color.WHITE;

    private final ViewBuilder builder = new ViewBuilder();

    private final JPanel view;
    private RecGenreController recGenreController;
    private JButton recGenre;
    private Genre genre;

    /**
     * Constructs the view for Recommend Genre.
     */
    public RecGenreView() {
        builder.addLabel("Recommend Genre")
            .addButton("recSong", "Recommend Genre")
            .setViewName("Recommended Genre");

        builder.setPreferredSize(FOUR_HUNDERED, FOUR_HUNDERED);
        view = builder.build();
        this.add(view);
        this.setBackground(DARK_BACKGROUND);
        view.setBorder(BorderFactory.createEmptyBorder(TEN, TEN, TEN, TEN));

        recGenre = builder.getButton("recSong");
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
     * @param recGenreViewModel the ViewModel to set the view.
     */
    public void setGenre(RecGenreViewModel recGenreViewModel) {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        final String label = recGenreViewModel.getGenre();
        final JPanel artistPanel = new JPanel();
        artistPanel.setBackground(DARK_BACKGROUND);

        builder.addHeaderLabel(label);
        final JLabel artistLabel = builder.getLabel(label);
        artistLabel.setFont(ViewBuilder.LABEL_FONT);
        artistLabel.setForeground(ViewBuilder.BUTTON_TEXT_COLOR);
        artistLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
    }
}
