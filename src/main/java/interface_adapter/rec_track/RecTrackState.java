package interface_adapter.rec_track;

/**
 * This state is for when an track is recommended.
 */
public class RecTrackState {
    private String name;

    // No uses yet
    public RecTrackState(RecTrackState copy) {
        name = copy.name;
    }

    public RecTrackState() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
