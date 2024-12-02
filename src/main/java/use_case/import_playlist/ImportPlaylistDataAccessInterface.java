package use_case.import_playlist;

public interface ImportPlaylistDataAccessInterface {
    void savePlaylistData(String playlistId, String[] trackIds);
}
