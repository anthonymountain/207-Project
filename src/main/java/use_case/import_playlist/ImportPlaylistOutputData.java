package use_case.import_playlist;

/**
 * Output Data for the Logout Use Case.
 */
public class ImportPlaylistOutputData {

    private final String name;
    private final boolean useCaseFailed;

    public ImportPlaylistOutputData(String name, boolean useCaseFailed) {
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
