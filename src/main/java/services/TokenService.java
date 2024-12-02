package services;

import java.time.Instant;

import org.springframework.stereotype.Service;

import entity.AccessToken;

@Service
public class TokenService {

    private AccessToken accessToken;

    /**
     * Constructor for TokenService.
     */

    public TokenService() {
        this.accessToken = null;
    }

    /**
     * Store a new access token.
     * @param token The access token string.
     * @param expiresInSeconds Expiration time in seconds.
     */
    public void storeToken(String token, int expiresInSeconds) {
        final Instant expiry = Instant.now().plusSeconds(expiresInSeconds);
        this.accessToken = new AccessToken(token, expiry);
    }

    /**
     * Get the stored access token.
     * @return The stored access token.
     * @throws IllegalStateException if the token is expired or not available.
     */
    public String getToken() {
        if (accessToken == null || accessToken.isExpired()) {
            throw new IllegalStateException("No valid access token available. Please log in.");
        }
        return accessToken.getToken();
    }

    /**
     * Check if a valid token is available.
     * @return True if a valid token exists, false otherwise.
     */
    public boolean hasValidToken() {
        return accessToken != null && !accessToken.isExpired();
    }
}
