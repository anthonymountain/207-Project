package use_case.rec_genre;

/**
 * The Input Data for the Recommend Genre Use Case.
 */
public class RecGenreInputData {

    private String type;
    private String description;

    public RecGenreInputData() {
    }

//    public RecGenreInputData(String type, String description) {
//        this.type = type;
//        this.description = description;
//    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }
}
