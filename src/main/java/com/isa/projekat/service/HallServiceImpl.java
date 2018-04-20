package com.isa.projekat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isa.projekat.model.Hall;
import com.isa.projekat.repository.HallRepository;

@Service
public class HallServiceImpl implements HallService {

	@Autowired
	private HallRepository hallRepository;

	@Override
	public Hall save(Hall hall) {
		// TODO Auto-generated method stub
		return hallRepository.save(hall);
	}

}
