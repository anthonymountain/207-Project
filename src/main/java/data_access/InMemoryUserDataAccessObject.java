package data_access;

import java.util.HashMap;
import java.util.Map;

import entity.Artist;
import entity.Genre;
import entity.Track;
import entity.User;
import use_case.login.LoginUserDataAccessInterface;
import use_case.logout.LogoutUserDataAccessInterface;
import use_case.rec_genre.RecGenreUserDataAccessInterface;

/**
 * In-memory implementation of the DAO for storing user data. This implementation does
 * NOT persist data between runs of the program.
 */
public class InMemoryUserDataAccessObject implements LoginUserDataAccessInterface,
        LogoutUserDataAccessInterface,
        RecGenreUserDataAccessInterface {
        LogoutUserDataAccessInterface {

    private final Map<String, User> users = new HashMap<>();

    private String currentUsername;
    private Genre recommendedGenre;
    private Artist recommendedArtist;

    @Override
    public boolean existsByName(String identifier) {
        return users.containsKey(identifier);
    }

    @Override
    public void save(User user) {
        users.put(user.getName(), user);
    }

    @Override
    public User get(String username) {
        return users.get(username);
    }

    @Override
    public void setCurrentUsername(String name) {
        this.currentUsername = name;
    }

    @Override
    public String getCurrentUsername() {
        return this.currentUsername;
    }

    @Override
    public void recommendGenre(Genre genre) {
        this.recommendedGenre = genre;
    }

}
