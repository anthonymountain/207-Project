package java.use_case.rec_artist;

import data_access.InMemoryArtistDataAccessObject;
import entity.Artist;
import entity.Genre;
import entity.Track;
import org.junit.jupiter.api.Test;
import use_case.rec_artist.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class RecArtistInteractorTest {

    @Test
    void testInteractorExecutesSuccessfully() {
        // Mock implementation of the User Data Access Interface
        InMemoryArtistDataAccessObject dataAccessMock = new InMemoryArtistDataAccessObject() {
            private Artist recommendedArtist;

            @Override
            public void recommendArtist(Artist artist) {
                this.recommendedArtist = artist;
            }

            public Artist getRecommendedArtist() {
                return this.recommendedArtist;
            }
        };

        // Mock implementation of the Output Boundary
        RecArtistOutputBoundary presenterMock = new RecArtistOutputBoundary() {
            private boolean successCalled = false;

            @Override
            public void prepareSuccessView(RecArtistOutputData outputData) {
                successCalled = true;
                assertEquals("Test Artist", outputData.getName());
            }

            @Override
            public void prepareFailView(String errorMessage) {
                fail("prepareFailView should not be called");
            }

            public boolean wasSuccessCalled() {
                return successCalled;
            }
        };

        // Create the interactor
        RecArtistInteractor interactor = new RecArtistInteractor(dataAccessMock, presenterMock);

        // Input Data
        ArrayList<Genre> genres = new ArrayList<Genre>();
        genres.add(new Genre("Pop"));

        ArrayList<Track> tracks = new ArrayList<Track>();
        tracks.add(new Track("1", "Track1", 0, null, null));

        RecArtistInputData inputData = new RecArtistInputData(new Artist("1", "Test Artist", tracks, genres)
        );

        // Execute the interactor
        interactor.execute(inputData);

        // Assertions
        Artist savedArtist = ((RecArtistUserDataAccessInterface) dataAccessMock).get().getArtist();

        artistMock
    }
}
