package use_case.rec_album;

import entity.Album;

import java.util.ArrayList;

public class RecAlbumOutputData {
    private final String id;
    private final String name;
    private final boolean success;
    private final String message;

    public RecAlbumOutputData(String id, String name, boolean success, String message) {
        this.id = id;
        this.name = name;
        this.success = success;
        this.message = message;
    }

    public String getId() {
        return id;
    }

    public String getAlbumName() {
        return name;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public Album getAlbum() {
        return new Album(this.id, this.name, 0, new ArrayList<>(), new ArrayList<>());
    }
}

