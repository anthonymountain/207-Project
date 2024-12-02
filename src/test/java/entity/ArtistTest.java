package java.entity;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ArtistTest {

    @Test
    void testArtistCreation() {
        ArrayList<Track> tracks = new ArrayList<>(Arrays.asList(new Track("Track1"), new Track("Track2")));
        ArrayList<Genre> genres = new ArrayList<>(Arrays.asList(new Genre("Rock"), new Genre("Pop")));

        Artist artist = new Artist("123", "ArtistName", tracks, genres);

        assertEquals("123", artist.getId());
        assertEquals("ArtistName", artist.getName());
        assertEquals(2, artist.getTracks().size());
        assertEquals("Rock", artist.getGenres().get(0).getName());
    }

    @Test
    void testEmptyArtist() {
        ArrayList<Track> tracks = new ArrayList<>();
        ArrayList<Genre> genres = new ArrayList<>();

        Artist artist = new Artist("123", "EmptyArtist", tracks, genres);

        assertEquals("123", artist.getId());
        assertEquals("EmptyArtist", artist.getName());
        assertTrue(artist.getTracks().isEmpty());
        assertTrue(artist.getGenres().isEmpty());
    }
}
