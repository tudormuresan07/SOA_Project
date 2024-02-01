package ro.ubb.tudor.albumshopservice.model;


import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.*;


@Entity(name = "albums")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Album {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column
	@JsonProperty("title")
	private String title;

	@Column
	@JsonProperty("band")
	private String band;

	@Column
	@JsonProperty("availableQuantity")
	private int availableQuantity;

	public void decreaseQuantity(){
		this.availableQuantity--;
	}
}
