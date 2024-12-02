package data_access;

import java.util.HashMap;
import java.util.Map;

import entity.Artist;
import entity.Genre;
import entity.Track;
import entity.User;
import interface_adapter.spotify_auth.SpotifyAuthController;
import use_case.login.LoginUserDataAccessInterface;
import use_case.logout.LogoutUserDataAccessInterface;
import use_case.rec_artist.RecArtistUserDataAccessInterface;
import use_case.rec_genre.RecGenreUserDataAccessInterface;
import use_case.rec_song.RecSongUserDataAccessInterface;

/**
 * In-memory implementation of the DAO for storing user data. This implementation does
 * NOT persist data between runs of the program.
 */
public class InMemoryUserDataAccessObject implements LoginUserDataAccessInterface,
        LogoutUserDataAccessInterface,
        RecGenreUserDataAccessInterface,
        RecSongUserDataAccessInterface,
        RecArtistUserDataAccessInterface {

    private final Map<String, User> users = new HashMap<>();

    private String currentUsername;
    private Track recommendedSong;
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
    public void recommendSong(Track song) {
        this.recommendedSong = song;
    }

    @Override
    public void recommendGenre(Genre genre) {
        this.recommendedGenre = genre;
    }

    @Override
    public void setArtist(Artist artist, SpotifyAuthController spotifyAuthController) {
        this.recommendedArtist = artist;
    }

    @Override
    public Artist getArtist() {
        return this.recommendedArtist;
    }
}
