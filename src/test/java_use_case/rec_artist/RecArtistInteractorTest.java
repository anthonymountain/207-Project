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

import java.util.ArrayList;

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

    // Stub class for SpotifyAuthController
    private static class SpotifyAuthControllerStub extends SpotifyAuthController {
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
    private static class TestOutputBoundary implements RecArtistOutputBoundary {
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
}
