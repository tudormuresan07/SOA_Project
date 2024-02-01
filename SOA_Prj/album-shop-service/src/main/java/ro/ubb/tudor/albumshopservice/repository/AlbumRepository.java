package ro.ubb.tudor.albumshopservice.repository;


import java.util.*;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;
import ro.ubb.tudor.albumshopservice.model.*;


@Repository
public interface AlbumRepository extends JpaRepository<Album, Long> {
	Optional<Album> findByTitle(String title);
}
