package interface_adapter.rec_song;

/**
 * This state is for when a song is recommended.
 */
public class RecSongState {
    private String name;
    private String artist;
    private String genre;

    // No uses yet
    public RecSongState(RecSongState copy) {
        name = copy.name;
        artist = copy.artist;
        genre = copy.genre;
    }

    public RecSongState() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getList() {
        return "playlist_name";
        // TODO Implement this
    }
}
