package entity;

import java.util.ArrayList;

/**
 * Factory for creating artists.
 */
public interface ArtistFactory {
    /**
     * Creates a new Song.
     * @param name the name of the new artist.
     * @param songs the artist's songs.
     * @return the new song
     */
    Artist create(String name, ArrayList<Song> songs);

}
