package view;

//import interface_adapter.change_password.LoggedInViewModel;
//import interface_adapter.change_password.ChangePasswordController;
//import interface_adapter.change_password.LoggedInState;
//import interface_adapter.logout.LogoutController;
import interface_adapter.change_password.ChangePasswordController;
import interface_adapter.logout.LogoutController;
import interface_adapter.rec_song.RecSongController; // Note: this is to replace the change_password stuff
import interface_adapter.rec_song.RecSongState;
import interface_adapter.rec_song.RecSongViewModel;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

//Note: if you want to figure out the correct format and structure, look at LoggedInView.java

/**
 * The View for when the user generates a song
 */
public class RecSongView extends JPanel implements PropertyChangeListener {

    private final String viewName = "song recommended";
        private final RecSongViewModel recSongViewModel;
//      the recSongViewModel will be implemented later.
        private RecSongController recSongController;
        private LikeController likeController;
//      the likeController will be implemented later for when the likeButton is added

    private final JLabel username;

    private final JButton logOut;

    private final JTextField passwordInputField = new JTextField(15);
    private final JButton like;
    private final JButton addToPlaylist;

    public RecSongView(RecSongViewModel recSongViewModel) {
        this.loggedInViewModel = loggedInViewModel;
        this.loggedInViewModel.addPropertyChangeListener(this);

        final JLabel title = new JLabel("Recommended Song");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        final JLabel usernameInfo = new JLabel("Currently logged in: ");
        username = new JLabel();

        final JPanel buttons = new JPanel();
        logOut = new JButton("Log Out");
        buttons.add(logOut);

        like = new JButton("Like");
        buttons.add(like);
        addToPlaylist = new JButton("Add to Playlist");
        buttons.add(addToPlaylist);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

//            passwordInputField.getDocument().addDocumentListener(new DocumentListener() {
//
//                private void documentListenerHelper() {
//                    final LoggedInState currentState = loggedInViewModel.getState();
//                    currentState.setPassword(passwordInputField.getText());
//                    loggedInViewModel.setState(currentState);
//                }

            @Override
            public void insertUpdate(DocumentEvent e) {
                documentListenerHelper();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                documentListenerHelper();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                documentListenerHelper();
            }
        );

        this.add(title);
        this.add(usernameInfo);
        this.add(username);

        this.add(passwordInfo);
        this.add(passwordErrorField);
        this.add(buttons);
    }

    public RecSongView(JLabel username, JButton logOut, JButton like, JButton addToPlaylist) {
        this.username = username;
        this.logOut = logOut;
        this.like = like;
        this.addToPlaylist = addToPlaylist;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("state")) {
            final LoggedInState state = (LoggedInState) evt.getNewValue();
            username.setText(state.getUsername());
        }
        else if (evt.getPropertyName().equals("password")) {
            final LoggedInState state = (LoggedInState) evt.getNewValue();
            JOptionPane.showMessageDialog(null, "password updated for " + state.getUsername());
        }

    }

    public String getViewName() {
        return viewName;
    }

    public void setLikeController(LikeController likeController) {
        this.likeController = likeController;
    }

    public void setRecSongController(RecSongController recSongController) {
        this.recSongController = recSongController;
    }
}
