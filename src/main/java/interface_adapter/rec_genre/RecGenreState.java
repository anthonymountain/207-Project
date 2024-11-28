package interface_adapter.rec_genre;

import java.util.ArrayList;

/**
 * This state is for when a song is recommended.
 */
public class RecGenreState {
    private ArrayList<String> genres;

    // No uses yet
    public RecGenreState(RecGenreState copy) {
        this.genres = copy.genres;
    }

    public RecGenreState() {

    }

    public void setGenres(ArrayList<String> genres) {
        this.genres = genres;
    }

    public String getList() {
        return "genre_list";
        // TODO Implement this
    }
}
