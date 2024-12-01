package interface_adapter.spotify_auth;

import services.SpotifyAuthService;
import services.TokenService;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

@Component
public class SpotifyLoginUI {

    private final SpotifyAuthService spotifyAuthService;
    private final TokenService tokenService;

    private JFrame mainFrame;
    private JLabel statusLabel;
    private JButton loginButton;

    public SpotifyLoginUI(SpotifyAuthService spotifyAuthService, TokenService tokenService) {
        this.spotifyAuthService = spotifyAuthService;
        this.tokenService = tokenService;
    }

    /**
     * Displays the Spotify login UI.
     */
    public void showUI() {
        // Initialize Main Frame
        mainFrame = new JFrame("Spotify Login");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(400, 200);
        mainFrame.setLayout(new BorderLayout());

        // Status Panel
        JPanel statusPanel = new JPanel(new BorderLayout());
        statusLabel = new JLabel("Not logged in", SwingConstants.CENTER);
        statusPanel.add(statusLabel, BorderLayout.CENTER);

        // Login Button
        loginButton = new JButton("Log in to Spotify");
        loginButton.addActionListener(e -> logInToSpotify());

        // Add Components to Main Frame
        mainFrame.add(statusPanel, BorderLayout.NORTH);
        mainFrame.add(loginButton, BorderLayout.CENTER);

        mainFrame.setVisible(true);
    }

    /**
     * Initiates the Spotify login process.
     */
    private void logInToSpotify() {
        try {
            spotifyAuthService.initiateLogin();
            JOptionPane.showMessageDialog(mainFrame, "Login initiated. Complete login in the browser.");
        } catch (Exception e) {
            showError("Failed to initiate login: " + e.getMessage());
        }
    }

    /**
     * Updates the UI to indicate login success and stores the token using TokenService.
     *
     * @param accessToken       The Spotify access token.
     * @param expiresInSeconds  The token's expiration time in seconds.
     */
    public void updateAccessToken(String accessToken, int expiresInSeconds) {
        try {
            // Store the token using TokenService
            tokenService.storeToken(accessToken, expiresInSeconds);

            // Update the UI status
            statusLabel.setText("Logged in successfully");

            JOptionPane.showMessageDialog(mainFrame, "Access token stored. You can now use the app.");
            mainFrame.dispose(); // Close the login window
        } catch (Exception e) {
            showError("Failed to store access token: " + e.getMessage());
        }
    }

    /**
     * Displays an error message in a popup dialog.
     *
     * @param message The error message to display.
     */
    private void showError(String message) {
        JOptionPane.showMessageDialog(mainFrame, message, "Error", JOptionPane.ERROR_MESSAGE);
    }
}
