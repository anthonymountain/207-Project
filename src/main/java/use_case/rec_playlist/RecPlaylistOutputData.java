package use_case.rec_playlist;

/**
 * Output Data for the RecPlaylist Use Case.
 */
public class RecPlaylistOutputData {

    private final String name;
    private final boolean useCaseFailed;

    public RecPlaylistOutputData(String name, boolean useCaseFailed) {
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
