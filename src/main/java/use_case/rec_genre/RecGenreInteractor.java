package use_case.rec_genre;

import entity.Genre;

/**
 * The Recommend Genre Interactor.
 */
public class RecGenreInteractor implements RecGenreInputBoundary {
    private final RecGenreDataAccessInterface recGenreUserDataAccessObject;
    private final RecGenreOutputBoundary recGenrePresenter;

    public RecGenreInteractor(RecGenreDataAccessInterface recGenreUserDataAccessInterface,
                              RecGenreOutputBoundary recGenreOutputBoundary) {
        this.recGenreUserDataAccessObject = recGenreUserDataAccessInterface;
        this.recGenrePresenter = recGenreOutputBoundary;
    }

    @Override
    public void execute(RecGenreInputData recGenreInputData) {
        // Create a Genre instance using the input data


        final Genre genre = new Genre(recGenreInputData());

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

