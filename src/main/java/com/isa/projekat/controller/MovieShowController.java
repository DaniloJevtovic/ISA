package com.isa.projekat.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.isa.projekat.model.MovieShow;
import com.isa.projekat.model.MovieShowDto;
import com.isa.projekat.service.MovieShowService;

@RestController
@RequestMapping("/api/movieshows")
public class MovieShowController {

	@Autowired
	private MovieShowService movieShowService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<MovieShowDto>> getAllMoviesShows() {
		List<MovieShow> movieShows = movieShowService.findAll();
		List<MovieShowDto> movieShowDtos = new ArrayList<MovieShowDto>();
		for (MovieShow movieShow : movieShows) {
			movieShowDtos.add(new MovieShowDto(movieShow));
		}
		return new ResponseEntity<List<MovieShowDto>>(movieShowDtos, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<MovieShowDto> save(@RequestBody MovieShow movieShow) {
		MovieShowDto movieShowDto = new MovieShowDto(movieShowService.save(movieShow));
		return new ResponseEntity<MovieShowDto>(movieShowDto, HttpStatus.CREATED);
	}

}
