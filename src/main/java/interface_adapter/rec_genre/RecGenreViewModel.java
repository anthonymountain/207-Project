package interface_adapter.rec_genre;

import interface_adapter.ViewModel;

/**
 * The ViewModel for a recommended genre.
 */
public class RecGenreViewModel extends ViewModel<RecGenreState> {

    public RecGenreViewModel() {
        super("genre recommended");
        setState(new RecGenreState());
    }

    /**
     * Updates the recommended genre in the state.
     *
     * @param genreType the type of the recommended genre
     */
    public void setRecommendedType(String genreType) {
        final RecGenreState state = getState();
        state.setType(genreType);
        notifyStateChanged();
    }

    /**
     * Updates the recommended genre in the state.
     *
     * @param genreDescription the description of the recommended genre
     */
    public void setRecommendedDescription(String genreDescription) {
        final RecGenreState state = getState();
        state.setDescription(genreDescription);
        notifyStateChanged();
    }

    /**
     * Sets the error message.
     *
     * @param errorMessage sets the error message
     */
    public void setError(String errorMessage) {
        final RecGenreState state = getState();
        state.setError(errorMessage);
        notifyStateChanged();
    }

}
