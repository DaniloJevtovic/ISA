package com.isa.projekat.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.isa.projekat.model.CinemaTheatre;
import com.isa.projekat.model.CinemaTheatreDto;
import com.isa.projekat.model.MovieShow;
import com.isa.projekat.model.MovieShowDto;
import com.isa.projekat.service.CinemaTheatreService;

@RestController
@RequestMapping("/api/cinemastheatres")
public class CinemaTheatreController {
	
	@Autowired 
	CinemaTheatreService cinemaTheatreService;

	@RequestMapping(value="/getTheaters", method = RequestMethod.GET)
	public ResponseEntity<List<CinemaTheatreDto>> getTheaters(){
		List<CinemaTheatreDto> theatersDto = new ArrayList<CinemaTheatreDto>();
		for(CinemaTheatre theater : cinemaTheatreService.getAllTheatres()){
			theatersDto.add(new CinemaTheatreDto(theater));
		}
		return new ResponseEntity<List<CinemaTheatreDto>>(theatersDto, HttpStatus.OK);
	}
	
	@RequestMapping(value="/getCinemas", method = RequestMethod.GET)
	public ResponseEntity<List<CinemaTheatreDto>> getCinemas(){
		List<CinemaTheatreDto> cinemasDto = new ArrayList<CinemaTheatreDto>();
		for(CinemaTheatre cinema : cinemaTheatreService.getAllCinemas()){
			cinemasDto.add(new CinemaTheatreDto(cinema));
		}
		return new ResponseEntity<List<CinemaTheatreDto>>(cinemasDto, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{ctId}/getMoviesShows",method = RequestMethod.GET)
	public ResponseEntity<List<MovieShowDto>> getMoviesShows(@PathVariable Long ctId){
		List<MovieShowDto> movieShowDtos = new ArrayList<MovieShowDto>();
		for(MovieShow movieShow : cinemaTheatreService.getMovieShows(ctId)){
			movieShowDtos.add(new MovieShowDto(movieShow));
		}
		return new ResponseEntity<List<MovieShowDto>>(movieShowDtos,HttpStatus.OK);
	}
	
}
