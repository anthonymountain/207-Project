package use_case.rec_genre;

/**
 * The Input Data for the Recommend Genre Use Case.
 */
public class RecGenreInputData {

    private final String type;
    private final String description;

    public RecGenreInputData(String type, String description) {
        this.type = type;
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }
}
