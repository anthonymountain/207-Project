package services;

/**
 * Service for handling Spotify authentication.
 * 
 * @null
 */
public class SpotifyAuthService {

    /**
     * Generates the Spotify authorization URL for user login.
     *
     * @return The authorization URL.
     */
    public String getAuthUrl() {
        String authurl = "https://accounts.spotify.com/en/authorize?client_id=3528cb11e8884baba8cdadeb30563f2e&redirect_uri=http:%2F%2Flocalhost:3000%2Fcallback%2F&scope=playlist-modify-public user-top-read user-read-email user-read-private &response_type=token&show_dialog=true";
        return authurl;
    }
}
