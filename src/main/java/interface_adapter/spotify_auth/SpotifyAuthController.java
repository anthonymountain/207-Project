package interface_adapter.spotify_auth;

import org.json.simple.JSONArray;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import services.PlaylistService;
import services.RecommendationService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class SpotifyAuthController {

    private final RecommendationService recommendationService;
    private final PlaylistService playlistService;

    public SpotifyAuthController(RecommendationService recommendationService, PlaylistService playlistService) {
        this.recommendationService = recommendationService;
        this.playlistService = playlistService;
    }

    @GetMapping("/recommendation")
    public String getRandomRecommendation(
            @RequestHeader("Authorization") String accessToken,
            @RequestParam(required = false) String seedArtist,
            @RequestParam(required = false) String seedGenre,
            @RequestParam(required = false) String seedTrack
    ) {
        return recommendationService.getRandomRecommendation(accessToken, seedArtist, seedGenre, seedTrack);
    }

    @PostMapping("/playlist/recommendations")
    public String createPlaylistForRecommendations(
            @RequestHeader("Authorization") String accessToken,
            @RequestParam String userId,
            @RequestBody JSONArray recommendedTracks
    ) {
        return playlistService.createPlaylistForRecommendations(accessToken, userId, recommendedTracks);
    }

    @PostMapping("/playlist/artist")
    public String createArtistPlaylist(
            @RequestHeader("Authorization") String accessToken,
            @RequestParam String userId,
            @RequestParam String artistId,
            @RequestBody JSONArray topTracks
    ) {
        return playlistService.createArtistPlaylist(accessToken, userId, artistId, topTracks);
    }
}