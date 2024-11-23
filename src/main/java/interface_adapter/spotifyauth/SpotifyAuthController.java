package interface_adapter.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SpotifyAuthController {

    private static final String CLIENT_ID = "YOUR_SPOTIFY_CLIENT_ID";
    private static final String REDIRECT_URI = "http://localhost:8080/callback";
    private static final String STATE_KEY = "spotify_auth_state";

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        // Generate random state
        final String state = generateRandomString(16);

        // Save the state in the session or a cookie
        // For simplicity, using a session attribute
        // session.setAttribute(STATE_KEY, state);

        // Build the Spotify authorization URL
        final String authorizationUrl = "https://accounts.spotify.com/authorize"
                + "?response_type=token"
                + "&client_id=" + CLIENT_ID
                + "&redirect_uri=" + REDIRECT_URI
                + "&state=" + state
                + "&scope=user-read-private user-read-email";

        return "redirect:" + authorizationUrl;
    }

    @GetMapping("/callback")
    public String callback(@RequestParam String access_token, @RequestParam String state, Model model) {
        // Here, you can make an API call to Spotify to retrieve user data using the
        // access token
        // For now, we'll just display the access token
        model.addAttribute("access_token", access_token);
        model.addAttribute("state", state);
        return "profile";
    }

    // Helper method to generate random string
    private String generateRandomString(int length) {
        final String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        final StringBuilder result = new StringBuilder();
        for (int i = 0; i < length; i++) {
            final int index = (int) (Math.random() * characters.length());
            result.append(characters.charAt(index));
        }
        return result.toString();
    }
}