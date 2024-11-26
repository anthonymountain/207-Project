package use_case.rec_genre;

import entity.Genre;
import entity.GenreFactory;

/**
 * The Recommend Genre Interactor.
 */
public class RecGenreInteractor implements RecGenreInputBoundary {
    private final RecGenreUserDataAccessInterface recGenreUserDataAccessObject;
    private final RecGenreOutputBoundary recGenrePresenter;
    private final GenreFactory genreFactory;

    public RecGenreInteractor(RecGenreUserDataAccessInterface recGenreUserDataAccessInterface,
                              RecGenreOutputBoundary recGenreOutputBoundary,
                              GenreFactory genreFactory) {
        this.recGenreUserDataAccessObject = recGenreUserDataAccessInterface;
        this.recGenrePresenter = recGenreOutputBoundary;
        this.genreFactory = genreFactory;
    }

    @Override
    public RecGenreOutputData execute(RecGenreInputData recGenreInputData) {
        // Create a Genre instance using the input data
        final Genre genre = genreFactory.create(recGenreInputData.getType(), recGenreInputData.getDescription());

        // Save or process the genre recommendation
        recGenreUserDataAccessObject.recommendGenre(genre);

        // Create output data
        final RecGenreOutputData recGenreOutputData = new RecGenreOutputData(genre);

        // Notify the Presenter to update the ViewModel
        recGenrePresenter.prepareSuccessView(recGenreOutputData);

        // Return the output data for further use by the controller or higher layers
        return recGenreOutputData;
    }
}

