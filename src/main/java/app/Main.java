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
        final int width = 500;
        final int height = 500;

        final AppBuilder appBuilder = new AppBuilder();
        final JFrame application = appBuilder
                                            .addLoginView()
                                            .addLoggedInView()
                                            .addRecGenreView()
                                            .addRecSongView()
                                            .addRecGenreUseCase()
                                            .addRecSongUseCase()
                                            .addRecArtistView()
                                            //                                            .addRecPlaylistView()
                                            .addLoginUseCase()
                                            .addLogoutUseCase()
                                            .addRecSongUseCase()
                                            .addRecArtistUseCase()
                                            .addRecPlaylistUseCase()
                                            .build();

        // Set the frame size to a larger size (e.g., 1200x800)
        application.setSize(width, height);

        // Ensure the window is centered on the screen
        application.setLocationRelativeTo(null);

        // Make the frame visible
        application.setVisible(true);
    }
}
