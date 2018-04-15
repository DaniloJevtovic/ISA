package com.isa.projekat.model;

public class MovieShowDto {
	
	private Long id;
	private MovieShowType type;
	private String name;
	private MovieShowGenre genre;
	private String description;
	private String actors;
	private String duration;
	private String rating;
	private String director;
	private String poster;
	
	public MovieShowDto(MovieShow movieShow) {
		this.id = movieShow.getId();
		this.type = movieShow.getType();
		this.name = movieShow.getName();
		this.genre = movieShow.getGenre();
		this.description = movieShow.getDescription();
		this.actors = movieShow.getActors();
		this.duration = movieShow.getDuration();
		this.rating = movieShow.getRating();
		this.director = movieShow.getDirector();
		this.poster = movieShow.getPoster();
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

}
