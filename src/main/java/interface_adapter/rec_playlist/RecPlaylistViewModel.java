package interface_adapter.rec_playlist;

import interface_adapter.ViewModel;

/**
 * The view model for a recommended song.
 */
public class RecPlaylistViewModel extends ViewModel<RecPlaylistState> {

    public RecPlaylistViewModel() {
        super("Recommended Playlist");
        setState(new RecPlaylistState());
    }
}
