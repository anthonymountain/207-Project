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
     * @param genreDescription the description of the recommended genre
     */
    public void setRecommendedGenre(String genreType, String genreDescription) {
        final RecGenreState state = getState();
        state.setType(genreType);
        state.setDescription(genreDescription);
        notifyStateChanged();
    }

//    /**
//     * Updates the state to reflect an error.
//     *
//     * @param errorMessage the error message to set
//     */
//    public void setErrorState(String errorMessage) {
//        RecGenreState state = getState();
//        state.setErrorMessage(errorMessage);
//        notifyStateChanged();
//    }
}
