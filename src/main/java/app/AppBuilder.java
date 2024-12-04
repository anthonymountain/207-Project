package app;

import java.awt.CardLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import ch.qos.logback.core.subst.Token;
import data_access.*;
import entity.*;
import interface_adapter.ViewManagerModel;
import interface_adapter.loggedin.*;
import interface_adapter.logout.*;
import interface_adapter.rec_artist.*;
import interface_adapter.rec_genre.*;
import interface_adapter.rec_playlist.*;
import interface_adapter.rec_song.*;
import interface_adapter.spotify_auth.*;
import org.jetbrains.annotations.NotNull;
import services.TokenService;
import use_case.login.*;
import use_case.logout.*;
import use_case.rec_artist.*;
import use_case.rec_genre.*;
import use_case.rec_playlist.*;
import use_case.rec_song.*;
import view.*;

/**
 * The AppBuilder class is responsible for putting together the pieces of
 * our CA architecture; piece by piece.
 * <p/>
 * This is done by adding each View and then adding related Use Cases.
 */
// Checkstyle note: you can ignore the "Class Data Abstraction Coupling"
//                  and the "Class Fan-Out Complexity" issues for this lab; we encourage
//                  your team to think about ways to refactor the code to resolve these
//                  if your team decides to work with this as your starter code
//                  for your final project this term.
public class AppBuilder {
    private final JPanel cardPanel = new JPanel();
    private final CardLayout cardLayout = new CardLayout();
    private final User user = new User();
    private final Track track = new Track();
    private final Genre genre = new Genre();
    private final Artist artist = new Artist();
    private final Playlist playlist = new Playlist();
    // thought question: is the hard dependency below a problem?
    private final ViewManagerModel viewManagerModel = new ViewManagerModel();
    private final ViewManager viewManager = new ViewManager(cardPanel, cardLayout, viewManagerModel);

    // thought question: is the hard dependency below a problem?
    private final InMemoryUserDataAccessObject userDataAccessObject = new InMemoryUserDataAccessObject();
    private final TokenService tokenService = new TokenService();
    private final spotifyLoginView spotifyLoginView = new spotifyLoginView(tokenService, viewManagerModel);
    private final SpotifyAuthController spotifyAuthController = new SpotifyAuthController(tokenService);
    private final InMemorySongDataAccessObject songDataAccessObject = new InMemorySongDataAccessObject(spotifyAuthController);
    private final InMemoryPlaylistDataAccessObject playlistDataAccessObject = new InMemoryPlaylistDataAccessObject(spotifyAuthController);
    private final InMemoryArtistDataAccessObject artistDataAccessObject = new InMemoryArtistDataAccessObject(spotifyAuthController);
    private final GenreDataAccessObject genreDataAccessObject = new GenreDataAccessObject(spotifyAuthController);

    private LoginViewModel loginViewModel;
    private LoggedInViewModel loggedInViewModel;
    private LoggedInView loggedInView;
    private LoginView loginView;
    private RecGenreViewModel recGenreViewModel;
    private RecGenreView recGenreView;
    private RecSongViewModel recSongViewModel;
    private RecSongView recSongView;
    private RecArtistViewModel recArtistViewModel;
    private RecArtistView recArtistView;
    private RecPlaylistView recPlaylistView;
    private RecPlaylistViewModel recPlaylistViewModel;

    public AppBuilder() {
        cardPanel.setLayout(cardLayout);
    }

    /**
     * Adds the Spotify Login View to the application.
     * @return this builder
     */
    public AppBuilder addSpotifyLoginView() {
        spotifyLoginView.showUI();
        return this;
    }

    /**
     * Adds the Login View to the application.
     * @return this builder
     */
    public AppBuilder addLoginView() {
        loginViewModel = new LoginViewModel();
        loginView = new LoginView(loginViewModel);
        cardPanel.add(loginView, loginView.getViewName());
        return this;
    }

    /**
     * Adds the LoggedIn View to the application.
     * @return this builder
     */
    public AppBuilder addLoggedInView() {
        loggedInViewModel = new LoggedInViewModel();
        loggedInView = new LoggedInView(loggedInViewModel);
        cardPanel.add(loggedInView, loggedInView.getViewName());
        return this;
    }

    /**
     * Adds the RecSong View to the application.
     * @return this builder
     */
    public AppBuilder addRecGenreView() {

        return getAppBuilder();
    }

    /**
     * Adds the RecSong View to the application.
     * @return this builder
     */
    public AppBuilder addRecSongView() {
        this.recSongView = new RecSongView();
        cardPanel.add(recSongView.getView(), "Recommended Song");
        return this;
    }

    //    /**
    //     * Adds the RecArtist View to the application.
    //     * @return this builder
    //     */
    //    public AppBuilder addRecArtistView() {
    //        this.recArtistView = new RecArtistView();
    //        cardPanel.add(recArtistView.getView(), "Recommended Artist");
    //        return this;
    //    }

    //    /**
    //     * Adds the RecPlaylist View to the application.
    //     * @return this builder
    //     */
    //    public AppBuilder addRecPlaylistView() {
    //        recPlaylistView = new RecPlaylistView();
    //        cardPanel.add(recPlaylistView, "Recommended Playlist");
    //        return this;
    //    }

    /**
     * Adds the Login Use Case to the application.
     * @return this builder
     */
    public AppBuilder addLoginUseCase() {
        final LoginOutputBoundary loginOutputBoundary = new LoginPresenter(viewManagerModel,
                loggedInViewModel, loginViewModel);
        final LoginInputBoundary loginInteractor = new LoginInteractor(
                userDataAccessObject, loginOutputBoundary);

        final LoginController loginController = new LoginController(loginInteractor);
        loginView.setLoginController(loginController);
        return this;
    }

    /**
     * Adds the Logout Use Case to the application.
     * @return this builder
     */
    public AppBuilder addLogoutUseCase() {
        final LogoutOutputBoundary logoutOutputBoundary = new LogoutPresenter(viewManagerModel,
                loggedInViewModel, loginViewModel);

        final LogoutInputBoundary logoutInteractor =
                new LogoutInteractor(userDataAccessObject, logoutOutputBoundary);

        final LogoutController logoutController = new LogoutController(logoutInteractor);
        loggedInView.setLogoutController(logoutController);
        return this;
    }

    /**
     * Adds the RecSong Use Case to the application.
     * @return this builder
     */
    public AppBuilder addRecSongUseCase() {
        final RecSongOutputBoundary recSongOutputBoundary = new RecSongPresenter(viewManagerModel, recSongViewModel);

        final RecSongInputBoundary recSongInteractor =
                new RecSongInteractor(songDataAccessObject, recSongOutputBoundary);

        final RecSongController recSongController = new RecSongController(recSongInteractor);
        loggedInView.setRecSongController(recSongController);
        return this;
    }

    /**
     * Adds the RecGenre Use Case to the application.
     * @return this builder
     */
    public AppBuilder addRecGenreUseCase() {

        return getAppBuilder();
    }

    @NotNull
    private AppBuilder getAppBuilder() {
        final RecGenreOutputBoundary recGenreOutputBoundary =
                new RecGenrePresenter(recGenreViewModel, recGenreView);

        final RecGenreInputBoundary recGenreInteractor =
                new RecGenreInteractor(genreDataAccessObject, recGenreOutputBoundary);

        final RecGenreController recGenreController = new RecGenreController(recGenreInteractor);

        this.recGenreView = new RecGenreView(recGenreController);
        cardPanel.add(recGenreView.getView(), "Recommended Genre");

        return this;
    }

    /**
     * Adds the RecArtist Use Case to the application.
     * @return this builder
     */
    public AppBuilder addRecArtistUseCase() {
        final RecArtistOutputBoundary recArtistOutputBoundary = new RecArtistPresenter(viewManagerModel,
                recArtistViewModel);

        final RecArtistInputBoundary recArtistInteractor =
                new RecArtistInteractor(artistDataAccessObject, recArtistOutputBoundary);

        final RecArtistController recArtistController = new RecArtistController(recArtistInteractor);
        loggedInView.setRecArtistController(recArtistController);
        return this;
    }

    /**
     * Adds the RecPlaylist Use Case to the application.
     * @return this builder
     */
    public AppBuilder addRecPlaylistUseCase() {
        final RecPlaylistOutputBoundary recPlaylistOutputBoundary = new RecPlaylistPresenter(viewManagerModel,
            recPlaylistViewModel);

        final RecPlaylistInputBoundary recPlaylistInteractor =
                new RecPlaylistInteractor(playlistDataAccessObject, recPlaylistOutputBoundary);

        final RecPlaylistController recPlaylistController = new RecPlaylistController(recPlaylistInteractor);
        // Lowkey setting the RecPlaylistController to the recPlaylist View is probably useless
        // instead we should probably be setting an import playlist controller or something.
        loggedInView.setRecPlaylistController(recPlaylistController);
        return this;
    }

    /**
     * Creates the JFrame for the application and initially sets the SignupView to be displayed.
     * @return the application
     */
    public JFrame build() {
        final JFrame application = new JFrame("Menu");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        application.add(cardPanel);

        viewManagerModel.setState(spotifyLoginView.getViewName());
        viewManagerModel.firePropertyChanged();

        return application;
    }
}
