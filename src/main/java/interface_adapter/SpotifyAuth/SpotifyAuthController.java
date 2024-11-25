package interface_adapter.spotifyauth

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpotifyAuthController {

    @GetMapping("/callback")
    public String handleSpotifyCallback(
            @RequestParam("access_token") String accessToken,
            @RequestParam("expires_in") int expiresIn
    ) {
        // Store the access token (could integrate with a TokenService)
        System.out.println("Access Token: " + accessToken);
        return "Login successful!";
    }
}