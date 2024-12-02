package use_case.import_playlist;

public class ImportPlaylistOutputData {
    private final boolean success;
    private final String message;

    public ImportPlaylistOutputData(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }
}
