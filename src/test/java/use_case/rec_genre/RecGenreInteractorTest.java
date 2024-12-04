package use_case.rec_genre;

import entity.Genre;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for RecGenreInteractor without using Mockito.
 */
public class RecGenreInteractorTest {

    private TestRecGenreDataAccess testDataAccess;
    private TestRecGenrePresenter testPresenter;
    private RecGenreInteractor interactor;

    @BeforeEach
    public void setUp() {
        testDataAccess = new TestRecGenreDataAccess();
        testPresenter = new TestRecGenrePresenter();
        interactor = new RecGenreInteractor(testDataAccess, testPresenter);
    }

    @Test
    public void testExecute_NoGenresFound() {
        // Test with no genres available
        testDataAccess.setGenre(null);

        // Execute the use case
        RecGenreInputData inputData = new RecGenreInputData();
        interactor.execute(inputData);

        // Assert failure message
        assertEquals("No preferred genres found for user.", testPresenter.getFailureMessage());
    }

    @Test
    public void testExecute_EmptyGenreList() {
        // Test with an empty genre list
        testDataAccess.setGenre(new Genre(new ArrayList<>())) ;

        // Execute the use case
        RecGenreInputData inputData = new RecGenreInputData();
        interactor.execute(inputData);

        // Assert failure message
        assertEquals("No preferred genres found for user.", testPresenter.getFailureMessage());
    }

    @Test
    public void testExecute_EmptyGenresInUserPreferences() {
        // Test with a genre that has an empty list of genres
        Genre genreWithEmptyList = new Genre(new ArrayList<>());
        testDataAccess.setGenre(genreWithEmptyList);

        // Execute the use case
        RecGenreInputData inputData = new RecGenreInputData();
        interactor.execute(inputData);

        // Assert failure message
        assertEquals("No genres found in the user's preferences.", testPresenter.getFailureMessage());
    }

    @Test
    public void testExecute_GenreRecommendationSuccess() {
        // Test with a list of genres
        ArrayList<String> genres = new ArrayList<>();
        genres.add("rock");
        genres.add("jazz");
        testDataAccess.setGenre(new Genre(genres));

        // Execute the use case
        RecGenreInputData inputData = new RecGenreInputData();
        interactor.execute(inputData);

        // Assert success message
        assertNotNull(testPresenter.getSuccessData());
    }

    @Test
    public void testExecute_GenreRecommendationSpecificCheck() {
        // Test with a specific genre
        ArrayList<String> genres = new ArrayList<>();
        genres.add("rock");
        testDataAccess.setGenre(new Genre(genres));

        // Execute the use case
        RecGenreInputData inputData = new RecGenreInputData();
        interactor.execute(inputData);

        // Assert specific genre recommended
        Genre recommendedGenre = testPresenter.getSuccessData().getGenre();
        assertEquals("rock", recommendedGenre.getGenres().get(0));
    }

    // Test implementations for RecGenreDataAccessInterface and RecGenreOutputBoundary
    static class TestRecGenreDataAccess implements RecGenreDataAccessInterface {
        private Genre genre;

        public void setGenre(Genre genre) {
            this.genre = genre;
        }

        @Override
        public Genre getGenre() {
            return genre;
        }
    }

    static class TestRecGenrePresenter implements RecGenreOutputBoundary {
        private String failureMessage;
        private RecGenreOutputData successData;

        @Override
        public void prepareFailView(String message) {
            this.failureMessage = message;
        }

        @Override
        public void prepareSuccessView(RecGenreOutputData outputData) {
            this.successData = outputData;
        }

        public String getFailureMessage() {
            return failureMessage;
        }

        public RecGenreOutputData getSuccessData() {
            return successData;
        }
    }
}
