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
import use_case.rec_song.RecSongUserDataAccessInterface;
import use_case.rec_album.RecAlbumUserDataAccessInterface;

/**
 * In-memory implementation of the DAO for storing user data. This implementation does
 * NOT persist data between runs of the program.
 */
public class InMemoryUserDataAccessObject implements LoginUserDataAccessInterface,
        LogoutUserDataAccessInterface,
        RecGenreUserDataAccessInterface {
        RecGenreUserDataAccessInterface,
        RecSongUserDataAccessInterface,
        RecArtistUserDataAccessInterface, RecAlbumUserDataAccessInterface {

    private final Map<String, User> users = new HashMap<>();

    private String currentUsername;
    private Track recommendedSong;
    private Genre recommendedGenre;
    private Artist recommendedArtist;
    private Album recommendedAlbum;

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
    public void recommendArtist(Artist artist) {
        this.recommendedArtist = artist;
    }

    @Override
    public void recommendAlbum(Album album) {
        this.recommendedAlbum = album;
    }

}
