package use_case.rec_genre;

import java.util.ArrayList;

/**
 * The Input Data for the Recommend Genre Use Case.
 */
public class RecGenreInputData {

    private final ArrayList<String> genres;

    public RecGenreInputData(ArrayList<String> genres) {
        this.genres = genres;
    }

    public ArrayList<String> getGenres() {
        return this.genres;
    }
}

