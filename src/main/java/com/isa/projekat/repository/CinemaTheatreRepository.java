package com.isa.projekat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isa.projekat.model.CinemaTheatre;
import com.isa.projekat.model.CinemaTheatreType;

@Repository
public interface CinemaTheatreRepository extends JpaRepository<CinemaTheatre, Long> {
	
	//public CinemaTheatre findById(Long id);
	public List<CinemaTheatre> findByType(CinemaTheatreType type);
	
}
