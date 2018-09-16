package com.isa.projekat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isa.projekat.model.MovieShow;
import com.isa.projekat.repository.MovieShowRepository;

@Service
public class MovieShowServiceImpl implements MovieShowService {

	@Autowired
	MovieShowRepository msRepository;

	@Override
	public List<MovieShow> findAll() {
		// TODO Auto-generated method stub
		return msRepository.findAll();
	}

	@Override
	public MovieShow save(MovieShow movieShow) {
		// TODO Auto-generated method stub
		return msRepository.save(movieShow);
	}

}
