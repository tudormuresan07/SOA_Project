package ro.ubb.tudor.albumshopservice.service;


import java.util.*;

import ro.ubb.tudor.albumshopservice.model.*;


public interface AlbumService {
	List<Album> getAlbums();
	Album create(Album album);
	void buyAlbum(String albumTitle, String clientId);
	void deleteAlbum(String albumId);

	Album getAlbum(String albumId);

}
