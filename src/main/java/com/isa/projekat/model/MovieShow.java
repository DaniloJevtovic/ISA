package com.isa.projekat.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class MovieShow implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "ms_type", nullable = false) // film/predstava
	private MovieShowType type;

	@Column(name = "ms_name", nullable = false)
	private String name;

	@Column(name = "ms_genre", nullable = false)
	private MovieShowGenre genre;

	@Column(name = "ms_description", nullable = false)
	private String description;

	@Column(name = "ms_actors", nullable = false)
	private String actors;

	@Column(name = "ms_duration", nullable = false)
	private String duration;

	@Column(name = "ms_rating", nullable = false)
	private String rating;

	@Column(name = "ms_director", nullable = false)
	private String director;

	@Column(name = "ms_poster", nullable = false)
	private String poster;

	@ManyToOne()
	@JoinColumn(name = "ms_repertoire")
	@JsonBackReference
	private Repertoire repertoire;

	@OneToMany
	private List<Projection> projections;

	@ManyToOne
	private CinemaTheatre cinemaTheatre;

	public MovieShow() {
	}

	public MovieShow(Long id, MovieShowType type, String name, MovieShowGenre genre, String description, String actors,
			String duration, String rating, String director, String poster, Repertoire repertoire,
			List<Projection> projections, CinemaTheatre cinemaTheatre) {
		super();
		this.id = id;
		this.type = type;
		this.name = name;
		this.genre = genre;
		this.description = description;
		this.actors = actors;
		this.duration = duration;
		this.rating = rating;
		this.director = director;
		this.poster = poster;
		this.repertoire = repertoire;
		this.projections = projections;
		this.cinemaTheatre = cinemaTheatre;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public MovieShowType getType() {
		return type;
	}

	public void setType(MovieShowType type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public MovieShowGenre getGenre() {
		return genre;
	}

	public void setGenre(MovieShowGenre genre) {
		this.genre = genre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getActors() {
		return actors;
	}

	public void setActors(String actors) {
		this.actors = actors;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public Repertoire getRepertoire() {
		return repertoire;
	}

	public void setRepertoire(Repertoire repertoire) {
		this.repertoire = repertoire;
	}

	public List<Projection> getProjections() {
		return projections;
	}

	public void setProjections(List<Projection> projections) {
		this.projections = projections;
	}

	public CinemaTheatre getCinemaTheatre() {
		return cinemaTheatre;
	}

	public void setCinemaTheatre(CinemaTheatre cinemaTheatre) {
		this.cinemaTheatre = cinemaTheatre;
	}

}
