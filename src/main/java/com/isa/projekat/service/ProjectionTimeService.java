package com.isa.projekat.service;

import java.util.List;

import com.isa.projekat.model.ProjectionTime;
import com.isa.projekat.model.Reservation;

public interface ProjectionTimeService {

	ProjectionTime save(ProjectionTime projectionTime);
	List<ProjectionTime> findByProjection(Long projectionId);
	ProjectionTime findOne(Long projectionId);
	Reservation reserve();
}
