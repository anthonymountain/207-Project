package entity;

import java.util.ArrayList;

/**
 * This class is a factory for creating common artists.
 */
public class CommonArtistFactory implements ArtistFactory{
    @Override
    public Artist create(String name, ArrayList<Track> tracks) {
        return new CommonArtist(name, tracks);
    }
}
