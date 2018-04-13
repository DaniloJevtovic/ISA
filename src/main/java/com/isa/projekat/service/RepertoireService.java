package com.isa.projekat.service;

import com.isa.projekat.model.Repertoire;

public interface RepertoireService {
	
	Repertoire getById(Long id);
	Repertoire save(Repertoire repertoire);
}
