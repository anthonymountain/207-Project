package services;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import entity.*;

@Service
public class ArtistService {

    /**
     * Parses the JSON object response from the API.
     * @param artistJson the response from the API.
     * @return the artist.
     */
    public Artist parseArtistFromJson(JSONObject artistJson) {
        final String id = artistJson.getString("id");
        final String name = artistJson.getString("name");
        final ArrayList<Genre> genres = new ArrayList<>();
        artistJson.getJSONArray("genres").forEach(genre -> {
            final ArrayList<String> genreList = new ArrayList<>();
            genreList.add(genre.toString());
            genres.add(new Genre(genreList));
        });

        return new Artist(id, name, genres);
    }
}
