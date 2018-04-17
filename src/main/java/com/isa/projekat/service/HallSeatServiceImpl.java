package com.isa.projekat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isa.projekat.model.Hall;
import com.isa.projekat.model.HallSeat;
import com.isa.projekat.repository.HallRepository;
import com.isa.projekat.repository.HallSeatRepository;

@Service
public class HallSeatServiceImpl implements HallSeatService {

	@Autowired
	private HallRepository hallRepository;
	
	@Autowired
	private HallSeatRepository hallSeatRepository;
	
	@Override
	public HallSeat save(HallSeat hallSeat) {
		// TODO Auto-generated method stub
		return hallSeatRepository.save(hallSeat);
	}

	@Override
	public List<HallSeat> findByHall(Long hLong) {
		// TODO Auto-generated method stub
		Hall hall = hallRepository.findOne(hLong);
		return hallSeatRepository.findSeatByHall(hall);
	}

}
