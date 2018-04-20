package com.isa.projekat.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Reservation implements Serializable {

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

	@Column
	private double price;

	@Column
	private boolean visited;

	public Reservation() {
	}

	public Reservation(User user, ProjectionTime projectionTime, List<HallSeat> hallSeats) {
		this.user = user;
		this.projectionTime = projectionTime;
		this.hallSeats = hallSeats;
		this.price = hallSeats.size() * projectionTime.getPrice();
		this.visited = false;
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

}
