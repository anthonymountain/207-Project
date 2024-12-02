package view;

import org.apache.tomcat.Jar;

import javax.swing.*;
import interface_adapter.rec_album.RecAlbumController;

public class RecAlbumView {

    private final JPanel view;
    private RecAlbumController recAlbumController;

    public RecAlbumView() {
        final ViewBuilder viewBuilder = new ViewBuilder();
        viewBuilder.addLabel("Recommended Album");
        viewBuilder.addLabel("placeholder_name");
        this.view = viewBuilder.build();
    }

    public JPanel getView() {
        return view;
    }

    public void setRecAlbumController(RecAlbumController recAlbumController) {
        this.recAlbumController = recAlbumController;
    }
}
