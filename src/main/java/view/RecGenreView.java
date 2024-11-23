package view;

import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.*;

import interface_adapter.like.LikeController;
import interface_adapter.rec_genre.RecGenreController;
import interface_adapter.rec_genre.RecGenreState;
import interface_adapter.rec_genre.RecGenreViewModel;

/**
 * The View for when the user generates a song.
 * //Note: if you want to figure out the correct format and structure, look at LoggedInView.java
 * //import interface_adapter.rec_song.RecSongState;  could be unnecessary
 */
public class RecGenreView {

    private final JPanel view;
    private RecGenreController recGenreController;
    private LikeController likeController;

    public RecGenreView() {
        final ViewBuilder builder = new ViewBuilder("Recommended Genre");

        builder.addLabel("New Genre: placeholder_name");

        view = builder.build();
    }

    public JPanel getView() {
        return view;
    }

    public void setRecGenreController(RecGenreController recGenreController) {
        this.recGenreController = recGenreController;
    }
}
