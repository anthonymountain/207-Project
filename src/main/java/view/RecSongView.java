package view;

import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.*;

import interface_adapter.rec_song.RecSongController;
import interface_adapter.rec_song.RecSongState;
import interface_adapter.rec_song.RecSongViewModel;

/**
 * The View for when the user generates a song.
 * //Note: if you want to figure out the correct format and structure, look at LoggedInView.java
 * //import interface_adapter.rec_song.RecSongState;  could be unnecessary
 */
public class RecSongView {

    private final JPanel view;
    private RecSongController recSongController;

    public RecSongView() {
        final ViewBuilder builder = new ViewBuilder();

        builder.addLabel("New Song: placeholder_name")
                .addButton("addToPlaylist", "Add to Playlist")
                .setViewName("Recommended Song");

        view = builder.build();
    }

    public JPanel getView() {
        return view;
    }

    public void setRecSongController(RecSongController recSongController) {
        this.recSongController = recSongController;
    }
}
