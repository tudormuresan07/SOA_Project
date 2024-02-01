package ro.ubb.tudor.clientserver.repository;


import java.util.*;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;
import ro.ubb.tudor.clientserver.model.*;


@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
	Optional<Client> findByEmailAndPassword(String email, String password);
	Optional<Client> findByEmail(String email);
}
