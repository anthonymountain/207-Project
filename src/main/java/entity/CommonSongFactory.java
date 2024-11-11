package entity;

/**
 * Factory for creating CommonSong objects.
 */
public class CommonSongFactory implements SongFactory {

    @Override
    public Song create(String name, String artist, String genre) {
        return new CommonSong(name, artist, genre);
    }
}
