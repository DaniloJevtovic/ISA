package com.isa.projekat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.isa.projekat.service.RepertoireService;

@RestController
@RequestMapping("/api/repertoire")
public class RepertoireController {

	@Autowired
	RepertoireService repertoireService;
	
	
	
}
