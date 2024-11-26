package use_case.rec_playlist;

import data_access.InMemoryPlaylistDataAccessObject;
import interface_adapter.rec_playlist.RecPlaylistPresenter;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class RecPlaylistInteractorTest {

    @Test
    public void successPlaylistRecommendedTest(){
        // Nothin just yet
        // Just making sure that we get a playlist from our API calls
        RecPlaylistInputData recPlaylistInputData = new RecPlaylistInputData();
        RecPlaylistDataAccessInterface recPlaylistRepository = new InMemoryPlaylistDataAccessObject();

        // Presenter to see if our use case handles as expected
        RecPlaylistOutputBoundary recPlaylistPresenter = new RecPlaylistOutputBoundary() {
            @Override
            public void prepareSuccessView(RecPlaylistOutputData outputData) {
                assertEquals(recPlaylistRepository.getRecommendations(), outputData.getPlaylist());
            }

            @Override
            public void prepareFailView(String errorMessage) {
                fail("Use case failure is unexpected");
            }
        };

        RecPlaylistInputBoundary recPlaylistInteractor = new RecPlaylistInteractor(recPlaylistRepository,
                recPlaylistPresenter);
        recPlaylistInteractor.execute(recPlaylistInputData);
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
