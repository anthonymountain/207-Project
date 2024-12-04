package services;

import entity.User;
import org.json.JSONObject;

/**
 * Service to parse Spotify user information JSON and create a User entity.
 */
public class UserService {

    /**
     * Parses Spotify user JSON and creates a User entity.
     *
     * @param json the Spotify user JSON response as a string
     * @return User entity created from the JSON data
     */
    public User createUserFromJson(String json) {
        final JSONObject jsonObject = new JSONObject(json);

        final String id = jsonObject.getString("id");
        final String displayName = jsonObject.getString("display_name");

        return new User(id, displayName);
    }
}