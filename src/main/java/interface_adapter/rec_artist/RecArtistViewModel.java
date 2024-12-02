package interface_adapter.rec_artist;

import interface_adapter.ViewModel;

/**
 * The view model for a recommended artist.
 */
public class RecArtistViewModel extends ViewModel<RecArtistState> {

    private String artistDetails;
    private boolean isError;

    public RecArtistViewModel() {
        super("artist recommended");
        setState(new RecArtistState());
    }

    public String getArtistDetails() {
        return artistDetails;
    }

    public void setArtistDetails(String artistDetails) {
        this.artistDetails = artistDetails;
    }

    public boolean isError() {
        return isError;
    }

    public void setError(boolean error) {
        isError = error;
    }
}
