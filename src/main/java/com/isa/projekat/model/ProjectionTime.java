package com.isa.projekat.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class ProjectionTime implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	@Temporal(TemporalType.TIME)
	private Date date;
	
	@ManyToOne
	private Projection projection;
	
	@Column(nullable = false)
	private double price;
	
	@ManyToOne
	private Hall hall;
	
	@ManyToMany
	private List<HallSeat> hallSeats;
	
	public ProjectionTime() {}

	public ProjectionTime(Long id, Date date, Projection projection, double price, Hall hall,
			List<HallSeat> hallSeats) {
		super();
		this.id = id;
		this.date = date;
		this.projection = projection;
		this.price = price;
		this.hall = hall;
		this.hallSeats = hallSeats;
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

	public Projection getProjection() {
		return projection;
	}

	public void setProjection(Projection projection) {
		this.projection = projection;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Hall getHall() {
		return hall;
	}

	public void setHall(Hall hall) {
		this.hall = hall;
	}

	public List<HallSeat> getHallSeats() {
		return hallSeats;
	}

	public void setHallSeats(List<HallSeat> hallSeats) {
		this.hallSeats = hallSeats;
	}
	
}
