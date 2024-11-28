package interface_adapter.rec_genre;

import interface_adapter.ViewModel;

/**
 * The view model for a recommended song.
 */
public class RecGenreViewModel extends ViewModel<RecGenreState> {

    public RecGenreViewModel() {
        super("genre recommended");
        setState(new RecGenreState());
    }

    
}
