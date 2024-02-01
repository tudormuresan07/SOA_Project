package ro.ubb.tudor.gateway.controller;


import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import ro.ubb.tudor.gateway.model.*;
import ro.ubb.tudor.gateway.proxy.*;


@RestController
@RequestMapping("v1/gateway/client")
public class GatewayClientController {

	@Autowired
	private ClientProxy clientProxy;

	@PostMapping("/create")
	@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.POST})
	public void create( @RequestBody Client client) {
		clientProxy.create(client);
	}

	@GetMapping("/clients")
	@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET})
	public List<Client> getClients() {
		return clientProxy.getClients();
	}

	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable(name = "id") String id)  {
		clientProxy.remove(id);
	}

	@GetMapping("/clients/{id}")
	@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET})
	public Client getClient(@PathVariable(name = "id") String id) {
		return clientProxy.getClient(id);
	}

	@PostMapping("/login")
	@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.POST})
	public void login(@RequestBody LoginRequest loginRequest) {
		clientProxy.login(loginRequest);
	}

	@GetMapping("/clients/email/{email}")
	@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET})
	public boolean getClientByEmail(@PathVariable(name = "email") String email) {
		return clientProxy.getClientByEmail(email);
	}

}
