package data_access;

import entity.Playlist;
import interface_adapter.spotify_auth.SpotifyApiClient;
import use_case.rec_playlist.RecPlaylistDataAccessInterface;

/**
 * This DAO is going to get data for playlists.
 */
public class InMemoryPlaylistDataAccessObject implements RecPlaylistDataAccessInterface {

    private Playlist playlist;

    @Override
    public Playlist getRecommendations() {
//        final SpotifyApiClient spotifyApiClient = new SpotifyApiClient();
//        // Make API call to get recommendation
//        final String recommendationsJSON = spotifyApiClient.getRecommendations("", "", "");
//
//        // Reformat the recommendations from JSON format into tracks that we can put in a playlist.


        final Playlist playlist1 = new Playlist();
        this.playlist = playlist1;
        // He has a point that the local variable playlist1 is useless.
        // Returns a playlist
        // this.playlist = playlist;
        return null;
    }
}
