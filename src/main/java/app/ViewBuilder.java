package app;

import javax.swing.JPanel;

import interface_adapter.ViewManagerModel;
import interface_adapter.change_password.LoggedInViewModel;
import interface_adapter.login.LoginViewModel;
import interface_adapter.rec_song.RecSongViewModel;
import interface_adapter.signup.SignupViewModel;
import view.*;

/**
 * The ViewBuilder class is responsible for putting together the pieces of
 * our CA architecture; piece by piece.
 * <p/>
 * This is done by adding each View.
 */
public class ViewBuilder {
    private final JPanel cardPanel;
    private final ViewManagerModel viewManagerModel;

    public ViewBuilder(JPanel cardPanel, ViewManagerModel viewManagerModel) {
        this.cardPanel = cardPanel;
        this.viewManagerModel = viewManagerModel;
    }

    /**
     * Adds the Signup View to the application.
     * @param signupViewModel a view model
     * @return this builder
     */
    public SignupView createSignupView(SignupViewModel signupViewModel) {
        final SignupView signupView = new SignupView(signupViewModel);
        cardPanel.add(signupView, signupView.getViewName());
        return signupView;
    }

    /**
     * Adds the Signup View to the application.
     * @param loginViewModel a view model
     * @return this builder
     */
    public LoginView createLoginView(LoginViewModel loginViewModel) {
        final LoginView loginView = new LoginView(loginViewModel);
        cardPanel.add(loginView, loginView.getViewName());
        return loginView;
    }

    /**
     * Adds the Signup View to the application.
     * @param loggedInViewModel a view model
     * @return this builder
     */
    public LoggedInView createLoggedInView(LoggedInViewModel loggedInViewModel) {
        final LoggedInView loggedInView = new LoggedInView(loggedInViewModel);
        cardPanel.add(loggedInView, loggedInView.getViewName());
        return loggedInView;
    }

    /**
     * Adds the Signup View to the application.
     * @param recSongViewModel a view model
     * @return this builder
     */
    public RecSongView createRecSongView(RecSongViewModel recSongViewModel) {
        final RecSongView recSongView = new RecSongView(recSongViewModel);
        cardPanel.add(recSongView, recSongView.getViewName());
        return recSongView;
    }
}
