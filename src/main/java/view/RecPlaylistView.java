package view;

import interface_adapter.rec_playlist.RecPlaylistController;
import interface_adapter.rec_playlist.RecPlaylistViewModel;

/**
 * This View pops up when a playlist is recommended.
 */
public class RecPlaylistView {

    private RecPlaylistController recPlaylistController;
    private final String viewName = "playlist recommended";
    private final RecPlaylistViewModel recPlaylistViewModel;

    public RecPlaylistView(RecPlaylistViewModel recPlaylistViewModel) {
        this.recPlaylistViewModel = recPlaylistViewModel;
    }

    public String getViewName() {
        return viewName;
    }

    public void setRecSongController(RecPlaylistController recPlaylistController) {
        this.recPlaylistController = recPlaylistController;
    }
}
