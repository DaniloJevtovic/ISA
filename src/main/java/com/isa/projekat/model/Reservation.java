package com.isa.projekat.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Reservation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	private User user;
	
	@ManyToOne
	private ProjectionTime projectionTime;
	
	@ManyToMany
	private List<HallSeat> hallSeats;
	
	public Reservation() {}

	public Reservation(Long id, User user, ProjectionTime projectionTime) {
		super();
		this.id = id;
		this.user = user;
		this.projectionTime = projectionTime;
		this.hallSeats = new ArrayList<HallSeat>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public ProjectionTime getProjectionTime() {
		return projectionTime;
	}

	public void setProjectionTime(ProjectionTime projectionTime) {
		this.projectionTime = projectionTime;
	}

	public List<HallSeat> getHallSeats() {
		return hallSeats;
	}

	public void setHallSeats(List<HallSeat> hallSeats) {
		this.hallSeats = hallSeats;
	}
	
	
}
