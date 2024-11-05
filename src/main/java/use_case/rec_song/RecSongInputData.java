package use_case.rec_song;

/**
 * The Input Data for the Logout Use Case.
 */
public class RecSongInputData {

    private final String username;

    public RecSongInputData(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
