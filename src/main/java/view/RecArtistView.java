package view;

import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.*;

import interface_adapter.rec_artist.RecArtistController;

/**
 * The View for when the user generates a artist.
 * //Note: if you want to figure out the correct format and structure, look at LoggedInView.java
 * //import interface_adapter.rec_artist.RecArtistState;  could be unnecessary
 */
public class RecArtistView {

    private final JPanel view;
    private RecArtistController recArtistController;

    public RecArtistView() {
        final ViewBuilder builder = new ViewBuilder();

        builder.addLabel("New Artist: placeholder_name");

        builder.addButton("recSong", "Recommend Song");

        view = builder.build();
    }

    public JPanel getView() {
        return view;
    }

    public void setRecArtistController(RecArtistController recArtistController) {
        this.recArtistController = recArtistController;
    }
}
