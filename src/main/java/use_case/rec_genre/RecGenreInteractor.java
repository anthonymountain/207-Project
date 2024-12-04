package use_case.rec_genre;

import java.util.ArrayList;
import java.util.Random;

import entity.Genre;

/**
 * The Recommend Genre Interactor.
 */
public class RecGenreInteractor implements RecGenreInputBoundary {
    private final RecGenreDataAccessInterface recGenreUserDataAccessObject;
    private final RecGenreOutputBoundary recGenrePresenter;

    /**
     * Constructs a RecGenreInteractor with the provided DataAccessObject and OutputBoundary.
     *
     * @param recGenreUserDataAccessObject The DAO for accessing genre user data.
     * @param recGenreOutputBoundary The output boundary for preparing the output data.
     */
    public RecGenreInteractor(RecGenreDataAccessInterface recGenreUserDataAccessObject,
                              RecGenreOutputBoundary recGenreOutputBoundary) {
        this.recGenreUserDataAccessObject = recGenreUserDataAccessObject;
        this.recGenrePresenter = recGenreOutputBoundary;
    }

    /**
     * Executes the genre recommendation use case.
     *
     * @param recGenreInputData The input data containing the user information.
     */
    @Override
    public void execute(RecGenreInputData recGenreInputData) {
        final Genre userPreferredGenres = recGenreUserDataAccessObject.getGenre();

        if (userPreferredGenres == null || userPreferredGenres.getGenres() == null || userPreferredGenres
                .getGenres().isEmpty()) {
            recGenrePresenter.prepareFailView("No preferred genres found for user.");
        }
        else {
            final Random random = new Random();
            final ArrayList<String> genres = userPreferredGenres.getGenres();

            if (genres == null || genres.isEmpty()) {
                recGenrePresenter.prepareFailView("No genres found in the user's preferences.");
            }
            else {
                final String recommendedGenreName = genres.get(random.nextInt(genres.size()));

                final ArrayList<String> recommendedGenreList = new ArrayList<>();
                recommendedGenreList.add(recommendedGenreName);

                final Genre recommendedGenre = new Genre(recommendedGenreList);

                final RecGenreOutputData outputData = new RecGenreOutputData(recommendedGenre);

                recGenrePresenter.prepareSuccessView(outputData);
            }
        }
    }
}

