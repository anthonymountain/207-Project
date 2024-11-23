package interface_adapter.rec_artist;

import interface_adapter.ViewModel;

/**
 * The view model for a recommended artist.
 */
public class RecArtistViewModel extends ViewModel<RecArtistState> {

    public RecArtistViewModel() {
        super("artist recommended");
        setState(new RecArtistState());
    }
}
