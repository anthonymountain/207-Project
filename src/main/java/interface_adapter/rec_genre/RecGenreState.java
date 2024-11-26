package interface_adapter.rec_genre;

/**
 * This state is for when a song is recommended.
 */
public class RecGenreState {
    private String type;
    private String description;

    // No uses yet
    public RecGenreState(RecGenreState copy) {
        this.type = copy.type;
        this.description = copy.description;
    }

    public RecGenreState() {

    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getList() {
        return "genre_list";
        // TODO Implement this
    }
}