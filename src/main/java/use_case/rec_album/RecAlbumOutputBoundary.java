package use_case.rec_album;

/**
 * Output boundary for recommending an album.
 */
public interface RecAlbumOutputBoundary {
    /**
     * Prepares the success view.
     *
     * @param recAlbumOutputData Output data for the use case.
     */
    void prepareSuccessView(RecAlbumOutputData recAlbumOutputData);
    /**
     * Prepares the failure view.
     *
     * @param recAlbumOutputData Output data for the use case.
     */
    void prepareFailView(RecAlbumOutputData recAlbumOutputData);
}
