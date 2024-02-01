package ro.ubb.tudor.albumshopservice.service;


import java.util.*;

import jakarta.transaction.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import ro.ubb.tudor.albumshopservice.model.*;
import ro.ubb.tudor.albumshopservice.repository.*;


@Service
@Transactional
public class AlbumServiceImpl implements AlbumService{

	@Autowired
	private AlbumRepository albumRepository;

	@Autowired
	private PurchaseRepository purchaseRepository;

	@Override
	public List<Album> getAlbums() {
		return this.albumRepository.findAll();
	}

	@Override
	public Album create(Album album) {
		return albumRepository.save(album);
	}

	@Override
	public void buyAlbum(String albumTitle, String clientId) {
		Album album = this.albumRepository.findByTitle(albumTitle).get();

		Long id = Long.valueOf(clientId);

		Purchase purchase = new Purchase();
		purchase.setAlbumId(album.getId());
		purchase.setClientId(id);
		purchase.setPurchaseDate(new Date());

		album.decreaseQuantity();
		purchaseRepository.save(purchase);

	}

	@Override
	public void deleteAlbum(String albumId) {
		Album album = this.albumRepository.findById(Long.valueOf(albumId)).get();
		this.albumRepository.delete(album);
	}

	@Override
	public Album getAlbum(String albumId) {
		return this.albumRepository.findById(Long.valueOf(albumId)).orElse(null);
	}


}
