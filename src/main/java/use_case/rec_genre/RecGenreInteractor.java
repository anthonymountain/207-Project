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
    public void execute(RecGenreInputData recGenreInputData) {
        final Genre genre = genreFactory.create(recGenreInputData.getType(), recGenreInputData.getDescription());
        recGenreUserDataAccessObject.recommend(genre);
        final RecGenreOutputData recGenreOutputData = new RecGenreOutputData(genre);
        recGenrePresenter.prepareSuccessView(recGenreOutputData);
    }
}

