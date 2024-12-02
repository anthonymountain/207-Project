package use_case.rec_artist;

import entity.Artist;

/**
 * Input Boundary for actions which are related to recommending an artist.
 */
public interface RecArtistInputBoundary {

    /**
     * Executes the RecArtist use case.
     * @param recArtistInputData the input data
     */
    void execute(RecArtistInputData recArtistInputData);

    Artist getArtist();
}
