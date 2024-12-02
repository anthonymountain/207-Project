package interface_adapter.spotify_auth;

import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import entity.Artist;
import entity.Track;
import services.ArtistService;
import services.TokenService;

/**
 * This is a JavaDoc comment. The Spotify API Client helps us make API calls.
 */
@Component
public class SpotifyApiClient {

    public static final String AUTHORIZATION = "Authorization";
    public static final String BEARER = "Bearer ";
    private final HttpClient httpClient;
    private final TokenService tokenService;
    private final ArtistService artistService;

    public SpotifyApiClient(TokenService tokenService) {
        this.artistService = new ArtistService();
        this.httpClient = HttpClient.newHttpClient();
        this.tokenService = tokenService;
    }

    /**
     * Get recommendations based on seed artists, genres, or tracks.
     *
     * @param seedArtists Comma-separated artist IDs.
     * @param seedGenres  Comma-separated genres.
     * @param seedTracks  Comma-separated track IDs.
     * @return A JSON string containing Spotify's recommendations.
     * @throws RuntimeException to catch stuff.
     */
    public String getRecommendations(String seedArtists, String seedGenres, String seedTracks) {
        try {
            final String accessToken = tokenService.getToken();

            final URI uri = new URI(String.format(
                    "https://api.spotify.com/v1/recommendations?seed_artists=%s&seed_genres=%s&seed_tracks=%s",
                    seedArtists, seedGenres, seedTracks));

            final HttpRequest request = HttpRequest.newBuilder()
                    .uri(uri)
                    .header(AUTHORIZATION, BEARER + accessToken)
                    .GET()
                    .build();

            final HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } 
        catch (IOException | InterruptedException | URISyntaxException ex) {
            throw new RuntimeException("Failed to get recommendationsx", ex);
        }
    }

    /**
     * Create a new playlist for a given user.
     *
     * @param userId       Spotify user ID.
     * @param playlistName Name of the new playlist.
     * @return A JSON string containing the newly created playlist's details.
     * @throws RuntimeException for fun.
     */
    public String createPlaylist(String userId, String playlistName) {
        try {
            final String accessToken = tokenService.getToken();

            final URI uri = new URI(String.format("https://api.spotify.com/v1/users/%s/playlists", userId));

            final JSONObject payload = new JSONObject();
            payload.put("name", playlistName);
            payload.put("description", "Generated by the app");
            payload.put("public", false);

            final HttpRequest request = HttpRequest.newBuilder()
                    .uri(uri)
                    .header(AUTHORIZATION, BEARER + accessToken)
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(payload.toString()))
                    .build();

            final HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        }
        catch (IOException | InterruptedException | URISyntaxException ex) {
            throw new RuntimeException("Failed to create playlists", ex);
        }
    }

    /**
     * Add tracks to a playlist.
     *
     * @param playlistId Spotify playlist ID.
     * @param trackUris  JSON array of track URIs to add to the playlist.
     * @throws RuntimeException for funsies.
     */
    public void addTracksToPlaylist(String playlistId, JSONArray trackUris) {
        try {
            final String accessToken = tokenService.getToken();

            final URI uri = new URI(String.format("https://api.spotify.com/v1/playlists/%s/tracks", playlistId));

            final JSONObject payload = new JSONObject();
            payload.put("uris", trackUris);

            final HttpRequest request = HttpRequest.newBuilder()
                    .uri(uri)
                    .header(AUTHORIZATION, BEARER + accessToken)
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(payload.toString()))
                    .build();

            httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        }
        catch (IOException | InterruptedException | URISyntaxException ex) {
            throw new RuntimeException("Failed to add tracks", ex);
        }
    }

    /**
     * Get the current user's profile.
     *
     * @return A JSON string containing the user's profile details.
     * @throws RuntimeException again.
     */
    public String getCurrentUserProfile() {
        try {
            final String accessToken = tokenService.getToken();

            final URI uri = new URI("https://api.spotify.com/v1/me");

            final HttpRequest request = HttpRequest.newBuilder()
                    .uri(uri)
                    .header(AUTHORIZATION, BEARER + accessToken)
                    .GET()
                    .build();

            final HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        }
        catch (IOException | InterruptedException | URISyntaxException ex) {
            throw new RuntimeException("Failed to get current user profile", ex);
        }
    }

    /**
     * Get the user's top items (artists or tracks).
     *
     * @param type The type of items to fetch: either "artists" or "tracks".
     * @param timeRange The time range for calculating affinities: "short_term", "medium_term", or "long_term".
     * @param limit The maximum number of items to return.
     * @return A list of Artist or Track objects.
     * @throws RuntimeException if the request fails.
     */
    public ArrayList<Object> getUserTopItems(String type, String timeRange, int limit) {
        try {
            final String accessToken = tokenService.getToken();

            // Prepare the URL
            final URI uri = new URI(String.format(
                    "https://api.spotify.com/v1/me/top/%s?time_range=%s&limit=%d",
                    type, timeRange, limit));

            // Make the API request
            final HttpRequest request = HttpRequest.newBuilder()
                    .uri(uri)
                    .header(AUTHORIZATION, BEARER + accessToken)
                    .GET()
                    .build();

            final HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            final JSONObject jsonResponse = new JSONObject(response.body());

            // Parse the response based on the type
            final ArrayList<Object> items = new ArrayList<>();
            if ("artists".equals(type)) {
                final JSONArray artistsJsonArray = jsonResponse.getJSONArray("items");
                for (int i = 0; i < artistsJsonArray.length(); i++) {
                    final JSONObject artistJson = artistsJsonArray.getJSONObject(i);
                    final Artist artist = artistService.parseArtistFromJson(artistJson);
                    items.add(artist);
                }
            }
            //            else if ("tracks".equals(type)) {
            //                final JSONArray tracksJsonArray = jsonResponse.getJSONArray("items");
            //                for (int i = 0; i < tracksJsonArray.length(); i++) {
            //                    final JSONObject trackJson = tracksJsonArray.getJSONObject(i);
            //                    final Track track = new Track(trackJson);
            //                    items.add(track);
            //                }
            return items;
        }
        catch (IOException ex) {
            throw new RuntimeException("Failed to fetch top items", ex);
        }
        catch (InterruptedException ex) {
            throw new RuntimeException("Request interrupted", ex);
        }
        catch (URISyntaxException ex) {
            throw new RuntimeException("Invalid URI", ex);
        }
    }

    /**
     * Get an artist's top tracks.
     *
     * @param artistId Artist ID.
     * @param market   Market (e.g., "US").
     * @return A JSON string containing the artist's top tracks.
     * @throws RuntimeException yaddi yadda.
     */
    public String getArtistTopTracks(String artistId, String market) {
        try {
            final String accessToken = tokenService.getToken();

            final URI uri = new URI(
                    String.format("https://api.spotify.com/v1/artists/%s/top-tracks?market=%s", artistId, market));

            final HttpRequest request = HttpRequest.newBuilder()
                    .uri(uri)
                    .header(AUTHORIZATION, BEARER + accessToken)
                    .GET()
                    .build();

            final HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        }
        catch (IOException | InterruptedException | URISyntaxException ex) {
            throw new RuntimeException("Failed to get artist top tracks", ex);
        }
    }

    /**
     * Get the user's top items so we have a seed for getRecommendations().
     *
     * @param artistId Artist ID.
     * @param market   Market (e.g., "US").
     * @return A JSON string containing the artist's top tracks.
     * @throws RuntimeException yaddi yadda.
     */
    public String getUserTopItems(String artistId, String market) {
        try {
            final String accessToken = tokenService.getToken();

            final URI uri = new URI(
                    String.format("https://api.spotify.com/v1/me/top/tracks"));
            // prob not this.

            final HttpRequest request = HttpRequest.newBuilder()
                    .uri(uri)
                    .header(AUTHORIZATION, BEARER + accessToken)
                    .GET()
                    .build();

            final HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        }
        catch (IOException | InterruptedException | URISyntaxException ex) {
            throw new RuntimeException("Failed to get user top items", ex);
        }
    }
}
