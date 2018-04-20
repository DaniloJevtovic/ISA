package com.isa.projekat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isa.projekat.model.MovieShow;
import com.isa.projekat.model.Projection;
import com.isa.projekat.repository.MovieShowRepository;
import com.isa.projekat.repository.ProjectionRepository;

@Service
public class ProjectionServiceImpl implements ProjectionService {

	@Autowired
	ProjectionRepository projectinRepository;

	@Autowired
	MovieShowRepository movieShowRepository;

	@Override
	public Projection save(Projection projection) {
		// TODO Auto-generated method stub
		return projectinRepository.save(projection);
	}

	@Override
	public List<Projection> getProjectionsForMovieShow(Long msId) {
		// TODO Auto-generated method stub
		MovieShow movieShow = movieShowRepository.findOne(msId);
		return projectinRepository.findByMovieShow(movieShow);
	}

}
