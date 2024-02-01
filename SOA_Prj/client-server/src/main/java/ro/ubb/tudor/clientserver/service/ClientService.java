package ro.ubb.tudor.clientserver.service;


import java.util.*;

import ro.ubb.tudor.clientserver.model.*;


public interface ClientService {

	List<Client> getClients();
	Client getClient(Long clientId);
	void create(Client client);
	void delete(Long id);

	Client login(String email, String password);

	Client getClientByEmail(String email);

	boolean isUserLoggedIn();

}
