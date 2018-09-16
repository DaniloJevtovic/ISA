package com.isa.projekat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isa.projekat.model.Repertoire;
import com.isa.projekat.repository.RepertoireRepository;

@Service
public class RepertoireServiceImpl implements RepertoireService {

	@Autowired
	RepertoireRepository repRepository;
	
	@Override
	public Repertoire getById(Long id) {
		// TODO Auto-generated method stub
		return repRepository.findById(id);
	}

	@Override
	public Repertoire save(Repertoire repertoire) {
		// TODO Auto-generated method stub
		return repRepository.save(repertoire);
	}

}
