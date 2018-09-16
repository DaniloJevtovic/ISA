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
import javax.persistence.Version;

@Entity
public class ProjectionTime implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "pt_time", nullable = false)
	@Temporal(TemporalType.TIME)
	private Date time;

	@Column(name = "pt_price", nullable = false)
	private double price;

	@ManyToOne
	private Projection projection;

	@ManyToOne
	private Hall hall;

	@ManyToMany
	private List<HallSeat> hallSeats;
	
	/*
	@Version
	@Column(name = "VERSION")
	private Long version;
	*/
	
	public ProjectionTime() {
	}

	public ProjectionTime(Long id, Date time, double price, Projection projection, Hall hall,
			List<HallSeat> hallSeats) {
		super();
		this.id = id;
		this.time = time;
		this.price = price;
		this.projection = projection;
		this.hall = hall;
		this.hallSeats = hallSeats;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Projection getProjection() {
		return projection;
	}

	public void setProjection(Projection projection) {
		this.projection = projection;
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

	
	/*
	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}
	*/
}
