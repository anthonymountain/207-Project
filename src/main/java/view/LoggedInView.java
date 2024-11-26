package view;

import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.concurrent.Executor;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import interface_adapter.change_password.LoggedInState;
import interface_adapter.change_password.LoggedInViewModel;
import interface_adapter.logout.LogoutController;
import interface_adapter.rec_playlist.RecPlaylistController;
import interface_adapter.rec_playlist.RecPlaylistState;

/**
 * The View for when the user is logged into the program.
 */
public class LoggedInView extends JPanel implements PropertyChangeListener {

    private final String viewName = "logged in";
    private final LoggedInViewModel loggedInViewModel;
    private final JLabel username;
    private final ViewBuilder viewBuilder;

    private LogoutController logoutController;
    private RecPlaylistController recPlaylistController;

    public LoggedInView(LoggedInViewModel loggedInViewModel) {
        this.loggedInViewModel = loggedInViewModel;
        this.loggedInViewModel.addPropertyChangeListener(this);

        // final JLabel usernameInfo = new JLabel("Currently logged in: ");
        username = new JLabel();

        viewBuilder = new ViewBuilder();
        viewBuilder.addLabel("Currently logged in: ")
                .addButton("logout", "Log Out")
                .addButton("recSong", "Recommend Song")
                .addButton("recArtist", "Recommend Artist")
                .addButton("recPlaylist", "Recommend Playlist")
                .setViewName(viewName);

        setupListeners();

        this.setLayout(new BorderLayout());
        this.add(viewBuilder.build(), BorderLayout.CENTER);
    }

    private void setupListeners() {
        final JButton logOutButton = viewBuilder.getButton("logout");
        if (logOutButton != null) {
            logOutButton.addActionListener(evt -> {
                final LoggedInState currentState = loggedInViewModel.getState();
                logoutController.execute(currentState.getUsername());
            });
        }

        final JButton recSongButton = viewBuilder.getButton("recSong");
        if (recSongButton != null) {
            recSongButton.addActionListener(evt -> {
                final JDialog dialog = new JDialog((JFrame) this.getTopLevelAncestor(),
                        "Song Recommendation", true);
                final RecSongView recSongView = new RecSongView();
                dialog.getContentPane().add(recSongView.getView());
                dialog.pack();
                dialog.setResizable(false);
                dialog.setLocationRelativeTo(this);
                dialog.setVisible(true);
            });
        }

        final JButton recArtistButton = viewBuilder.getButton("recArtist");
        if (recArtistButton != null) {
            recArtistButton.addActionListener(evt -> {
                final JDialog dialog = new JDialog((JFrame) this.getTopLevelAncestor(),
                        "Artist Recommendation", true);
                final RecArtistView recArtistView = new RecArtistView();
                dialog.getContentPane().add(recArtistView.getView());
                dialog.pack();
                dialog.setResizable(false);
                dialog.setLocationRelativeTo(this);
                dialog.setVisible(true);
            });
        }
        final JButton recPlaylistButton = viewBuilder.getButton("recPlaylist");
        if (recPlaylistButton != null) {
            recPlaylistButton.addActionListener(evt -> {
                recPlaylistController.execute();
                //                final JDialog dialog = new JDialog((JFrame) this.getTopLevelAncestor(),
                //                        "Playlist Recommendation", true);
                //                final RecPlaylistView recPlaylistView = new RecPlaylistView();
                //                dialog.getContentPane().add(recPlaylistView.getView());
                //                dialog.pack();
                //                dialog.setResizable(false);
                //                dialog.setLocationRelativeTo(this);
                //                dialog.setVisible(true);
            });
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("state")) {
            final LoggedInState state = (LoggedInState) evt.getNewValue();
            username.setText(state.getUsername());
        }
        else if (evt.getPropertyName().equals("password")) {
            final LoggedInState state = (LoggedInState) evt.getNewValue();
            JOptionPane.showMessageDialog(null, "Password updated for " + state.getUsername());
        }
    }

    public String getViewName() {
        return viewName;
    }

    public void setLogoutController(LogoutController logoutController) {
        this.logoutController = logoutController;
    }

    public void setRecPlaylistController(RecPlaylistController recPlaylistController) {
        this.recPlaylistController = recPlaylistController;
    }
}
