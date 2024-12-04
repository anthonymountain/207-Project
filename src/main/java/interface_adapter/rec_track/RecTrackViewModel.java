package interface_adapter.rec_track;

import interface_adapter.ViewModel;

/**
 * The view model for a recommended song.
 */
public class RecTrackViewModel extends ViewModel<RecTrackState> {

    public RecTrackViewModel() {
        super("song recommended");
        setState(new RecTrackState());
    }
}
