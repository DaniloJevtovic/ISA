package com.isa.projekat.service;

import java.util.List;

import com.isa.projekat.model.Projection;

public interface ProjectionService {
	
	Projection save (Projection projection);
	List<Projection> getProjectionsForMovieShow(Long msId);
}
