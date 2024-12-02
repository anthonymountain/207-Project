package entity;

import java.time.Instant;

public class AccessToken {
    private final String token;
    private final Instant expiry;

    public AccessToken(String token, Instant expiry) {
        this.token = token;
        this.expiry = expiry;
    }

    public String getToken() {
        return token;
    }

    public boolean isExpired() {
        return Instant.now().isAfter(expiry);
    }

    @Override
    public String toString() {
        return "AccessToken{"
                + "token='" + token + '\''
                + ", expiry=" + expiry
                + '}';
    }
}
