package ro.ubb.tudor.gateway.proxy;


import java.util.*;

import org.springframework.stereotype.*;
import org.springframework.web.client.*;
import ro.ubb.tudor.gateway.model.*;


@Component
public class AlbumProxy {

	private final RestTemplate restTemplate;
	private final String url;

	public AlbumProxy( RestTemplate restTemplate) {
		this.url = "http://localhost:8081/";
		this.restTemplate = restTemplate;
	}

	public Album create(Album album) {
		if(!isUserLoggedIn()){
			throw new IllegalArgumentException("Employee not logged in!");
		}
		return restTemplate.postForObject(url + "v1/album/create", album, Album.class);
	}

	public void buyAlbum(String albumTitle, String clientId) {
		if(!isUserLoggedIn()){
			throw new IllegalArgumentException("Employee not logged in!");
		}
		restTemplate.postForObject(url + "v1/album/{clientId}/clients/{title}", null, Void.class,
			Map.of("title", albumTitle, "clientId", clientId));
	}

	public void delete(String albumId) {
		if(!isUserLoggedIn()){
			throw new IllegalArgumentException("Employee not logged in!");
		}
		restTemplate.delete(url + "v1/album/delete/{albumId}", Map.of("albumId",
			albumId));
	}

	public List<Album> getAlbums() {
		return restTemplate.getForObject(url + "v1/album/albums", List.class);
	}

	public Album getAlbum(String albumId){
		return restTemplate.getForObject(url + "v1/album/albums/{albumId}", Album.class, Map.of("albumId",
			albumId));
	}

	public boolean isUserLoggedIn(){
		return Boolean.TRUE.equals(restTemplate.getForObject("http://localhost:8082/v1/client/logged-in", Boolean.class));
	}
}
