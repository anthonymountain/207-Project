package service;

import entity.User;
import org.json.JSONObject;

/**
 * Service to parse Spotify user information JSON and create a User entity.
 */
public class SpotifyUserService {

    /**
     * Parses Spotify user JSON and creates a User entity.
     *
     * @param json the Spotify user JSON response as a string
     * @return User entity created from the JSON data
     */
    public User createUserFromJson(String json) {
        JSONObject jsonObject = new JSONObject(json);

        String id = jsonObject.getString("id");
        String displayName = jsonObject.getString("display_name");

        return new User(id, displayName);
    }
}