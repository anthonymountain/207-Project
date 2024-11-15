package app;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import data_access.InMemoryUserDataAccessObject;
import entity.CommonSongFactory;
import entity.CommonUserFactory;
import entity.SongFactory;
import entity.UserFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.change_password.LoggedInViewModel;
import interface_adapter.login.LoginViewModel;
import interface_adapter.rec_song.RecSongViewModel;
import interface_adapter.signup.SignupViewModel;
import view.*;

import java.awt.*;

/**
 * The ViewBuilder class is responsible for putting together the pieces of
 * our CA architecture; piece by piece.
 * <p/>
 * This is done by adding each View.
 */
public class ViewBuilder {
    private final JPanel cardPanel = new JPanel();
    private final CardLayout cardLayout = new CardLayout();
    private final SongFactory songFactory = new CommonSongFactory();
    private final UserFactory userFactory = new CommonUserFactory();
    private final ViewManagerModel viewManagerModel = new ViewManagerModel();
    private final ViewManager viewManager = new ViewManager(cardPanel, cardLayout, viewManagerModel);

    private final InMemoryUserDataAccessObject userDataAccessObject = new InMemoryUserDataAccessObject();

    private SignupView signupView;
    private SignupViewModel signupViewModel;
    private LoginViewModel loginViewModel;
    private LoggedInViewModel loggedInViewModel;
    private LoggedInView loggedInView;
    private LoginView loginView;
    private RecSongViewModel recSongViewModel;
    private RecSongView recSongView;

    public ViewBuilder() {
        cardPanel.setLayout(cardLayout);
    }

    /**
     * Adds the Signup View to the application.
     * @return this builder
     */
    public SignupView createSignupView() {
        signupViewModel = new SignupViewModel();
        signupView = new SignupView(signupViewModel);
        cardPanel.add(signupView, signupView.getViewName());
        return signupView;
    }

    /**
     * Adds the Login View to the application.
     * @return this builder
     */
    public LoginView createLoginView() {
        loginViewModel = new LoginViewModel();
        loginView = new LoginView(loginViewModel);
        cardPanel.add(loginView, loginView.getViewName());
        return loginView;
    }

    /**
     * Adds the LoggedIn View to the application.
     * @return this builder
     */
    public LoggedInView createLoggedInView() {
        loggedInViewModel = new LoggedInViewModel();
        loggedInView = new LoggedInView(loggedInViewModel);
        cardPanel.add(loggedInView, loggedInView.getViewName());
        return loggedInView;
    }

    /**
     * Adds the RecSong View to the application.
     * @return this builder
     */
    public RecSongView createRecSongView() {
        recSongViewModel = new RecSongViewModel();
        recSongView = new RecSongView(recSongViewModel);
        cardPanel.add(recSongView, recSongView.getViewName());
        return recSongView;
    }
}