package interface_adapter.import_playlist;

public class ImportPlaylistState {
    private boolean importSuccess;
    private String message;

    public boolean isImportSuccess() {
        return importSuccess;
    }

    public void setImportSuccess(boolean importSuccess) {
        this.importSuccess = importSuccess;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}