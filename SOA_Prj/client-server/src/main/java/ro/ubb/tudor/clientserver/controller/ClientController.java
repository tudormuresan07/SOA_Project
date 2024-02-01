package ro.ubb.tudor.clientserver.controller;


import java.util.*;

import javax.validation.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.cache.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import ro.ubb.tudor.clientserver.model.*;
import ro.ubb.tudor.clientserver.service.*;


@RestController
@RequestMapping("/v1/client")
public class ClientController {

	@Autowired
	private ClientService clientService;

	@PostMapping("/create")
	@ResponseStatus(HttpStatus.CREATED)
	@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.POST})
	public void create(@Valid @RequestBody Client client) {
		clientService.create(client);

	}

	@DeleteMapping("delete/{id}")
	public void delete(@PathVariable("id") String clientId) {
		var client = Optional.ofNullable(clientId)
			.map(u -> Long.valueOf(clientId))
			.map(clientService::getClient)
			.orElseThrow();

		clientService.delete(client.getUserId());
	}

	@GetMapping("/clients")
	@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET})
	public List<Client> getClients() {
		return clientService.getClients();
	}

	@GetMapping("/clients/{id}")
	public Client getClient(@PathVariable("id") String clientId) {
		return  Optional.ofNullable(clientId)
			.map(u -> Long.valueOf(clientId))
			.map(clientService::getClient)
			.orElseThrow();
	}

	@PostMapping("/login")
	@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.POST})
	public void login(@RequestBody LoginRequest loginRequest) {
		Client client = clientService.login(loginRequest.getEmail(), loginRequest.getPassword());
		if(client == null){
			throw new IllegalArgumentException("Invalid credentials");
		}
	}

	@GetMapping("/clients/email/{email}")
	public boolean getClientByEmail(@PathVariable String email){
		return (this.clientService.getClientByEmail(email) != null);
	}

	@GetMapping("/logged-in")
	@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET})
	public boolean isEmployeeLoggedIn(){
		return this.clientService.isUserLoggedIn();
	}

}
