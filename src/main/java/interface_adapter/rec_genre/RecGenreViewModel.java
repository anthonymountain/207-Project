package interface_adapter.rec_genre;

/**
 * The view model for a recommended genre.
 */
public class RecGenreViewModel {
    private final String genre;

    public RecGenreViewModel(String genre) {
        this.genre = genre;
    }

    public String getArtistName() {
        return this.genre;
    }
}
