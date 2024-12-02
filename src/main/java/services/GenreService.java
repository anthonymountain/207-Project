package services;

import java.util.ArrayList;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

import entity.Genre;

@Service
public class GenreService {

    /**
     * Parses the JSON object response from the API.
     * @param genreJson the response from the API.
     * @return the genre.
     */
    public Genre parseGenreFromJson(JSONObject genreJson) {
        final ArrayList<String> genres = genreJson.getNames("id");
        genreJson.getJSONArray("genres").forEach(genre -> {
            final ArrayList<String> genreList = new ArrayList<>();
            genreList.add(genre.toString());
            genres.add(new Genre(genreList));
        });

        return new Genre(genres);
    }
}
