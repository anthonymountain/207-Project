package entity;

import java.util.ArrayList;

/**
 * Factory for creating CommonArtist objects.
 */
public class CommonArtistFactory implements ArtistFactory {

    @Override
    public Artist create(String name, ArrayList<Song> songs) {
        return new CommonArtist(name, songs);
    }
}
