package com.isa.projekat.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CinemaTheatre implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="ct_name", nullable = false)
	private String name;
	
	@Column(name="ct_adress", nullable = false)
	private String adress;
	
	@Column(name="ct_description", nullable = false)
	private String description;
	
	@Column(name="ct_type", nullable = false)
	private CinemaTheatreType type;
	
	
	public CinemaTheatre(String name, String adress, String description, CinemaTheatreType type) {
		this.name = name;
		this.adress = adress;
		this.description = description;
		this.type = type;
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
