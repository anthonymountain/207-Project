package entity;

/**
 * The representation of a song in our program.
 */
public interface Song {

    /**
     * Returns the name of the song.
     * @return the name of the song.
     */
    String getName();

    /**
     * Returns the song artist.
     * @return the song artist.
     */
    String getArtist();

    /**
     * Returns the song genre.
     * @return the song genre.
     */
    String getGenre();

}
