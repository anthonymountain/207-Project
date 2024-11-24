package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import interface_adapter.change_password.LoggedInState;
import interface_adapter.change_password.LoggedInViewModel;
import interface_adapter.logout.LogoutController;
import interface_adapter.rec_song.RecSongController;
import interface_adapter.rec_song.RecSongViewModel;
import view.components.RoundedButton;

/**
 * The View for the LoggedIn Use Case.
 */
public class LoggedInView extends JPanel implements java.beans.PropertyChangeListener {

    private static final String FONT = "Futura";
    private static final int TWENTY = 20;
    private static final int TEN = 10;

    private static final Color DARK_BACKGROUND = new Color(24, 24, 32);
    private static final Color SPOTIFY_GREEN = new Color(30, 215, 96);
    private static final Color BUTTON_TEXT_COLOR = Color.WHITE;

    private static final Font HEADER_FONT = new Font(FONT, Font.BOLD, 18);
    private static final Font BUTTON_FONT = new Font(FONT, Font.PLAIN, 16);
    private static final Font LABEL_FONT = new Font(FONT, Font.PLAIN, 14);

    private final String viewName = "logged in";
    private final RecSongViewModel recSongViewModel;
    private LogoutController logoutController;
    private final JLabel username;
    private JButton logOut;
    private JButton recSong;
    private JButton recGenre;

    public LoggedInView(LoggedInViewModel loggedInViewModel) {
        this.recSongViewModel = new RecSongViewModel();
        loggedInViewModel.addPropertyChangeListener(this);

        setupPanelLayout();

        username = setupLabels();
        final JPanel buttonsPanel = createButtonsPanel();

        this.add(Box.createRigidArea(new Dimension(0, TEN)));
        this.add(username);
        this.add(Box.createRigidArea(new Dimension(0, TWENTY)));
        this.add(buttonsPanel);

        initializeButtonActions(loggedInViewModel);
    }

    private void setupPanelLayout() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBackground(DARK_BACKGROUND);
        this.setBorder(BorderFactory.createEmptyBorder(TWENTY, TWENTY, TWENTY, TWENTY));
    }

    private JLabel setupLabels() {
        final JLabel usernameInfo = new JLabel("Currently logged in:");
        usernameInfo.setFont(LABEL_FONT);
        usernameInfo.setForeground(BUTTON_TEXT_COLOR);
        usernameInfo.setAlignmentX(Component.CENTER_ALIGNMENT);

        final JLabel usernameLabel = new JLabel();
        usernameLabel.setFont(HEADER_FONT);
        usernameLabel.setForeground(SPOTIFY_GREEN);
        usernameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.add(usernameInfo);
        return usernameLabel;
    }

    private JPanel createButtonsPanel() {
        final JPanel buttons = new JPanel();
        buttons.setLayout(new BoxLayout(buttons, BoxLayout.Y_AXIS));
        buttons.setBackground(DARK_BACKGROUND);
        buttons.setAlignmentX(Component.CENTER_ALIGNMENT);

        recSong = new RoundedButton("Recommend Song");
        recGenre = new RoundedButton("Recommend Genre");
        logOut = new RoundedButton("Log Out");

        recSong.setAlignmentX(Component.CENTER_ALIGNMENT);
        recGenre.setAlignmentX(Component.CENTER_ALIGNMENT);
        logOut.setAlignmentX(Component.CENTER_ALIGNMENT);

        buttons.add(Box.createRigidArea(new Dimension(0, TEN)));
        buttons.add(recSong);
        buttons.add(Box.createRigidArea(new Dimension(0, TEN)));
        buttons.add(recGenre);
        buttons.add(Box.createRigidArea(new Dimension(0, TEN)));
        buttons.add(logOut);

        return buttons;
    }

    private void initializeButtonActions(LoggedInViewModel loggedInViewModel) {
        logOut.addActionListener(evt -> handleLogoutAction(loggedInViewModel));
        recGenre.addActionListener(evt -> openGenreRecommendationDialog());
        recSong.addActionListener(evt -> openSongRecommendationDialog());
    }

    private void handleLogoutAction(LoggedInViewModel loggedInViewModel) {
        final LoggedInState currentState = loggedInViewModel.getState();
        logoutController.execute(currentState.getUsername());
    }

    private void openGenreRecommendationDialog() {
        final JDialog dialog = new JDialog((JFrame) this.getTopLevelAncestor(), "Genre Recommendation", true);
        final RecGenreView recGenreView = new RecGenreView();
        dialog.getContentPane().add(recGenreView.getView());
        dialog.pack();
        dialog.setResizable(false);
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }

    private void openSongRecommendationDialog() {
        final JDialog dialog = new JDialog((JFrame) this.getTopLevelAncestor(), "Song Recommendation", true);
        final RecSongView recSongView = new RecSongView();
        dialog.getContentPane().add(recSongView.getView());
        dialog.pack();
        dialog.setResizable(false);
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }

    @Override
    public void propertyChange(java.beans.PropertyChangeEvent evt) {
        if ("state".equals(evt.getPropertyName())) {
            final LoggedInState state = (LoggedInState) evt.getNewValue();
            username.setText("Currently logged in as: " + state.getUsername());
        }
        else if ("password".equals(evt.getPropertyName())) {
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
}

// /**
// * The View for when the user is logged into the program.
// */
// public class LoggedInView extends JPanel implements PropertyChangeListener {
//
//    private final String viewName = "logged in";
//    private final LoggedInViewModel loggedInViewModel;
//    private final RecSongViewModel recSongViewModel;
//    private final JLabel passwordErrorField = new JLabel();
//    private LogoutController logoutController;
//    private RecSongController recSongController;
//
//    private final JLabel username;
//
//    private final JButton logOut;
//
//    private final JButton recSong;
//
//    private final JButton recGenre;
//
//    public LoggedInView(LoggedInViewModel loggedInViewModel) {
//        this.loggedInViewModel = loggedInViewModel;
//        this.recSongViewModel = new RecSongViewModel();
//        this.loggedInViewModel.addPropertyChangeListener(this);
//
//        final JLabel usernameInfo = new JLabel("Currently logged in: ");
//        username = new JLabel();
//
//        final JPanel buttons = new JPanel();
//
//        recSong = new JButton("Recommend Song");
//        buttons.add(recSong);
//
//        recGenre = new JButton("Recommend Genre");
//        buttons.add(recGenre);
//
//        logOut = new JButton("Log Out");
//        buttons.add(logOut);
//
//        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
//
//        //        passwordInputField.getDocument().addDocumentListener(new DocumentListener() {
//        //
//        //            private void documentListenerHelper() {
//        //                final LoggedInState currentState = loggedInViewModel.getState();
//        //                currentState.setPassword(passwordInputField.getText());
//        //                loggedInViewModel.setState(currentState);
//        //            }
//        //
//        //            @Override
//        //            public void insertUpdate(DocumentEvent e) {
//        //                documentListenerHelper();
//        //            }
//        //
//        //            @Override
//        //            public void removeUpdate(DocumentEvent e) {
//        //                documentListenerHelper();
//        //            }
//        //
//        //            @Override
//        //            public void changedUpdate(DocumentEvent e) {
//        //                documentListenerHelper();
//        //            }
//        //        });
//
//        //        changePassword.addActionListener(
//        //                // This creates an anonymous subclass of ActionListener and instantiates it.
//        //                evt -> {
//        //                    if (evt.getSource().equals(changePassword)) {
//        //                        final LoggedInState currentState = loggedInViewModel.getState();
//        //
//        //                        this.changePasswordController.execute(
//        //                                currentState.getUsername(),
//        //                                currentState.getPassword()
//        //                        );
//        //                    }
//        //                }
//        //        );
//
//        logOut.addActionListener(
//                // This creates an anonymous subclass of ActionListener and instantiates it.
//                evt -> {
//                    if (evt.getSource().equals(logOut)) {
//                        final LoggedInState currentState = loggedInViewModel.getState();
//
//                        logoutController.execute(
//                                currentState.getUsername()
//                        );
//                    }
//                }
//        );
//
//        recGenre.addActionListener(
//                // This creates an anonymous subclass of ActionListener and instantiates it.
//                evt -> {
//                    final JDialog dialog = new JDialog((JFrame) this.getTopLevelAncestor(),
//                            "Genre Recommendation", true);
//                    final RecGenreView recGenreView = new RecGenreView();
//                    dialog.getContentPane().add(recGenreView.getView());
//                    dialog.pack();
//                    dialog.setResizable(false);
//                    dialog.setLocationRelativeTo(this);
//                    dialog.setVisible(true);
//                }
//        );
//
//        recSong.addActionListener(
//                // This creates an anonymous subclass of ActionListener and instantiates it.
//                evt -> {
//                    final JDialog dialog = new JDialog((JFrame) this.getTopLevelAncestor(),
//                            "Song Recommendation", true);
//                    final RecSongView recSongView = new RecSongView();
//                    dialog.getContentPane().add(recSongView.getView());
//                    dialog.pack();
//                    dialog.setResizable(false);
//                    dialog.setLocationRelativeTo(this);
//                    dialog.setVisible(true);
//                }
//        );
//
//        this.add(usernameInfo);
//        this.add(username);
//
//        this.add(buttons);
//    }
//
//    @Override
//    public void propertyChange(PropertyChangeEvent evt) {
//        if (evt.getPropertyName().equals("state")) {
//            final LoggedInState state = (LoggedInState) evt.getNewValue();
//            username.setText(state.getUsername());
//        }
//        else if (evt.getPropertyName().equals("password")) {
//            final LoggedInState state = (LoggedInState) evt.getNewValue();
//            JOptionPane.showMessageDialog(null, "password updated for " + state.getUsername());
//        }
//
//    }
//
//    public String getViewName() {
//        return viewName;
//    }
//
//    public void setLogoutController(LogoutController logoutController) {
//        this.logoutController = logoutController;
//    }
// }
