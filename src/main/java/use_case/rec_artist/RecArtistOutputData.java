package use_case.rec_artist;

/**
 * Output Data for the RecArtist Use Case.
 */
public class RecArtistOutputData {

    private final String name;
    private final boolean useCaseFailed;

    public RecArtistOutputData(String name, boolean useCaseFailed) {
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
