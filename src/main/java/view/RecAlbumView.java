package view;

import entity.Album;
import org.apache.tomcat.Jar;

import javax.swing.*;
import interface_adapter.rec_album.RecAlbumController;

import java.awt.*;

public class RecAlbumView extends JPanel {

    private static final Color DARK_BACKGROUND = new Color(24, 24, 32);
    private static final int TEN = 10;
    private static final int FOUR_HUNDRED = 400;
    private static final String FONT = "Futura";

    private final ViewBuilder builder = new ViewBuilder();

    private final JPanel view;
    private JButton recAlbum;
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
}
