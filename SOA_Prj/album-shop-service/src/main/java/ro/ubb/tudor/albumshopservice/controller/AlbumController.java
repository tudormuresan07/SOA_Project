package ro.ubb.tudor.albumshopservice.controller;


import java.util.*;
import java.util.stream.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import ro.ubb.tudor.albumshopservice.model.*;
import ro.ubb.tudor.albumshopservice.service.*;


@RestController
@RequestMapping("/v1/album")
public class AlbumController {

	@Autowired
	private AlbumService albumService;

	@PostMapping("/create")
	@ResponseStatus(HttpStatus.CREATED)
	@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.POST})
	public Album create(@RequestBody Album album) {
		album.setAvailableQuantity(10);
		return albumService.create(album);
	}

	@PostMapping("{clientId}/clients/{title}")
	@ResponseStatus(HttpStatus.CREATED)
	@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.POST})
	public void buyAlbum(@PathVariable(name = "clientId") String clientId,
	                      @PathVariable(name = "title") String albumTitle) {
		albumService.buyAlbum(clientId, albumTitle);
	}

	@DeleteMapping("/delete/{albumId}")
	public void delete(@PathVariable(name = "albumId") String albumId) {
		albumService.deleteAlbum(albumId);
	}

	@GetMapping("/albums")
	@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET})
	public List<Album> getAlbums() {
		return albumService.getAlbums().stream().filter(album -> album.getAvailableQuantity()>0).collect(Collectors.toList());
	}

	@GetMapping("/albums/{albumId}")
	@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET})
	public Album getAlbum(@PathVariable(name = "albumId") String albumId) {
		return albumService.getAlbum(albumId);
	}

}
