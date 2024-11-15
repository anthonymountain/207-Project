package use_case.import_playlist;

/**
 * The Input Data for the Logout Use Case.
 */
public class ImportPlaylistInputData {

    private final String name;
    private final String artist;
    private final String genre;

    public ImportPlaylistInputData(String name, String artist, String genre) {
        this.name = name;
        this.artist = artist;
        this.genre = genre;
    }

    public String getName() {
        return name;
    }

    public String getArtist() {
        return artist;
    }

    public String getGenre() {
        return genre;
    }
}
