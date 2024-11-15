package use_case.import_playlist;

import java.util.List;

import entity.Song;

/**
 * DAO for the Import Playlist Use Case.
 */
public interface ImportPlaylistUserDataAccessInterface {

    /**
     * Imports a playlist for the user.
     * @param playlist the playlist.
     */
    void importPlaylist(List<Song> playlist);
    // add duplicate check
    // add previous recommended song retrieval (from list)
    // add recommendation saving (to list)
}
