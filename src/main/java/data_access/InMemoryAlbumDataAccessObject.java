package data_access;

import entity.Album;

import use_case.rec_album.RecAlbumUserDataAccessInterface;

import java.util.ArrayList;


public class InMemoryAlbumDataAccessObject implements RecAlbumUserDataAccessInterface {
    private final ArrayList<Album> recommended = new ArrayList<Album>();
