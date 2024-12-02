package view;

import javax.swing.*;
import interface_adapter.rec_artist.*;

/**
 * The View for when the user generates an artist.
 */
public class RecArtistView {

    private final JPanel view;
    private JLabel artistNameLabel;
    private JButton recSong;
    private RecArtistController recArtistController;

    public RecArtistView() {
        final ViewBuilder builder = new ViewBuilder();

        artistNameLabel = new JLabel("New Artist: Loading...");
        builder.addLabel(artistNameLabel)
                .addButton("recSong", "Recommend Song")
                .setViewName("Recommended Artist");

        recSong = builder.getButton("recSong");
        recSong.addActionListener(evt -> recArtistController.execute());
        view = builder.build();
    }

    public JPanel getView() {
        return view;
    }

    public void setRecArtistController(RecArtistController recArtistController) {
        this.recArtistController = recArtistController;
    }

    /**
     * Updates the artist name to put in the label in place of the placeholder.
     * @param artistName the name to be added
     */
    public void updateArtistName(String artistName) {
        artistNameLabel.setText("New Artist: " + artistName);
    }
}
