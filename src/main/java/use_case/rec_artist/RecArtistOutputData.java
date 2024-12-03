package use_case.rec_artist;

import entity.Artist;

/**
 * Output Data for the RecArtist Use Case.
 */
public class RecArtistOutputData {

    private final Artist artist;
    private final boolean useCaseFailed;

    public RecArtistOutputData(Artist artist, boolean useCaseFailed) {
        this.artist = artist;
        this.useCaseFailed = useCaseFailed;
    }

    public String getName() {
        return artist.getName();
    }

    public boolean isUseCaseFailed() {
        return useCaseFailed;
    }

    public Artist getArtist() {
        return this.artist;
    }
}
