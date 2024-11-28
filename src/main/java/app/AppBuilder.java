package app;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import data_access.InMemoryPlaylistDataAccessObject;
import data_access.InMemoryUserDataAccessObject;
import entity.Track;
import entity.User;
import entity.Genre;
import entity.Artist;
import entity.Playlist;
import view.LoginView;
import view.RecArtistView;
import view.RecGenreView;
import view.RecPlaylistView;
import view.RecSongView;
import view.ViewManager;
import interface_adapter.spotify_auth.LoginController;
import interface_adapter.spotify_auth.LoginPresenter;
import interface_adapter.spotify_auth.LoginViewModel;
import interface_adapter.loggedin.LoggedInViewModel;
import view.LoggedInView;
import interface_adapter.ViewManagerModel;
import interface_adapter.logout.LogoutController;
import interface_adapter.logout.LogoutPresenter;
import interface_adapter.rec_artist.RecArtistController;
import interface_adapter.rec_artist.RecArtistPresenter;
import interface_adapter.rec_artist.RecArtistViewModel;
import interface_adapter.rec_genre.RecGenreController;
import interface_adapter.rec_genre.RecGenrePresenter;
import interface_adapter.rec_genre.RecGenreViewModel;
import interface_adapter.rec_playlist.RecPlaylistController;
import interface_adapter.rec_playlist.RecPlaylistPresenter;
import interface_adapter.rec_playlist.RecPlaylistViewModel;
import interface_adapter.rec_song.RecSongController;
import interface_adapter.rec_song.RecSongPresenter;
import interface_adapter.rec_song.RecSongViewModel;
import use_case.login.LoginInputBoundary;
import use_case.login.LoginInteractor;
import use_case.login.LoginOutputBoundary;
import use_case.logout.LogoutInputBoundary;
import use_case.logout.LogoutInteractor;
import use_case.logout.LogoutOutputBoundary;
import use_case.rec_artist.RecArtistInputBoundary;
import use_case.rec_artist.RecArtistInteractor;
import use_case.rec_artist.RecArtistOutputBoundary;
import use_case.rec_genre.RecGenreInputBoundary;
import use_case.rec_genre.RecGenreInteractor;
import use_case.rec_genre.RecGenreOutputBoundary;
import use_case.rec_playlist.RecPlaylistInputBoundary;
import use_case.rec_playlist.RecPlaylistInteractor;
import use_case.rec_playlist.RecPlaylistOutputBoundary;
import use_case.rec_song.RecSongInputBoundary;
import use_case.rec_song.RecSongInteractor;
import use_case.rec_song.RecSongOutputBoundary;

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
    private final InMemoryPlaylistDataAccessObject playlistDataAccessObject = new InMemoryPlaylistDataAccessObject();

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
    private RecPlaylistViewModel recPlaylistViewModel = new RecPlaylistViewModel();

    public AppBuilder() {
        cardPanel.setLayout(cardLayout);
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
        this.recGenreView = new RecGenreView();
        cardPanel.add(recGenreView.getView(), "Recommended Genre");
        return this;
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

    /**
     * Adds the RecArtist View to the application.
     * @return this builder
     */
    public AppBuilder addRecArtistView() {
        this.recArtistView = new RecArtistView();
        cardPanel.add(recArtistView.getView(), "Recommended Artist");
        return this;
    }

    /**
     * Adds the RecPlaylist View to the application.
     * @return this builder
     */
    public AppBuilder addRecPlaylistView() {
        recPlaylistView = new RecPlaylistView();
        cardPanel.add(recPlaylistView.getView(), "Recommended Playlist");
        return this;
    }

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
                new RecSongInteractor(userDataAccessObject, recSongOutputBoundary);

        final RecSongController recSongController = new RecSongController(recSongInteractor);
        // Prob unnecessary, since we only call the RecSongController from the loggedInView
        recSongView.setRecSongController(recSongController);
        loggedInView.setRecSongController(recSongController);
        return this;
    }

    /**
     * Adds the RecGenre Use Case to the application.
     * @return this builder
     */
    public AppBuilder addRecGenreUseCase() {
        // Initialize RecGenreViewModel and ViewManagerModel before use
        final RecGenreViewModel recGenreViewModel = new RecGenreViewModel();
        final ViewManagerModel viewManagerModel = new ViewManagerModel();

        // Pass initialized ViewModel and ViewManagerModel to the Presenter
        final RecGenreOutputBoundary recGenreOutputBoundary =
             new RecGenrePresenter(recGenreViewModel, viewManagerModel);

        // Create Interactor with initialized Presenter
        final RecGenreInputBoundary recGenreInteractor = 
            new RecGenreInteractor(userDataAccessObject, recGenreOutputBoundary);

        // Create Controller with initialized Interactor
        final RecGenreController recGenreController = new RecGenreController(recGenreInteractor);

        // Set Controller in the View
        recGenreView.setRecGenreController(recGenreController);

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
                new RecArtistInteractor(userDataAccessObject, recArtistOutputBoundary);
        final RecArtistController recArtistController = new RecArtistController(recArtistInteractor);
        // Prob unnecessary, we only make calls to the RecArtistController from the LoggedinView
        recArtistView.setRecArtistController(recArtistController);
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
        recPlaylistView.setRecPlaylistController(recPlaylistController);
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

        viewManagerModel.setState(loggedInView.getViewName());
        viewManagerModel.firePropertyChanged();

        return application;
    }
}
