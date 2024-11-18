package entity;

import java.util.ArrayList;

/**
 * Factory for creating Album objects.
 */
public class CommonAlbumFactory implements AlbumFactory {
    @Override
    public Album create(String name, int popularity, ArrayList<Artist> artists) {
        return new CommonAlbum(name, popularity, artists);
    }
}
