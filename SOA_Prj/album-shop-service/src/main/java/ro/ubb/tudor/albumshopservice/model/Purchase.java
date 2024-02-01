package ro.ubb.tudor.albumshopservice.model;


import java.util.*;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.*;


@Entity(name = "purchase")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Purchase {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@Column
	private Long albumId;

	@Column
	private Long clientId;

	@Column
	@CreationTimestamp
	private Date purchaseDate;
}
