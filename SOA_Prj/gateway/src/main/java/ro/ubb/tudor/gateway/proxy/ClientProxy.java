package ro.ubb.tudor.gateway.proxy;


import java.util.*;

import org.springframework.http.*;
import org.springframework.stereotype.*;
import org.springframework.web.client.*;
import org.springframework.web.servlet.function.*;
import ro.ubb.tudor.gateway.model.*;


@Component
public class ClientProxy {

	private final RestTemplate restTemplate;

	private final String url;

	public ClientProxy(RestTemplate restTemplate){
		this.restTemplate = restTemplate;
		this.url = "http://localhost:8082/";
	}

	public List<Client> getClients() {
		return restTemplate.getForObject(url + "v1/client/clients", List.class);
	}

	public void create(Client client) {
		if(!isUserLoggedIn()){
			throw new IllegalArgumentException("Employee not logged in!");
		}
		restTemplate.postForObject(url + "v1/client/create", client, Client.class);
	}

	public void remove(String id) {
		if(!isUserLoggedIn()){
			throw new IllegalArgumentException("Employee not logged in!");
		}
		restTemplate.delete(url + "v1/client/delete/{id}", Map.of("id", id));
	}

	public Client getClient(String id) {
		return restTemplate.getForObject(url + "v1/client/clients/{id}", Client.class, Map.of("id", id));
	}

	public void login(LoginRequest loginRequest){
		restTemplate.postForObject(url + "v1/client/login", loginRequest, LoginRequest.class);
	}

	public boolean getClientByEmail(String email){
		return Boolean.TRUE.equals(restTemplate.getForObject(url + "v1/client/clients/email/{email}", Boolean.class, Map.of("email", email)));
	}

	public boolean isUserLoggedIn(){
		return Boolean.TRUE.equals(restTemplate.getForObject(url + "v1/client/logged-in", Boolean.class));
	}
}
