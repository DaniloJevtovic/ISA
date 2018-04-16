package com.isa.projekat.model;

import java.sql.Date;

public class ProjectionTimeDto {

	private Long id;
	private Date date;
	private double price;
	private HallDto hallDto;
	
	public ProjectionTimeDto(ProjectionTime projectionTime) {
		super();
		this.id = projectionTime.getId();
		this.date = (Date) projectionTime.getDate();
		this.price = projectionTime.getPrice();
		this.hallDto = new HallDto(projectionTime.getHall());
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public HallDto getHallDto() {
		return hallDto;
	}

	public void setHallDto(HallDto hallDto) {
		this.hallDto = hallDto;
	}
	
}
