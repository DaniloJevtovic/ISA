package com.isa.projekat.model;

import java.util.Date;

public class ProjectionDto {

	private Long id;
	private Date date;
	private MovieShowDto movieShowDto;
	
	public ProjectionDto(Long id, Date date, MovieShowDto movieShowDto) {
		super();
		this.id = id;
		this.date = date;
		this.movieShowDto = movieShowDto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public MovieShowDto getMovieShowDto() {
		return movieShowDto;
	}

	public void setMovieShowDto(MovieShowDto movieShowDto) {
		this.movieShowDto = movieShowDto;
	}
}
