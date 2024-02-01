package ro.ubb.tudor.clientserver.service;


import java.util.*;

import javax.transaction.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.*;
import ro.ubb.tudor.clientserver.model.*;
import ro.ubb.tudor.clientserver.repository.*;


@Service
@Transactional
public class ClientServiceImpl implements ClientService{

	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private RedisService redisService;

	@Override
	public List<Client> getClients() {
		return this.clientRepository.findAll();
	}

	@Override
	public Client getClient(Long clientId) {
		return this.clientRepository.findById(clientId).orElse(null);
	}

	@Override
	public void create(Client client) {
		if(!isUserLoggedIn()){
			throw new IllegalArgumentException("Only employees can add new clients");
		}
		this.clientRepository.save(client);
	}

	@Override
	public void delete(Long id) {
		this.clientRepository.findById(id).ifPresent((client) -> this.clientRepository.delete(client));
	}

	@Override
	public Client login(String email, String password) {
		if(password == null){
			return null;
		}
		Optional<Client> client = this.clientRepository.findByEmailAndPassword(email, password);
		if(client.isPresent()){

			redisService.setValue("email:"+email, password);
		}

		return client.orElse(null);
	}

	@Override
	public Client getClientByEmail(String email) {
		return this.clientRepository.findByEmail(email).orElse(null);
	}

	@Override
	public boolean isUserLoggedIn() {
		return redisService.getAllValuesMatchingPattern("email").size()!=0;
	}
}
