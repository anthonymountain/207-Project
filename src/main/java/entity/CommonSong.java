package entity;

/**
 * A simple implementation of the User interface.
 */
public class CommonSong implements Song {

    private final String name;
    private final String artist;
    private final String genre;

    public CommonSong(String name, String artist, String genre) {
        this.name = name;
        this.artist = artist;
        this.genre = genre;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getArtist() {
        return artist;
    }

    @Override
    public String getGenre() {
        return genre;
    }

}
