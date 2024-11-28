package interface_adapter.rec_genre;

import java.util.List;

import interface_adapter.ViewModel;

/**
 * The view model for a recommended genre.
 */
public class RecGenreViewModel extends ViewModel<RecGenreState> {

    public RecGenreViewModel() {
        super("genre recommended");
        setState(new RecGenreState());
    }

    /**
     * Method to update the state with genre data.
     * 
     * @param genres List of genres to be set in the state.
     */
    public void updateGenres(List<String> genres) {
        final RecGenreState updatedState = new RecGenreState(genres);
        setState(updatedState);
    }
}
