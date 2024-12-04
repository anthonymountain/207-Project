package view;

import entity.Album;
import entity.Artist;

import javax.swing.*;

import java.awt.*;

public class RecAlbumView extends JPanel {

    private static final Color DARK_BACKGROUND = new Color(24, 24, 32);
    private static final int TEN = 10;
    private static final int FOUR_HUNDRED = 400;

    private final ViewBuilder builder = new ViewBuilder();

    private final JPanel view;
    private Album album;

    public RecAlbumView() {
        builder.addLabel("Recommended Album:")
                .addButton("recAlbum", "Recommend Album")
                .setViewName("Recommended Album");
        builder.setPreferredSize(FOUR_HUNDRED, FOUR_HUNDRED);

        this.view = builder.build();
        this.add(view);
        this.setBackground(DARK_BACKGROUND);
        view.setBorder(BorderFactory.createEmptyBorder(TEN, TEN, TEN, TEN));
    }

    public JPanel getView() {
        return view;
    }

    /**
     * Set the album and make the labels.
     * @param album the album to be set.
     */
    public void setAlbum(Album album) {
        this.album = album;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        final JPanel artistPanel = new JPanel();
        artistPanel.setBackground(DARK_BACKGROUND);

        builder.addHeaderLabel(this.album.getName());
        final JLabel artistLabel = builder.getLabel(this.album.getName());
        artistLabel.setFont(ViewBuilder.LABEL_FONT);
        artistLabel.setForeground(ViewBuilder.BUTTON_TEXT_COLOR);
        artistLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        this.add(artistLabel);
    }
}
