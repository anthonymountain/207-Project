package interface_adapter.spotify_auth;

import interface_adapter.ViewModel;

/**
 * The View Model for the Login View.
 */
public class LoginViewModel extends ViewModel<LoginState> {

    public LoginViewModel() {
        super("log in");
        setState(new LoginState());
    }

}
