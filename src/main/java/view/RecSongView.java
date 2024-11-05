package view;

import interface_adapter.change_password.ChangePasswordController;
import interface_adapter.change_password.LoggedInState;
import interface_adapter.change_password.LoggedInViewModel;
import interface_adapter.logout.LogoutController;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;


/**
 * The View for when the user generates a song
 */
public class RecSongView extends JPanel implements PropertyChangeListener {

        private final String viewName = "song recommended";
//        private final RecSongViewModel recSongViewModel;
//      the recSongViewModel will be implemented later.
        private final JLabel passwordErrorField = new JLabel();
//        private LikeController likeController;
//      the likeController will be implemented later for when the likeButton is added

        private final JLabel username;

        private final JButton logOut;

        private final JTextField passwordInputField = new JTextField(15);
        private final JButton changePassword;

        public RecSongView(RecSongViewModel recSongViewModel) {
            this.loggedInViewModel = loggedInViewModel;
            this.loggedInViewModel.addPropertyChangeListener(this);

            final JLabel title = new JLabel("Logged In Screen");
            title.setAlignmentX(Component.CENTER_ALIGNMENT);

            final LabelTextPanel passwordInfo = new LabelTextPanel(
                    new JLabel("Password"), passwordInputField);

            final JLabel usernameInfo = new JLabel("Currently logged in: ");
            username = new JLabel();

            final JPanel buttons = new JPanel();
            logOut = new JButton("Log Out");
            buttons.add(logOut);

            changePassword = new JButton("Change Password");
            buttons.add(changePassword);

            this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

            passwordInputField.getDocument().addDocumentListener(new DocumentListener() {

                private void documentListenerHelper() {
                    final LoggedInState currentState = loggedInViewModel.getState();
                    currentState.setPassword(passwordInputField.getText());
                    loggedInViewModel.setState(currentState);
                }

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
            });

            changePassword.addActionListener(
                    // This creates an anonymous subclass of ActionListener and instantiates it.
                    evt -> {
                        if (evt.getSource().equals(changePassword)) {
                            final LoggedInState currentState = loggedInViewModel.getState();

                            this.changePasswordController.execute(
                                    currentState.getUsername(),
                                    currentState.getPassword()
                            );
                        }
                    }
            );

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

            this.add(title);
            this.add(usernameInfo);
            this.add(username);

            this.add(passwordInfo);
            this.add(passwordErrorField);
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

        public void setChangePasswordController(ChangePasswordController changePasswordController) {
            this.changePasswordController = changePasswordController;
        }

        public void setLogoutController(LogoutController logoutController) {
            this.logoutController = logoutController;
        }
    }

}
