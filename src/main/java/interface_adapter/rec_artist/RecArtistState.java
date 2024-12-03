package interface_adapter.rec_artist;

/**
 * This state is for when an artist is recommended.
 */
public class RecArtistState {
    private String name;

    // No uses yet
    public RecArtistState(RecArtistState copy) {
        name = copy.name;
    }

    public RecArtistState() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
