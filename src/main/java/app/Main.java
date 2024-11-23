package app;

import javax.swing.JFrame;

/**
 * The Main class of our application.
 */
public class Main {
    /**
     * Builds and runs the CA architecture of the application.
     * @param args unused arguments
     */
    public static void main(String[] args) {
        final AppBuilder appBuilder = new AppBuilder();
        final JFrame application = appBuilder
                .addLoginView()
                .addSignupView()
                .addLoggedInView()
                .addRecGenreView()
                .addRecSongView()
                .addRecGenreUseCase()
                .addRecSongUseCase()
                .addSignupUseCase()
                .addLoginUseCase()
                .addChangePasswordUseCase()
                .addLogoutUseCase()
                .build();

        // Set the frame size to a larger size (e.g., 1200x800)
        application.setSize(800, 500);

        // Ensure the window is centered on the screen
        application.setLocationRelativeTo(null);

        // Make the frame visible
        application.setVisible(true);
    }
}
