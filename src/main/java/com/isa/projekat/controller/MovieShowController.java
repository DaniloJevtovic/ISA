package com.isa.projekat.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.isa.projekat.model.MovieShow;
import com.isa.projekat.service.MovieShowService;

@RestController
@RequestMapping("/api/movieshows")
public class MovieShowController {

	@Autowired
	private MovieShowService movieShowService;
	
	@RequestMapping(
			value = "/getMovies",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<MovieShow>> getMovies(){
		
		return new ResponseEntity<Collection<MovieShow>>(movieShowService.findAll(), HttpStatus.OK);
		
	}

}
