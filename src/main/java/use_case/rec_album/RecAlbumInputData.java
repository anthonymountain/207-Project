package use_case.rec_album;

import java.util.ArrayList;

/**
 * Input data for recommending an album.
 */
public class RecAlbumInputData {

    private final String id;
    private final String name;
    private final ArrayList<String> artists;
    @SuppressWarnings({"checkstyle:MemberName", "checkstyle:SuppressWarnings"})
    private final String album_type;
    private final ArrayList<Object> images;

    public RecAlbumInputData(String id, String name,
                             ArrayList<String> artists, String album_type, ArrayList<Object> images) {
        this.id = id;
        this.name = name;
        this.artists = artists;
        this.album_type = album_type;
        this.images = images;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getArtists() {
        return artists;
    }

    public String getAlbumType() {
        return album_type;
    }

    public ArrayList<Object> getImages() {
        return images;
    }

}
