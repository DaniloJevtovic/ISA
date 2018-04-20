package com.isa.projekat.service;

import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.isa.projekat.model.CinemaTheatre;
import com.isa.projekat.model.CinemaTheatreType;
import com.isa.projekat.model.MovieShow;
import com.isa.projekat.repository.CinemaTheatreRepository;

@Service
@Transactional
public class CinemaTheatreServiceImpl implements CinemaTheatreService {

	@Autowired
	private CinemaTheatreRepository ctRepository;

	@Override
	public CinemaTheatre save(CinemaTheatre cinemaTheatre) {
		// TODO Auto-generated method stub
		return ctRepository.save(cinemaTheatre);
	}

	@Override
	public CinemaTheatre getOne(Long id) {
		// TODO Auto-generated method stub
		return ctRepository.getOne(id);
	}

	@Override
	public List<CinemaTheatre> getAll() {
		// TODO Auto-generated method stub
		return ctRepository.findAll();
	}

	@Override
	public List<CinemaTheatre> getAllTheatres() {
		// TODO Auto-generated method stub
		return ctRepository.findByType(CinemaTheatreType.THEATRE);
	}

	@Override
	public List<CinemaTheatre> getAllCinemas() {
		// TODO Auto-generated method stub
		return ctRepository.findByType(CinemaTheatreType.CINEMA);
	}

	@Override
	public List<MovieShow> getMovieShows(Long ctId) {
		// TODO Auto-generated method stub
		CinemaTheatre cinemaTheatre = ctRepository.findOne(ctId);
		Hibernate.initialize(cinemaTheatre.getMovieShows());
		return cinemaTheatre.getMovieShows();
	}

}
