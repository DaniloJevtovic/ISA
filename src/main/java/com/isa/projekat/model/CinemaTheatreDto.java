package com.isa.projekat.model;

public class CinemaTheatreDto {

	private Long id;
	private String name;
	private String adress;
	private String description;
	private CinemaTheatreType type;
	
	public CinemaTheatreDto(CinemaTheatre cinemaTheatre) {
		this.id = cinemaTheatre.getId();
		this.name = cinemaTheatre.getName();
		this.adress = cinemaTheatre.getAdress();
		this.type = cinemaTheatre.getType();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public CinemaTheatreType getType() {
		return type;
	}

	public void setType(CinemaTheatreType type) {
		this.type = type;
	}

}
