package interface_adapter.rec_song;

import interface_adapter.ViewModel;
import interface_adapter.change_password.LoggedInState;

/**
 * The view model for a recommended song.
 */
public class RecSongViewModel extends ViewModel<RecSongState> {

    public RecSongViewModel() {
        super("song recommended");
        setState(new RecSongState());
    }
}
