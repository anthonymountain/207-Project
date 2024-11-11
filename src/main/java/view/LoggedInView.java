package view;

import java.awt.Component;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

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

import interface_adapter.change_password.ChangePasswordController;
import interface_adapter.change_password.LoggedInState;
import interface_adapter.change_password.LoggedInViewModel;
import interface_adapter.logout.LogoutController;
import interface_adapter.rec_song.RecSongController;
import interface_adapter.rec_song.RecSongViewModel;

/**
 * The View for when the user is logged into the program.
 */
public class LoggedInView extends JPanel implements PropertyChangeListener {

    private final String viewName = "logged in";
    private final LoggedInViewModel loggedInViewModel;
    private final RecSongViewModel recSongViewModel;
    private final JLabel passwordErrorField = new JLabel();
    private LogoutController logoutController;
    private RecSongController recSongController;

    private final JLabel username;

    private final JButton logOut;

    private final JButton recSong;

    public LoggedInView(LoggedInViewModel loggedInViewModel) {
        this.loggedInViewModel = loggedInViewModel;
        this.recSongViewModel = new RecSongViewModel();
        this.loggedInViewModel.addPropertyChangeListener(this);

        final JLabel usernameInfo = new JLabel("Currently logged in: ");
        username = new JLabel();

        final JPanel buttons = new JPanel();
        recSong = new JButton("Recommend Song");
        buttons.add(recSong);

        logOut = new JButton("Log Out");
        buttons.add(logOut);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        //        passwordInputField.getDocument().addDocumentListener(new DocumentListener() {
        //
        //            private void documentListenerHelper() {
        //                final LoggedInState currentState = loggedInViewModel.getState();
        //                currentState.setPassword(passwordInputField.getText());
        //                loggedInViewModel.setState(currentState);
        //            }
        //
        //            @Override
        //            public void insertUpdate(DocumentEvent e) {
        //                documentListenerHelper();
        //            }
        //
        //            @Override
        //            public void removeUpdate(DocumentEvent e) {
        //                documentListenerHelper();
        //            }
        //
        //            @Override
        //            public void changedUpdate(DocumentEvent e) {
        //                documentListenerHelper();
        //            }
        //        });

        //        changePassword.addActionListener(
        //                // This creates an anonymous subclass of ActionListener and instantiates it.
        //                evt -> {
        //                    if (evt.getSource().equals(changePassword)) {
        //                        final LoggedInState currentState = loggedInViewModel.getState();
        //
        //                        this.changePasswordController.execute(
        //                                currentState.getUsername(),
        //                                currentState.getPassword()
        //                        );
        //                    }
        //                }
        //        );

        logOut.addActionListener(
                // This creates an anonymous subclass of ActionListener and instantiates it.
                evt -> {
                    if (evt.getSource().equals(logOut)) {
                        final LoggedInState currentState = loggedInViewModel.getState();

                        logoutController.execute(
                                currentState.getUsername()
                        );
                    }
                }
        );

        recSong.addActionListener(
                // This creates an anonymous subclass of ActionListener and instantiates it.
                evt -> {
                    final JDialog dialog = new JDialog((JFrame) this.getTopLevelAncestor(),
                            "Song Recommendation", true);
                    final RecSongView recSongView = new RecSongView(recSongViewModel);
                    dialog.getContentPane().add(recSongView);
                    dialog.pack();
                    dialog.setResizable(false);
                    dialog.setLocationRelativeTo(this);
                    dialog.setVisible(true);
                }
        );

        this.add(usernameInfo);
        this.add(username);

        this.add(buttons);
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

    public void setLogoutController(LogoutController logoutController) {
        this.logoutController = logoutController;
    }
}
