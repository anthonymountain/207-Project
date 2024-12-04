package use_case.rec_genre;

import entity.Genre;

/**
 * The Recommend Genre Interactor.
 */
public class RecGenreInteractor implements RecGenreInputBoundary {
    private final RecGenreUserDataAccessInterface recGenreUserDataAccessObject;
    private final RecGenreOutputBoundary recGenrePresenter;

    public RecGenreInteractor(RecGenreUserDataAccessInterface recGenreUserDataAccessInterface,
                              RecGenreOutputBoundary recGenreOutputBoundary) {
        this.recGenreUserDataAccessObject = recGenreUserDataAccessInterface;
        this.recGenrePresenter = recGenreOutputBoundary;
    }

    @Override
    public RecGenreOutputData execute(RecGenreInputData recGenreInputData) {
        // Create a Genre instance using the input data
        final Genre genre = new Genre(recGenreInputData.getGenres());

        // Save or process the genre recommendation
        recGenreUserDataAccessObject.recommendGenre();

        // Create output data
        final RecGenreOutputData recGenreOutputData = new RecGenreOutputData(genre);

        // Notify the Presenter to update the ViewModel
        recGenrePresenter.prepareSuccessView(recGenreOutputData);

        // Return the output data for further use by the controller or higher layers
        return recGenreOutputData;
    }
}

