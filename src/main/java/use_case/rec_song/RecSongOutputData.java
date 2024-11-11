package use_case.rec_song;

/**
 * Output Data for the Logout Use Case.
 */
public class RecSongOutputData {

    private final String name;
    private final boolean useCaseFailed;

    public RecSongOutputData(String name, boolean useCaseFailed) {
        this.name = name;
        this.useCaseFailed = useCaseFailed;
    }

    public String getName() {
        return name;
    }

    public boolean isUseCaseFailed() {
        return useCaseFailed;
    }
}
