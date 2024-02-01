package ro.ubb.tudor.albumshopservice.repository;


import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;
import ro.ubb.tudor.albumshopservice.model.*;


@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
}
