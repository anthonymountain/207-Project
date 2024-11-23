import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;


public class APITutorial {

    public static void main(String[] args) {

        SpotifyAuthorization spotifyAuth = new SpotifyAuthorization();
        final String gsonrequest = spotifyAuth.buildSpotifyAuthUrl(SpotifyAuthorization.CLIENT_ID, SpotifyAuthorization.REDIRECT_URI, SpotifyAuthorization.STATE_KEY, SpotifyAuthorization.SCOPE);
        
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create("https://api.spotify.com/v1/me"))
            .header("Authorization", "Bearer " + accessToken)
            .POST(HttpRequest.BodyPublishers.ofString(jsonrequest))
            .build();

    }

}
