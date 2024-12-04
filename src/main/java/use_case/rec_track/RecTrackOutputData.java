package use_case.rec_track;

import entity.Track;

/**
 * Output Data for the RecTrack Use Case.
 */
public class RecTrackOutputData {

    private final Track track;
    private final boolean useCaseFailed;

    public RecTrackOutputData(Track track, boolean useCaseFailed) {
        this.track = track;
        this.useCaseFailed = useCaseFailed;
    }

    public String getName() {
        return track.getName();
    }

    public boolean isUseCaseFailed() {
        return useCaseFailed;
    }

    public Track getTrack() {
        return this.track;
    }
}
