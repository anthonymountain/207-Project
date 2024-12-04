package interface_adapter.spotify_auth;

import entity.Album;
import entity.Artist;
import entity.Track;
import org.json.JSONArray;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import services.AlbumService;
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
        return recommendationService.getRandomRecommendation(seedArtist, seedGenre, seedTrack);
    }

    @GetMapping("/me/top/artists")
    public ArrayList<Artist> getUserTopArtists(
    ) {
        return recommendationService.getUserTopArtists();
    }

    @GetMapping("/me/top/tracks")
    public ArrayList<Track> getUserTopTracks(
    ) {
        return recommendationService.getUserTopTracks();
    }

    @GetMapping("/artists/{id}/top-tracks")
    public ArrayList<Track> getArtistsTopTracks(
            @RequestParam String artistId,
            @RequestParam (required = false) String market
    ) {
        return recommendationService.getArtistsTopTracks(artistId, market);
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

    @GetMapping("/browse/new-releases")
    public ArrayList<Album> getNewReleases() {
        return recommendationService.getNewReleases();
    }
}
