package view;

import interface_adapter.change_password.LoggedInState;
import interface_adapter.change_password.LoggedInViewModel;
import interface_adapter.logout.LogoutController;
import interface_adapter.rec_song.RecSongController;
import interface_adapter.rec_song.RecSongViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class LoggedInView extends JPanel implements PropertyChangeListener {

    private final String viewName = "logged in";
    private final LoggedInViewModel loggedInViewModel;
    private final RecSongViewModel recSongViewModel;
    private LogoutController logoutController;
    private RecSongController recSongController;

    private final JLabel username;

    private final JButton logOut;

    private final JButton recSong;

    private final JButton recGenre;

    // Spotify-inspired colors
    private static final Color SPOTIFY_GREEN = new Color(30, 215, 96);
    private static final Color DARK_BACKGROUND = new Color(24, 24, 32);
    private static final Color BUTTON_TEXT_COLOR = Color.WHITE;

    // Fonts similar to Nord
    private static final Font HEADER_FONT = new Font("Futura", Font.BOLD, 18);
    private static final Font BUTTON_FONT = new Font("Futura", Font.PLAIN, 16);
    private static final Font LABEL_FONT = new Font("Futura", Font.PLAIN, 14);

    public LoggedInView(LoggedInViewModel loggedInViewModel) {
        this.loggedInViewModel = loggedInViewModel;
        this.recSongViewModel = new RecSongViewModel();
        this.loggedInViewModel.addPropertyChangeListener(this);

        // Set layout and background
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBackground(DARK_BACKGROUND);
        this.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Username label
        final JLabel usernameInfo = new JLabel("Currently logged in:");
        usernameInfo.setFont(LABEL_FONT);
        usernameInfo.setForeground(BUTTON_TEXT_COLOR);
        usernameInfo.setAlignmentX(Component.CENTER_ALIGNMENT);

        username = new JLabel();
        username.setFont(HEADER_FONT);
        username.setForeground(SPOTIFY_GREEN);
        username.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Buttons panel
        final JPanel buttons = new JPanel();
        buttons.setLayout(new BoxLayout(buttons, BoxLayout.Y_AXIS));
        buttons.setBackground(DARK_BACKGROUND);
        buttons.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Recommend Song button
        recSong = createRoundedButton("Recommend Song");
        recSong.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttons.add(Box.createRigidArea(new Dimension(0, 10))); // Spacing
        buttons.add(recSong);

        // Recommend Genre button
        recGenre = createRoundedButton("Recommend Genre");
        recGenre.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttons.add(Box.createRigidArea(new Dimension(0, 10))); // Spacing
        buttons.add(recGenre);

        // Log Out button
        logOut = createRoundedButton("Log Out");
        logOut.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttons.add(Box.createRigidArea(new Dimension(0, 10))); // Spacing
        buttons.add(logOut);

        // Add components to the panel
        this.add(usernameInfo);
        this.add(Box.createRigidArea(new Dimension(0, 10))); // Spacing
        this.add(username);
        this.add(Box.createRigidArea(new Dimension(0, 20))); // Spacing
        this.add(buttons);

        // Add button functionality
        logOut.addActionListener(evt -> {
            if (evt.getSource().equals(logOut)) {
                final LoggedInState currentState = loggedInViewModel.getState();
                logoutController.execute(currentState.getUsername());
            }
        });

        recGenre.addActionListener(evt -> {
            final JDialog dialog = new JDialog((JFrame) this.getTopLevelAncestor(),
                    "Genre Recommendation", true);
            final RecGenreView recGenreView = new RecGenreView();
            dialog.getContentPane().add(recGenreView.getView());
            dialog.pack();
            dialog.setResizable(false);
            dialog.setLocationRelativeTo(this);
            dialog.setVisible(true);
        });

        recSong.addActionListener(evt -> {
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

    // Helper method to create a rounded button
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

    // Custom button class for rounded buttons
    private static class RoundedButton extends JButton {
        private boolean hovered = false; // Track hover state
        private final int arcSize = 30;  // Arc size for rounded corners

        public RoundedButton(String text) {
            super(text);
            setFont(BUTTON_FONT);
            setFocusPainted(false);
            setForeground(BUTTON_TEXT_COLOR);
            setBackground(SPOTIFY_GREEN);
            setContentAreaFilled(false);
            setOpaque(false);
            setCursor(new Cursor(Cursor.HAND_CURSOR));

            // Add hover effects
            addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    hovered = true;
                    setBackground(SPOTIFY_GREEN.darker()); // Darker shade on hover
                    repaint(); // Request a redraw to reflect the changes
                }

                @Override
                public void mouseExited(java.awt.event.MouseEvent evt) {
                    hovered = false;
                    setBackground(SPOTIFY_GREEN); // Reset to original color
                    repaint(); // Request a redraw to reflect the changes
                }
            });
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            // Set button size for hover effect
            int inset = hovered ? 2 : 0; // Slightly reduce size when hovered for a subtle zoom effect
            int x = inset;
            int y = inset;
            int width = getWidth() - 2 * inset;
            int height = getHeight() - 2 * inset;

            // Draw rounded rectangle background
            g2.setColor(getBackground());
            g2.fill(new RoundRectangle2D.Float(x, y, width, height, arcSize, arcSize));

            // Draw the text
            g2.setColor(getForeground());
            g2.setFont(getFont());
            FontMetrics fm = g2.getFontMetrics();
            int textX = (getWidth() - fm.stringWidth(getText())) / 2;
            int textY = (getHeight() + fm.getAscent() - fm.getDescent()) / 2;
            g2.drawString(getText(), textX, textY);

            g2.dispose();
        }

        @Override
        protected void paintBorder(Graphics g) {
            // Optional: Smooth border for the button
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(getBackground().darker());
            g2.draw(new RoundRectangle2D.Float(1, 1, getWidth() - 2, getHeight() - 2, arcSize, arcSize));
            g2.dispose();
        }
    }
}


//package view;
//
//import java.awt.Component;
//import java.beans.PropertyChangeEvent;
//import java.beans.PropertyChangeListener;
//
//import javax.swing.BoxLayout;
//import javax.swing.JButton;
//import javax.swing.JDialog;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JOptionPane;
//import javax.swing.JPanel;
//import javax.swing.JTextField;
//import javax.swing.event.DocumentEvent;
//import javax.swing.event.DocumentListener;
//
//import interface_adapter.change_password.ChangePasswordController;
//import interface_adapter.change_password.LoggedInState;
//import interface_adapter.change_password.LoggedInViewModel;
//import interface_adapter.logout.LogoutController;
//import interface_adapter.rec_song.RecSongController;
//import interface_adapter.rec_song.RecSongViewModel;
//
///**
// * The View for when the user is logged into the program.
// */
//public class LoggedInView extends JPanel implements PropertyChangeListener {
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
//}
