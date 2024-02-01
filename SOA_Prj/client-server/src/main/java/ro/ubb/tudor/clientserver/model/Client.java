package ro.ubb.tudor.clientserver.model;


import javax.persistence.*;

import com.fasterxml.jackson.annotation.*;
import lombok.*;


@Entity(name = "clients")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userId;

	@Column
	@JsonProperty("email")
	private String email;

	@Column
	@JsonProperty("first_name")
	private String firstName;

	@Column
	@JsonProperty("last_name")
	private String lastName;

	@Column
	@JsonProperty("age")
	private int age;

	@Column
	@JsonProperty("password")
	private String password;

}
