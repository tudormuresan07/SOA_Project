package ro.ubb.tudor.clientserver.model;


import com.fasterxml.jackson.annotation.*;


public class LoginRequest {

	@JsonProperty("email")
	private String email;

	@JsonProperty("password")
	private String password;

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}
}
