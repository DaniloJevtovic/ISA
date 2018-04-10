package com.isa.projekat.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MovieShow implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="ms_name", nullable = false)
	private String name;
	
	@Column(name="ms_genre", nullable = false)
	private MovieShowGenre genre;
	
	@Column(name="ms_description", nullable = false)
	private String description;
		
	@Column(name="ms_actors", nullable = false)
	private String actors;
	
	@Column(name="ms_duration", nullable = false)
	private String duration;
	
	@Column(name="ms_rating", nullable = false)
	private String rating;
	
	@Column(name="ms_director", nullable = false)
	private String director;
	
	@Column(name="ms_poster", nullable = false)
	private String poster;
	
	public MovieShow() {
		// TODO Auto-generated constructor stub
	}
	
	public MovieShow(Long id, String name, MovieShowGenre genre, String description, String actors, String duration,
			String rating, String director, String poster) {
		super();
		this.id = id;
		this.name = name;
		this.genre = genre;
		this.description = description;
		this.actors = actors;
		this.duration = duration;
		this.rating = rating;
		this.director = director;
		this.poster = poster;
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

}
