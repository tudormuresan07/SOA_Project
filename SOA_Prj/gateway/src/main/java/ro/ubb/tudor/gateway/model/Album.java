package ro.ubb.tudor.gateway.model;


import com.fasterxml.jackson.annotation.*;


public class Album {

	@JsonProperty("title")
	private String title;

	@JsonProperty("band")
	private String band;

	@JsonProperty("availableQuantity")
	private int availableQuantity;
}
