package services;

import interface_adapter.spotify_auth.SpotifyConfig;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

@Service
public class SpotifyAuthService {

    private final SpotifyConfig spotifyConfig;
    private final TokenService tokenService;

    public SpotifyAuthService(SpotifyConfig spotifyConfig, TokenService tokenService) {
        this.spotifyConfig = spotifyConfig;
        this.tokenService = tokenService;
    }

    public void initiateLogin() {
        final String authUrl = String.format(
                "https://accounts.spotify.com/authorize?response_type=token&client_id=%s&redirect_uri=%s&scope=%s",
                spotifyConfig.getClientId(), spotifyConfig.getRedirectUri(), spotifyConfig.getScope()
        );

        try {
            Desktop.getDesktop().browse(new URI(authUrl));
        }
        catch (URISyntaxException ex) {
            throw new RuntimeException("input", ex);
        }
        catch (IOException ex) {
            throw new RuntimeException("ahhh", ex);
        }
        finally {
            // a
        }
//        catch (Exception ex) {
//            throw new RuntimeException("Failed to open browser for login", ex);
//        }
    }

    public void handleCallback(String accessToken, int expiresInSeconds) {
        tokenService.storeToken(accessToken, expiresInSeconds);
    }
}