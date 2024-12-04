package interface_adapter.rec_track;

import entity.Track;
import use_case.rec_track.RecTrackInputBoundary;
import use_case.rec_track.RecTrackInputData;

/**
 * Controller for the Recommend Track Use Case.
 */
public class RecTrackController {
    private final RecTrackInputBoundary recTrackUseCaseInteractor;

    public RecTrackController(RecTrackInputBoundary recTrackUseCaseInteractor) {
        this.recTrackUseCaseInteractor = recTrackUseCaseInteractor;
    }

    /**
     * Executes the Recommend Track Use Case.
     * Highly recommend looking at the Recommend Song Use Case to see how to properly use recTrackInputData.
     */
    public void execute() {
        final RecTrackInputData recTrackInputData = new RecTrackInputData();

        recTrackUseCaseInteractor.execute(recTrackInputData);
    }
}