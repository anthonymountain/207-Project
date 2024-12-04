package java_use_case.rec_artist;

import data_access.InMemoryArtistDataAccessObject;
import entity.Artist;
import entity.Track;
import interface_adapter.spotify_auth.SpotifyAuthController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import use_case.rec_artist.RecArtistInteractor;
import use_case.rec_artist.RecArtistOutputBoundary;
import use_case.rec_artist.RecArtistOutputData;
import use_case.rec_artist.*;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

class RecArtistInteractorTest {

    @Test
    void testExecuteWithValidArtists() {
        // Arrange
        SpotifyAuthControllerStub spotifyAuthControllerStub = new SpotifyAuthControllerStub();
        InMemoryArtistDataAccessObject dao = new InMemoryArtistDataAccessObject(spotifyAuthControllerStub);
        TestOutputBoundary outputBoundary = new TestOutputBoundary();

        RecArtistInteractor interactor = new RecArtistInteractor(dao, outputBoundary);

        // Act
        interactor.execute(null);

        // Assert
        Artist artist = dao.getArtist();
        Assertions.assertNotNull(artist);
        Assertions.assertEquals("Artist1", artist.getName());
        Assertions.assertTrue(outputBoundary.wasSuccessViewPrepared());
    }

    @Test
    void testExecuteWithNoArtists() {
        // Arrange
        SpotifyAuthControllerStub spotifyAuthControllerStub = new SpotifyAuthControllerStub();
        spotifyAuthControllerStub.setReturnEmptyList(true); // Simulate no artists case
        InMemoryArtistDataAccessObject dao = new InMemoryArtistDataAccessObject(spotifyAuthControllerStub);
        TestOutputBoundary outputBoundary = new TestOutputBoundary();

        RecArtistInteractor interactor = new RecArtistInteractor(dao, outputBoundary);

        // Act
        interactor.execute(null);

        // Assert
        Artist artist = dao.getArtist();
        Assertions.assertNotNull(artist);
        Assertions.assertEquals("Peewee", artist.getName());
        Assertions.assertTrue(outputBoundary.wasSuccessViewPrepared());
    }

    @Test
    public void successArtistRecommendedTest(){
        RecArtistInputData recArtistInputData = new RecArtistInputData();
        TestArtistDataAccessObject testArtistDataAccessObject = new TestArtistDataAccessObject(new SpotifyAuthControllerStub());

        // Presenter to see if our use case handles as expected
        RecArtistOutputBoundary recArtistPresenter = new RecArtistOutputBoundary() {
            @Override
            public void prepareSuccessView(RecArtistOutputData outputData) {
                assertEquals(testArtistDataAccessObject.getArtist(), outputData.getArtist());
                assertEquals(testArtistDataAccessObject.getArtist().getName(), outputData.getName());
                assertEquals(outputData.isUseCaseFailed(), false);

            }

            @Override
            public void prepareFailView(String errorMessage) {
                fail("Use case failure is unexpected");
            }
        };

        RecArtistInputBoundary recArtistInteractor = new RecArtistInteractor(testArtistDataAccessObject,
                recArtistPresenter);
        recArtistInteractor.execute(recArtistInputData);
    }
}

class TestArtistDataAccessObject implements RecArtistDataAccessInterface {
    private Artist artist;
    private SpotifyAuthControllerStub spotifyAuthController;

    public TestArtistDataAccessObject(SpotifyAuthControllerStub spotifyAuthController) {
        this.spotifyAuthController = spotifyAuthController;
    }

    @Override
    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    @Override
    public Artist getArtist() {
        return artist;
    }

    public ArrayList<Artist> getUserTopArtists() {
        return this.spotifyAuthController.getUserTopArtists();
    }

    @Override
    public ArrayList<Track> getArtistsTopTracks() {
        return this.spotifyAuthController.getArtistsTopTracks(this.artist.getId(), "");
    }
}

// Stub class for SpotifyAuthController
class SpotifyAuthControllerStub extends SpotifyAuthController {
    private boolean returnEmptyList = false;

    public SpotifyAuthControllerStub() {
        super(null); // Pass null as TokenService isn't needed here
    }

    public void setReturnEmptyList(boolean returnEmptyList) {
        this.returnEmptyList = returnEmptyList;
    }

    @Override
    public ArrayList<Artist> getUserTopArtists() {
        if (returnEmptyList) {
            return new ArrayList<>();
        }
        ArrayList<Artist> artists = new ArrayList<>();
        artists.add(new Artist("1", "Artist1", new ArrayList<>()));
        return artists;
    }

    @Override
    public ArrayList<Track> getArtistsTopTracks(String artistId, String market) {
        return new ArrayList<>();
    }
}

// Test output boundary
class TestOutputBoundary implements RecArtistOutputBoundary {
    private boolean successViewPrepared = false;
    private boolean failViewPrepared = false;

    @Override
    public void prepareSuccessView(RecArtistOutputData outputData) {
        successViewPrepared = true;
    }

    @Override
    public void prepareFailView(String errorMessage) {
        failViewPrepared = true;
    }

    public boolean wasSuccessViewPrepared() {
        return successViewPrepared;
    }

    public boolean wasFailViewPrepared() {
        return failViewPrepared;
    }
}
