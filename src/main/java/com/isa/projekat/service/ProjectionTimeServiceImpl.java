package com.isa.projekat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isa.projekat.model.Projection;
import com.isa.projekat.model.ProjectionTime;
import com.isa.projekat.model.Reservation;
import com.isa.projekat.repository.HallSeatRepository;
import com.isa.projekat.repository.ProjectionRepository;
import com.isa.projekat.repository.ProjectionTimeRepository;
import com.isa.projekat.repository.ReservationRepository;
import com.isa.projekat.repository.UserRepository;

@Service
public class ProjectionTimeServiceImpl implements ProjectionTimeService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired 
	ProjectionRepository projectionRepository;
	
	@Autowired
	ReservationRepository reservationRepository;
	
	@Autowired
	ProjectionTimeRepository projectionTimeRepository;
	
	@Autowired 
	HallSeatRepository hallSeatRepository;
	
	
	@Override
	public ProjectionTime save(ProjectionTime projectionTime) {
		// TODO Auto-generated method stub
		return projectionTimeRepository.save(projectionTime);
	}

	@Override
	public List<ProjectionTime> findByProjection(Long projectionId) {
		// TODO Auto-generated method stub
		Projection projection = projectionRepository.findOne(projectionId);
		return projectionTimeRepository.findByProjection(projection);
	}

	@Override
	public ProjectionTime findOne(Long projectionId) {
		// TODO Auto-generated method stub
		return projectionTimeRepository.findOne(projectionId);
	}

	@Override
	public Reservation reserve() {
		// TODO Auto-generated method stub
		return null;
	}


}
