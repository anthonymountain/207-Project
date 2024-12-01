package data_access;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import entity.Artist;
import use_case.rec_artist.RecArtistUserDataAccessInterface;

/**
 * In-memory implementation of the DAO for storing artist data. This implementation does
 * NOT persist data between runs of the program.
 */
public class InMemoryArtistDataAccessObject implements RecArtistUserDataAccessInterface {

    private final ArrayList<Artist> recommended = new ArrayList<Artist>();
    private Artist topArtist = new Artist();

    @Override
    public void recommendArtist(Artist artist) {
        this.topArtist = artist;
    }
}
