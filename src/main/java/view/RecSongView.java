package view;

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
public class RecSongView extends JPanel implements PropertyChangeListener {

    private final String viewName = "song recommended";
    private final RecSongViewModel recSongViewModel;
    //      the recSongViewModel will be implemented later.
    private RecSongController recSongController;

    private final JLabel name;

    private final JButton addToPlaylist;

    public RecSongView(RecSongViewModel recSongViewModel) {
        this.recSongViewModel = recSongViewModel;
        this.recSongViewModel.addPropertyChangeListener(this);

        final JLabel songInfo = new JLabel("New Song: " + "placeholder_name");
        name = new JLabel();

        final JPanel buttons = new JPanel();
        addToPlaylist = new JButton("Add to Playlist");
        buttons.add(addToPlaylist);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        addToPlaylist.addActionListener(
                // This creates an anonymous subclass of ActionListener and instantiates it.
                evt -> {
                    if (evt.getSource().equals(addToPlaylist)) {
                        // addToPlaylistController.execute();
                    }
                }
        );

        this.add(songInfo);

        this.add(buttons);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("state")) {
            final RecSongState state = (RecSongState) evt.getNewValue();
            name.setText(state.getName());
        }
        else if (evt.getPropertyName().equals("like")) {
            final RecSongState state = (RecSongState) evt.getNewValue();
            JOptionPane.showMessageDialog(null, "liked" + state.getName());
        }
        else if (evt.getPropertyName().equals("addToPlaylist")) {
            final RecSongState state = (RecSongState) evt.getNewValue();
            JOptionPane.showMessageDialog(null, "added song to playlist: " + state.getList());
        }

    }

    public String getViewName() {
        return viewName;
    }

    public void setRecSongController(RecSongController recSongController) {
        this.recSongController = recSongController;
    }
}
