package java_use_case.rec_track;

import data_access.InMemoryTrackDataAccessObject;
import entity.Track;
import interface_adapter.spotify_auth.SpotifyAuthController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import use_case.rec_track.RecTrackInteractor;
import use_case.rec_track.RecTrackOutputBoundary;
import use_case.rec_track.RecTrackOutputData;
import use_case.rec_track.*;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

class RecTrackInteractorTest {

    @Test
    void testExecuteWithValidTracks() {
        // Arrange
        SpotifyAuthControllerStub spotifyAuthControllerStub = new SpotifyAuthControllerStub();
        InMemoryTrackDataAccessObject dao = new InMemoryTrackDataAccessObject(spotifyAuthControllerStub);
        TestOutputBoundary outputBoundary = new TestOutputBoundary();

        RecTrackInteractor interactor = new RecTrackInteractor(dao, outputBoundary);

        // Act
        interactor.execute(null);

        // Assert
        Track track = dao.getTrack();
        Assertions.assertNotNull(track);
        Assertions.assertEquals("Track1", track.getName());
        Assertions.assertTrue(outputBoundary.wasSuccessViewPrepared());
    }

    @Test
    void testExecuteWithNoTracks() {
        // Arrange
        SpotifyAuthControllerStub spotifyAuthControllerStub = new SpotifyAuthControllerStub();
        spotifyAuthControllerStub.setReturnEmptyList(true); // Simulate no tracks case
        InMemoryTrackDataAccessObject dao = new InMemoryTrackDataAccessObject(spotifyAuthControllerStub);
        TestOutputBoundary outputBoundary = new TestOutputBoundary();

        RecTrackInteractor interactor = new RecTrackInteractor(dao, outputBoundary);

        // Act
        interactor.execute(null);

        // Assert
        Track track = dao.getTrack();
        Assertions.assertNotNull(track);
        Assertions.assertEquals("Peewee", track.getName());
        Assertions.assertTrue(outputBoundary.wasSuccessViewPrepared());
    }

    @Test
    public void successTrackRecommendedTest(){
        RecTrackInputData recTrackInputData = new RecTrackInputData();
        TestTrackDataAccessObject testTrackDataAccessObject = new TestTrackDataAccessObject(new SpotifyAuthControllerStub());

        // Presenter to see if our use case handles as expected
        RecTrackOutputBoundary recTrackPresenter = new RecTrackOutputBoundary() {
            @Override
            public void prepareSuccessView(RecTrackOutputData outputData) {
                assertEquals(testTrackDataAccessObject.getTrack(), outputData.getTrack());
                assertEquals(testTrackDataAccessObject.getTrack().getName(), outputData.getName());
                assertEquals(outputData.isUseCaseFailed(), false);
            }

            @Override
            public void prepareFailView(String errorMessage) {
                fail("Use case failure is unexpected");
            }
        };

        RecTrackInputBoundary recTrackInteractor = new RecTrackInteractor(testTrackDataAccessObject,
                recTrackPresenter);
        recTrackInteractor.execute(recTrackInputData);
    }
}

class TestTrackDataAccessObject implements RecTrackDataAccessInterface {
    private Track track;
    private SpotifyAuthControllerStub spotifyAuthController;

    public TestTrackDataAccessObject(SpotifyAuthControllerStub spotifyAuthController) {
        this.spotifyAuthController = spotifyAuthController;
    }

    @Override
    public void setTrack(Track track) {
        this.track = track;
    }

    @Override
    public Track getTrack() {
        return track;
    }

    public ArrayList<Track> getUserTopTracks() {
        return this.spotifyAuthController.getUserTopTracks();
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
    public ArrayList<Track> getUserTopTracks() {
        if (returnEmptyList) {
            return new ArrayList<>();
        }
        ArrayList<Track> tracks = new ArrayList<>();
        tracks.add(new Track("1", "Track1", 0, null, new ArrayList<>()));
        return tracks;
    }
}

// Test output boundary
class TestOutputBoundary implements RecTrackOutputBoundary {
    private boolean successViewPrepared = false;
    private boolean failViewPrepared = false;

    @Override
    public void prepareSuccessView(RecTrackOutputData outputData) {
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
