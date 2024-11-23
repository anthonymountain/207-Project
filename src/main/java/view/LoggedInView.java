package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

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

/**
 * The View for the LoggedIn Use Case.
 */
public class LoggedInView extends JPanel implements PropertyChangeListener {

    private static final Color SPOTIFY_GREEN = new Color(30, 215, 96);
    private static final Color DARK_BACKGROUND = new Color(24, 24, 32);
    private static final Color BUTTON_TEXT_COLOR = Color.WHITE;

    private static final Font HEADER_FONT = new Font("Futura", Font.BOLD, 18);
    private static final Font BUTTON_FONT = new Font("Futura", Font.PLAIN, 16);
    private static final Font LABEL_FONT = new Font("Futura", Font.PLAIN, 14);

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

        this.add(Box.createRigidArea(new Dimension(0, 10)));
        this.add(username);
        this.add(Box.createRigidArea(new Dimension(0, 20)));
        this.add(buttonsPanel);

        initializeButtonActions(loggedInViewModel);
    }

    private void setupPanelLayout() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBackground(DARK_BACKGROUND);
        this.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
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

        recSong = createRoundedButton("Recommend Song");
        recGenre = createRoundedButton("Recommend Genre");
        logOut = createRoundedButton("Log Out");

        recSong.setAlignmentX(Component.CENTER_ALIGNMENT);
        recGenre.setAlignmentX(Component.CENTER_ALIGNMENT);
        logOut.setAlignmentX(Component.CENTER_ALIGNMENT);

        buttons.add(Box.createRigidArea(new Dimension(0, 10)));
        buttons.add(recSong);
        buttons.add(Box.createRigidArea(new Dimension(0, 10)));
        buttons.add(recGenre);
        buttons.add(Box.createRigidArea(new Dimension(0, 10)));
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

    private JButton createRoundedButton(String text) {
        return new RoundedButton(text);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if ("state".equals(evt.getPropertyName())) {
            final LoggedInState state = (LoggedInState) evt.getNewValue();
            username.setText(state.getUsername());
        } else if ("password".equals(evt.getPropertyName())) {
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

    private static class RoundedButton extends JButton {
        private boolean hovered = false;
        private final int arcSize = 30;

        RoundedButton(String text) {
            super(text);
            setFont(BUTTON_FONT);
            setFocusPainted(false);
            setForeground(BUTTON_TEXT_COLOR);
            setBackground(SPOTIFY_GREEN);
            setContentAreaFilled(false);
            setOpaque(false);
            setCursor(new Cursor(Cursor.HAND_CURSOR));

            addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    hovered = true;
                    setBackground(SPOTIFY_GREEN.darker());
                    repaint();
                }

                @Override
                public void mouseExited(java.awt.event.MouseEvent evt) {
                    hovered = false;
                    setBackground(SPOTIFY_GREEN);
                    repaint();
                }
            });
        }

        @Override
        protected void paintComponent(Graphics g) {
            final Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            final int inset = hovered ? 2 : 0;
            final int x = inset;
            final int y = inset;
            final int width = getWidth() - 2 * inset;
            final int height = getHeight() - 2 * inset;

            g2.setColor(getBackground());
            g2.fill(new RoundRectangle2D.Float(x, y, width, height, arcSize, arcSize));

            g2.setColor(getForeground());
            g2.setFont(getFont());
            final FontMetrics fm = g2.getFontMetrics();
            final int textX = (getWidth() - fm.stringWidth(getText())) / 2;
            final int textY = (getHeight() + fm.getAscent() - fm.getDescent()) / 2;
            g2.drawString(getText(), textX, textY);

            g2.dispose();
        }

        @Override
        protected void paintBorder(Graphics g) {
            final Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(getBackground().darker());
            g2.draw(new RoundRectangle2D.Float(1, 1, getWidth() - 2, getHeight() - 2, arcSize, arcSize));
            g2.dispose();
        }
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
