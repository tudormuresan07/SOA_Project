package ro.ubb.tudor.gateway.controller;


import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import ro.ubb.tudor.gateway.model.*;
import ro.ubb.tudor.gateway.proxy.*;


@RestController
@RequestMapping("v1/gateway/album")
public class GatewayAlbumController {

	@Autowired
	private AlbumProxy albumProxy;

	@PostMapping("/create")
	@ResponseStatus(HttpStatus.CREATED)
	@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.POST})
	public Album create(@RequestBody Album album) {
		return albumProxy.create(album);
	}

	@PostMapping("{clientId}/clients/{title}")
	@ResponseStatus(HttpStatus.CREATED)
	@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.POST})
	public void buyAlbum(@PathVariable(name = "clientId") String clientId,
	                      @PathVariable(name = "title") String albumTitle) {
		albumProxy.buyAlbum(clientId, albumTitle);
	}

	@GetMapping("/albums")
	@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET})
	public List<Album> getAlbums() {
		return albumProxy.getAlbums();
	}

	@DeleteMapping("/delete/{albumId}")
	public void remove(@PathVariable(name = "albumId") String albumId)  {
		albumProxy.delete(albumId);
	}

	@GetMapping("/albums/{id}")
	@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET})
	public Album getAlbum(@PathVariable(name = "id") String albumId) {
		return albumProxy.getAlbum(albumId);
	}
}
