package services;

import interface_adapter.spotify_auth.SpotifyConfig;

/**
 * Service for handling Spotify authentication.
 * 
 * @null
 */
public class SpotifyAuthService {

    private final SpotifyConfig spotifyConfig;

    public SpotifyAuthService() {
        this.spotifyConfig = new SpotifyConfig();
        }

    /**
     * Generates the Spotify authorization URL for user login.
     *
     * @return The authorization URL.
     */
    public String getAuthUrl() {
        return String.format(
            "https://accounts.spotify.com/authorize?response_type=token&client_id=%s&redirect_uri=%s&scope=%s",
            spotifyConfig.getClientId(),
            spotifyConfig.getRedirectUri(),
            spotifyConfig.getScope()
        );
    }
}
