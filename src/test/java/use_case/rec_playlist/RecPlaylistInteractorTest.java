package use_case.rec_playlist;

import org.junit.Test;

public class RecPlaylistInteractorTest {

    @Test
    public void successPlaylistRecommendedTest(){
        // Nothin just yet
        // Just making sure that we get a playlist from our API calls
    }

    @Test
    public void playlistIsUniqueTest(){
        // Nohtin yet
        // Make sure that when we generate two playlists, the playlists are different.
    }

    @Test
    public void coolTest() {
        // Some other functionality that we might want.
    }

    /*
     * The big test I think that we need to do are:
     * 1. we are able to actually get a playlist from our DAO calls.
     * 2. the playlist that we return is equal to the playlist we need (how to ensure?)
     * 3. Actually, it's probably better if we do a test where we make two separate calls and ensure the playlists are
     *    not equal
     * 4.
     */
}
