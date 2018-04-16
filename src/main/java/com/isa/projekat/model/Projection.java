package com.isa.projekat.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Projection implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="prj_date", nullable = false)
	private Date date;
	
	@ManyToOne
	private MovieShow movieShow;
	
	@OneToMany
	private List<ProjectionTime> projectionTimes;
	
	public Projection() {
		// TODO Auto-generated constructor stub
	}
	
	public Projection(Long id, Date date, MovieShow movieShow, ArrayList<ProjectionTime> projectionTimes) {
		this.id = id;
		this.date = date;
		this.movieShow = movieShow;
		this.projectionTimes = projectionTimes;
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

	public MovieShow getMovieShow() {
		return movieShow;
	}

	public void setMovieShow(MovieShow movieShow) {
		this.movieShow = movieShow;
	}

	public List<ProjectionTime> getProjectionTimes() {
		return projectionTimes;
	}

	public void setProjectionTimes(List<ProjectionTime> projectionTimes) {
		this.projectionTimes = projectionTimes;
	}
	
}
