package interface_adapter.spotifyauth;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class SpotifyApiClient {

    private final WebClient webClient;

    public SpotifyApiClient(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://api.spotify.com/v1").build();
    }

    public String getUserProfile(String accessToken) {
        return webClient.get()
                .uri("/me")
                .header("Authorization", "Bearer " + accessToken)
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
}