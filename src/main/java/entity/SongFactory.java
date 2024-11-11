package entity;

/**
 * Factory for creating songs.
 */
public interface SongFactory {
    /**
     * Creates a new Song.
     * @param name the name of the new song
     * @param artist the artist of the new song
     * @param genre the genre of the new song
     * @return the new song
     */
    Song create(String name, String artist, String genre);

}
