package interface_adapter.rec_genre;

/**
 * The view model for a recommended genre.
 */
public class RecGenreViewModel {
    private String genre;
    private String errorMessage;

    public RecGenreViewModel(String genreName) {
        this.genre = genreName;
    }

    public String getGenreName() {
        return genre;
    }

    public void setGenreName(String genreName) {
        this.genre = genreName;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
