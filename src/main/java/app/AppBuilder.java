package app;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import data_access.InMemoryUserDataAccessObject;
import entity.*;
import interface_adapter.ViewManagerModel;
import interface_adapter.SpotifyAuth.LoginController;
import interface_adapter.SpotifyAuth.LoginPresenter;
import interface_adapter.SpotifyAuth.LoginViewModel;
import interface_adapter.change_password.ChangePasswordController;
import interface_adapter.change_password.ChangePasswordPresenter;
import interface_adapter.change_password.LoggedInViewModel;
import interface_adapter.logout.LogoutController;
import interface_adapter.logout.LogoutPresenter;
import interface_adapter.rec_artist.RecArtistController;
import interface_adapter.rec_artist.RecArtistPresenter;
import interface_adapter.rec_artist.RecArtistViewModel;
import interface_adapter.rec_song.RecSongController;
import interface_adapter.rec_song.RecSongPresenter;
import interface_adapter.rec_song.RecSongViewModel;
import interface_adapter.signup.SignupController;
import interface_adapter.signup.SignupPresenter;
import interface_adapter.signup.SignupViewModel;
import use_case.change_password.ChangePasswordInputBoundary;
import use_case.change_password.ChangePasswordInteractor;
import use_case.change_password.ChangePasswordOutputBoundary;
import use_case.login.LoginInputBoundary;
import use_case.login.LoginInteractor;
import use_case.login.LoginOutputBoundary;
import use_case.logout.LogoutInputBoundary;
import use_case.logout.LogoutInteractor;
import use_case.logout.LogoutOutputBoundary;
import use_case.rec_artist.RecArtistInputBoundary;
import use_case.rec_artist.RecArtistInteractor;
import use_case.rec_artist.RecArtistOutputBoundary;
import use_case.rec_song.RecSongInputBoundary;
import use_case.rec_song.RecSongInteractor;
import use_case.rec_song.RecSongOutputBoundary;
import use_case.signup.SignupInputBoundary;
import use_case.signup.SignupInteractor;
import use_case.signup.SignupOutputBoundary;
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
    // thought question: is the hard dependency below a problem?
    private final ArtistFactory artistFactory = new CommonArtistFactory();
    private final SongFactory songFactory = new CommonSongFactory();
    private final UserFactory userFactory = new CommonUserFactory();
    private final ViewManagerModel viewManagerModel = new ViewManagerModel();
    private final ViewManager viewManager = new ViewManager(cardPanel, cardLayout, viewManagerModel);

    // thought question: is the hard dependency below a problem?
    private final InMemoryUserDataAccessObject userDataAccessObject = new InMemoryUserDataAccessObject();

    private SignupView signupView;
    private SignupViewModel signupViewModel;
    private LoginViewModel loginViewModel;
    private LoggedInViewModel loggedInViewModel;
    private LoggedInView loggedInView;
    private LoginView loginView;
    private RecSongViewModel recSongViewModel;
    private RecSongView recSongView;
    private RecArtistViewModel recArtistViewModel;
    private RecArtistView recArtistView;

    public AppBuilder() {
        cardPanel.setLayout(cardLayout);
    }

    /**
     * Adds the Signup View to the application.
     * @return this builder
     */
    public AppBuilder addSignupView() {
//        View myView = new View.ViewBuilder()
//                .setTitle("Main Window")
//                .setLayout("GridLayout")
//                .addButton("OK")
//                .addButton("Cancel")
//                .addLabel("Username:")
//                .addLabel("Password:")
//                .build();
//
//        // Access the built View object
//        System.out.println("Title: " + myView.getTitle());
//        System.out.println("Layout: " + myView.getLayout());
//        System.out.println("Buttons: " + myView.getButtons());
//        System.out.println("Labels: " + myView.getLabels());
        signupViewModel = new SignupViewModel();
        signupView = new SignupView(signupViewModel);
        cardPanel.add(signupView, signupView.getViewName());
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
     * Adds the Signup Use Case to the application.
     * @return this builder
     */
    public AppBuilder addSignupUseCase() {
        final SignupOutputBoundary signupOutputBoundary = new SignupPresenter(viewManagerModel,
                signupViewModel, loginViewModel);
        final SignupInputBoundary userSignupInteractor = new SignupInteractor(
                userDataAccessObject, signupOutputBoundary, userFactory);

        final SignupController controller = new SignupController(userSignupInteractor);
        signupView.setSignupController(controller);
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
     * Adds the Change Password Use Case to the application.
     * @return this builder
     */
    public AppBuilder addChangePasswordUseCase() {
        //        final ChangePasswordOutputBoundary changePasswordOutputBoundary =
        //                new ChangePasswordPresenter(loggedInViewModel);
        //
        //        final ChangePasswordInputBoundary changePasswordInteractor =
        //                new ChangePasswordInteractor(userDataAccessObject, changePasswordOutputBoundary, userFactory);
        //
        //        final ChangePasswordController changePasswordController =
        //                new ChangePasswordController(changePasswordInteractor);
        //        loggedInView.setChangePasswordController(changePasswordController);
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
                new RecSongInteractor(userDataAccessObject, recSongOutputBoundary, songFactory);

        final RecSongController recSongController = new RecSongController(recSongInteractor);
        recSongView.setRecSongController(recSongController);
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
                new RecArtistInteractor(userDataAccessObject, recArtistOutputBoundary, artistFactory);

        final RecArtistController recArtistController = new RecArtistController(recArtistInteractor);
        recArtistView.setRecArtistController(recArtistController);
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
