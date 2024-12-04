package view;

import interface_adapter.ViewManagerModel;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import services.SpotifyAuthService;
import services.TokenService;


import javax.swing.*;

import java.awt.*;

/**
 * A Swing-based UI for logging in to Spotify.
 */
public class SpotifyLoginView extends JPanel{

    private final SpotifyAuthService spotifyAuthService;
    private final TokenService tokenService;
    private final String viewName = "spotify log in";
    private final ViewManagerModel viewManagerModel;

    private JFrame mainFrame;
    private JLabel statusLabel;
    private JButton loginButton;

    public SpotifyLoginView(TokenService tokenService, ViewManagerModel viewManagerModel) {
        this.spotifyAuthService = new SpotifyAuthService();
        this.tokenService = tokenService;
        this.viewManagerModel = viewManagerModel;
    }

    /**
     * Displays the Spotify login UI.
     */
    public void showUI() {
        // Initialize Main Frame
        mainFrame = new JFrame("Spotify Login");
        mainFrame.setLocationRelativeTo(null);
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
     * Initiates the Spotify login process using JavaFX WebView.
     */
    private void logInToSpotify() {
        // Start the JavaFX WebView in a Swing Frame for Spotify login
        SwingUtilities.invokeLater(() -> {
            // Create a new JFrame to hold the JavaFX WebView
            JFrame webViewFrame = new JFrame("Spotify Authorization");
            webViewFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            webViewFrame.setSize(800, 800);

            // Create JavaFX Panel to integrate JavaFX into Swing
            JFXPanel fxPanel = new JFXPanel();
            webViewFrame.add(fxPanel);
            webViewFrame.setVisible(true);

            // Create JavaFX WebView in the JFXPanel
            Platform.runLater(() -> {
                WebView webView = new WebView();
                WebEngine webEngine = webView.getEngine();

                // Set up the listener to capture the access token from the URL
                webEngine.locationProperty().addListener((observable, oldValue, newValue) -> {
                    if (newValue.contains("access_token")) {
                        // Extract the access token from the URL fragment
                        String[] parts = newValue.split("#");
                        if (parts.length > 1) {
                            String[] params = parts[1].split("&");
                            for (String param : params) {
                                if (param.startsWith("access_token=")) {
                                    String accessToken = param.split("=")[1];
                                    updateAccessToken(accessToken, 3600); // Store the token with a 1-hour expiration
                                    System.out.println("Access Token: " + accessToken);
                                    statusLabel.setText("Logged in successfully");
                                    webViewFrame.dispose(); // Close the WebView window after successful login
                                    // Makes it go to the LoggedInView
                                    viewManagerModel.setState("logged in");
                                    viewManagerModel.firePropertyChanged();
                                }
                            }
                        }
                    }
                });

                // Load the Spotify authorization URL
                String authUrl = spotifyAuthService.getAuthUrl();
                webEngine.load(authUrl);

                // Set the scene on the JFXPanel
                Scene scene = new Scene(webView);
                fxPanel.setScene(scene);
            });
        });
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

    /**
     * Returns the name of the view.
     *
     * @return The name of the view.
     */
    public String getViewName() {
        return viewName;
}
}
