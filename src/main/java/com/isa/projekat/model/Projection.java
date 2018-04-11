package com.isa.projekat.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
	private Hall hall;
	
	@Column(name="prj_price",nullable = false)
	private double price;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private MovieShow movieShow;
	
	@OneToMany
	private List<HallSeat> seats;
	

}
