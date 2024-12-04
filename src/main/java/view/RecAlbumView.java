package view;

import javax.swing.*;

import java.awt.*;

public class RecAlbumView extends JPanel {

    private static final Color DARK_BACKGROUND = new Color(24, 24, 32);
    private static final int TEN = 10;
    private static final int FOUR_HUNDRED = 400;

    private final ViewBuilder builder = new ViewBuilder();

    private final JPanel view;
    private String albumName;

    public RecAlbumView(String albumName) {
        this.albumName = albumName;
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

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        final JPanel albumPanel = new JPanel();
        albumPanel.setBackground(DARK_BACKGROUND);

        builder.addHeaderLabel(this.albumName);
        final JLabel albumLabel = builder.getLabel(this.albumName);
        albumLabel.setFont(ViewBuilder.LABEL_FONT);
    }
}
