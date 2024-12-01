package use_case.rec_genre;

import data_access.InMemoryUserDataAccessObject;
import entity.CommonGenreFactory;
import entity.Genre;
import entity.Genre;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecGenreInteractorTest {
    private RecGenreInteractor interactor;
    private TestRecGenreUserDataAccess dataAccess;
    private TestRecGenreOutputBoundary presenter;

    @BeforeEach
    void setUp() {
        GenreFactory genreFactory = new CommonGenreFactory();
        dataAccess = new TestRecGenreUserDataAccess();
        presenter = new TestRecGenreOutputBoundary();

        interactor = new RecGenreInteractor(dataAccess, presenter, genreFactory);
    }

    @Test
    void testExecuteSuccess() {
        // Arrange
        RecGenreInputData inputData = new RecGenreInputData("Rock", "Energetic music");

        // Act
        interactor.execute(inputData);

        // Assert
        // Verify that the Genre was created and recommended
        assertNotNull(dataAccess.recommendedGenre);
        assertEquals("Rock", dataAccess.recommendedGenre.getType());
        assertEquals("Energetic music", dataAccess.recommendedGenre.getDescription());

        // Verify that the presenter received the correct output
        assertNotNull(presenter.outputData);
        assertEquals(dataAccess.recommendedGenre, presenter.outputData.getGenre());
    }

    @Test
    void testExecuteWithNullInput() {
        // Act & Assert
        assertThrows(NullPointerException.class, () -> interactor.execute(null));
    }

    @Test
    void testExecuteWithIncompleteInput() {
        // Arrange
        RecGenreInputData inputData = new RecGenreInputData(null, null);

        // Act
        interactor.execute(inputData);

        // Assert
        // Verify that an incomplete Genre is passed to dataAccess
        assertNotNull(dataAccess.recommendedGenre);
        assertNull(dataAccess.recommendedGenre.getType());
        assertNull(dataAccess.recommendedGenre.getDescription());

        // Verify that the presenter still receives an output
        assertNotNull(presenter.outputData);
        assertEquals(dataAccess.recommendedGenre, presenter.outputData.getGenre());
    }

    // Stub class for testing RecGenreUserDataAccessInterface
    private static class TestRecGenreUserDataAccess implements RecGenreUserDataAccessInterface {
        Genre recommendedGenre;

        @Override
        public void recommendGenre(Genre genre) {
            this.recommendedGenre = genre;
        }
    }

    // Stub class for testing RecGenreOutputBoundary
    private static class TestRecGenreOutputBoundary implements RecGenreOutputBoundary {
        RecGenreOutputData outputData;

        @Override
        public void prepareSuccessView(RecGenreOutputData outputData) {
            this.outputData = outputData;
        }
    }
}

