package interface_adapter.rec_album;

import interface_adapter.ViewModel;

/**
 * The view model for a recommended album.
 */
public class RecAlbumViewModel extends ViewModel<RecAlbumState> {

    public RecAlbumViewModel() {
        super("album recommended");
        setState(new RecAlbumState());
    }
}
