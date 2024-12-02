package use_case.import_playlist;

public class ImportPlaylistInputData {
    private final String spotifyUserId;
    private final String playlistName;
    private final String[] trackIds;

    public ImportPlaylistInputData(String spotifyUserId, String playlistName, String[] trackIds) {
        this.spotifyUserId = spotifyUserId;
        this.playlistName = playlistName;
        this.trackIds = trackIds;
    }

    public String getSpotifyUserId() {
        return spotifyUserId;
    }

    public String getPlaylistName() {
        return playlistName;
    }

    public String[] getTrackIds() {
        return trackIds;
    }
}
