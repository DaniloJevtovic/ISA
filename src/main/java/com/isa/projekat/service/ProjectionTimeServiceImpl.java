package com.isa.projekat.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.isa.projekat.model.HallSeat;
import com.isa.projekat.model.Projection;
import com.isa.projekat.model.ProjectionTime;
import com.isa.projekat.model.Reservation;
import com.isa.projekat.model.User;
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
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ, rollbackFor = Exception.class)
	public ProjectionTime save(ProjectionTime projectionTime) {
		// TODO Auto-generated method stub
		return projectionTimeRepository.save(projectionTime);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ProjectionTime> findByProjection(Long projectionId) {
		// TODO Auto-generated method stub
		Projection projection = projectionRepository.findOne(projectionId);
		return projectionTimeRepository.findByProjection(projection);
	}

	@Override
	@Transactional(readOnly = true)
	public ProjectionTime findOne(Long projectionId) {
		// TODO Auto-generated method stub
		return projectionTimeRepository.findOne(projectionId);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW, isolation=Isolation.REPEATABLE_READ, rollbackFor = Exception.class)
	public Reservation reserveSeats(Long projectiontimeId, List<String> seatinfo, Long userId) {
		// TODO Auto-generated method stub
		ProjectionTime projectionTime = projectionTimeRepository.findOne(projectiontimeId);
		Hibernate.initialize(projectionTime.getHallSeats());
		List<HallSeat> resSeats = new ArrayList<HallSeat>();
		for (int i = 0; i < seatinfo.size(); i++) {
			String arr[] = seatinfo.get(i).split("_");
			HallSeat seat = hallSeatRepository.findSeatByHallAndRowAndNumber(projectionTime.getHall(),
					Integer.parseInt(arr[0]), Integer.parseInt(arr[1]));
			resSeats.add(seat);
			projectionTime.getHallSeats().add(seat);
		}
		projectionTimeRepository.save(projectionTime);
		User user = userRepository.findOne(userId);
		Reservation reservation = new Reservation(user, projectionTime, resSeats);
		reservationRepository.save(reservation);
		Hibernate.initialize(user.getReservations());
		user.getReservations().add(reservation);
		userRepository.save(user);
		return reservation;
	}

	@Override
	@Transactional(readOnly = true)
	public List<HallSeat> getTakenSeats(Long projectiontimeId) {
		// TODO Auto-generated method stub
		ProjectionTime projectionTime = projectionTimeRepository.findOne(projectiontimeId);
		Hibernate.initialize(projectionTime.getHallSeats());
		return projectionTime.getHallSeats();
	}

}
