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

import com.isa.projekat.model.Projection;
import com.isa.projekat.model.ProjectionDto;
import com.isa.projekat.service.ProjectionService;

@RestController
@RequestMapping("/api/movieshows/{msId}/projections")
public class ProjectionController {

	@Autowired
	ProjectionService projectionService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ProjectionDto>> getProjectionsForMovieShow(@PathVariable Long msId) {
		List<Projection> projections = projectionService.getProjectionsForMovieShow(msId);
		List<ProjectionDto> projectionDtos = new ArrayList<ProjectionDto>();
		for(Projection projection : projections) {
			projectionDtos.add(new ProjectionDto(projection));
		}
		return new ResponseEntity<List<ProjectionDto>>(projectionDtos, HttpStatus.OK);
	}
	
}
