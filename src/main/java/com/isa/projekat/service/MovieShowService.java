package com.isa.projekat.service;

import java.util.List;

import com.isa.projekat.model.MovieShow;

public interface MovieShowService {
	
	List<MovieShow> findAll();
	MovieShow save(MovieShow movieShow);
}
