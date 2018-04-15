package com.isa.projekat.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

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
	
	@OneToMany(targetEntity = Hall.class)
	private List<Hall> halls;
	
	@OneToOne(targetEntity = Repertoire.class)
	private Repertoire repertoire;
	
	@OneToMany
	private List<MovieShow> movieShows;
	
	public CinemaTheatre() {}
	
	public CinemaTheatre(Long id, String name, String adress, String description, CinemaTheatreType type,
			List<Hall> halls, Repertoire repertoire, List<MovieShow> movieShows) {
		super();
		this.id = id;
		this.name = name;
		this.adress = adress;
		this.description = description;
		this.type = type;
		this.halls = halls;
		this.repertoire = repertoire;
		this.movieShows = movieShows;
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

	public List<Hall> getHalls() {
		return halls;
	}

	public void setHalls(List<Hall> halls) {
		this.halls = halls;
	}

	public Repertoire getRepertoire() {
		return repertoire;
	}

	public void setRepertoire(Repertoire repertoire) {
		this.repertoire = repertoire;
	}

	public List<MovieShow> getMovieShows() {
		return movieShows;
	}

	public void setMovieShows(List<MovieShow> movieShows) {
		this.movieShows = movieShows;
	}
	
}
