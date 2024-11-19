package use_case.rec_song;

/**
 * The Input Data for the RecSong Use Case.
 */
public class RecSongInputData {

    private final String name;
    private final String artist;
    private final String genre;

    public RecSongInputData(String name, String artist, String genre) {
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
