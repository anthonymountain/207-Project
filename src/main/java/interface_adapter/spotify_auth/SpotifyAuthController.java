package interface_adapter.spotify_auth;

import entity.*;
import org.json.JSONArray;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import services.PlaylistService;
import services.RecommendationService;
import services.TokenService;

import java.util.ArrayList;

@RestController
@RequestMapping("/api")
public class SpotifyAuthController {

    private final RecommendationService recommendationService;
    private final PlaylistService playlistService;

    public SpotifyAuthController(TokenService tokenService) {
        this.recommendationService = new RecommendationService(tokenService);
        this.playlistService = new PlaylistService(tokenService);
    }

    @GetMapping("/recommendation")
    public Track getRandomRecommendation(
            @RequestParam(required = false) String seedArtist,
            @RequestParam(required = false) String seedGenre,
            @RequestParam(required = false) String seedTrack
    ) {
        return new Track("", "", 0, null, null);
    }

    @GetMapping("/artists/top")
    public ArrayList<Artist> getUserTopArtists(
            @RequestParam(required = false) String type,
            @RequestParam(required = false) int limit
    ) {
        return recommendationService.getUserTopArtists(limit);
    }

    @GetMapping("/tracks/top")
    public ArrayList<Track> getUserTopTracks(
            @RequestParam String type,
            @RequestParam int limit
    ) {
        return recommendationService.getUserTopTracks(limit);
    }

    @PostMapping("/playlist/recommendations")
    public String createPlaylistForRecommendations(
            @RequestBody JSONArray recommendations,
            @RequestParam String userId
    ) {
        return playlistService.createPlaylistForRecommendations(userId, recommendations);
    }

    @PostMapping("/playlist/artist")
    public String createArtistPlaylist(
            @RequestParam String userId,
            @RequestParam String artistId,
            @RequestBody JSONArray topTracks
    ) {
        return playlistService.createArtistPlaylist(userId, artistId, topTracks);
    }
}
