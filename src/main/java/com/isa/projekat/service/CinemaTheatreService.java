package com.isa.projekat.service;

import java.util.List;
import com.isa.projekat.model.*;

public interface CinemaTheatreService {
	
	CinemaTheatre save (CinemaTheatre cinemaTheatre);
	CinemaTheatre getOne(Long id);
	
	List<MovieShow>getMovieShows(Long ctId);
	
	List<CinemaTheatre> getAll();
	List<CinemaTheatre> getAllTheatres();
	List<CinemaTheatre> getAllCinemas();
}
