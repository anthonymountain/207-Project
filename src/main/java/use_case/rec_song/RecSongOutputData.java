package use_case.rec_song;

/**
 * Output Data for the Logout Use Case.
 */
public class RecSongOutputData {

    private final String username;
    private final boolean useCaseFailed;

    public RecSongOutputData(String username, boolean useCaseFailed) {
        this.username = username;
        this.useCaseFailed = useCaseFailed;
    }

    public String getUsername() {
        return username;
    }

    public boolean isUseCaseFailed() {
        return useCaseFailed;
    }
}
