package use_case.rec_album;

/**
 * Input boundary for recommending an album.
 */
public interface RecAlbumInputBoundary {
    /**
     * Executes the use case.
     *
     * @param recAlbumInputData Input data for the use case.
     */
    void execute(RecAlbumInputData recAlbumInputData);
}
