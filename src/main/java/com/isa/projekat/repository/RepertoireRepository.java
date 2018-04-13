package com.isa.projekat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isa.projekat.model.Repertoire;

@Repository
public interface RepertoireRepository extends JpaRepository<Repertoire, Long> {
	
	public Repertoire findById(Long id);
	
}
