package interface_adapter.rec_playlist;

/**
 * This state is for when a playlist is recommended.
 */
public class RecPlaylistState {
    private String name;
    private String artist;
    private String genre;

    // No uses yet
    public RecPlaylistState(RecPlaylistState copy) {
        name = copy.name;
        artist = copy.artist;
        genre = copy.genre;
    }

    public RecPlaylistState() {

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
    }
}
