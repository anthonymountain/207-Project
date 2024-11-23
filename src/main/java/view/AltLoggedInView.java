package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import interface_adapter.change_password.LoggedInState;
import interface_adapter.change_password.LoggedInViewModel;
import interface_adapter.logout.LogoutController;

/**
 * Spotify-inspired View for when the user is logged into the program.
 */
public class AltLoggedInView extends JPanel implements PropertyChangeListener {

    private final String viewName = "logged in";
    private final LoggedInViewModel loggedInViewModel;
    private LogoutController logoutController;

    private final JLabel usernameLabel;
    private final JButton logOutButton;
    private final JButton recommendSongButton;
    private final JButton recommendGenreButton;

    // Spotify Colors
    private static final Color SPOTIFY_GREEN = new Color(30, 215, 96);
    private static final Color DARK_BACKGROUND = new Color(25, 20, 20);
    private static final Color DARK_GRAY = new Color(40, 40, 40);
    private static final Color LIGHT_TEXT = new Color(245, 245, 245);

    public AltLoggedInView(LoggedInViewModel loggedInViewModel) {
        this.loggedInViewModel = loggedInViewModel;
        this.loggedInViewModel.addPropertyChangeListener(this);

        // Set layout and background color
        this.setLayout(new BorderLayout(10, 10));
        this.setBackground(DARK_BACKGROUND);
        this.setBorder(new EmptyBorder(20, 20, 20, 20));

        // Header Panel
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(DARK_BACKGROUND);
        JLabel titleLabel = new JLabel("Welcome to Your Dashboard");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(SPOTIFY_GREEN);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        headerPanel.add(titleLabel, BorderLayout.NORTH);

        usernameLabel = new JLabel("Currently logged in: ");
        usernameLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        usernameLabel.setForeground(LIGHT_TEXT);
        usernameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        headerPanel.add(usernameLabel, BorderLayout.CENTER);
        this.add(headerPanel, BorderLayout.NORTH);

        // Buttons Panel
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.Y_AXIS));
        buttonsPanel.setBackground(DARK_BACKGROUND);

        recommendSongButton = createStyledButton("Recommend Song");
        recommendGenreButton = createStyledButton("Recommend Genre");
        logOutButton = createStyledButton("Log Out");

        buttonsPanel.add(recommendSongButton);
        buttonsPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        buttonsPanel.add(recommendGenreButton);
        buttonsPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        buttonsPanel.add(logOutButton);

        this.add(buttonsPanel, BorderLayout.CENTER);

        // Add Action Listeners
        logOutButton.addActionListener(evt -> {
            final LoggedInState currentState = loggedInViewModel.getState();
            logoutController.execute(currentState.getUsername());
        });

        recommendSongButton.addActionListener(evt -> showRecommendationDialog("Song Recommendation"));
        recommendGenreButton.addActionListener(evt -> showRecommendationDialog("Genre Recommendation"));
    }

    // Helper method to create a Spotify-style button
    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setFocusPainted(false);
        button.setBackground(SPOTIFY_GREEN);
        button.setForeground(DARK_BACKGROUND);
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Add hover effect
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(SPOTIFY_GREEN.darker());
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(SPOTIFY_GREEN);
            }
        });

        return button;
    }

    // Helper method to show a dialog
    private void showRecommendationDialog(String title) {
        JDialog dialog = new JDialog((JFrame) this.getTopLevelAncestor(), title, true);
        dialog.getContentPane().add(new JLabel("Recommendation Content Goes Here!")); // Replace with actual content
        dialog.pack();
        dialog.setResizable(false);
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("state")) {
            LoggedInState state = (LoggedInState) evt.getNewValue();
            usernameLabel.setText("Currently logged in: " + state.getUsername());
        }
    }

    public String getViewName() {
        return viewName;
    }

    public void setLogoutController(LogoutController logoutController) {
        this.logoutController = logoutController;
    }
}
