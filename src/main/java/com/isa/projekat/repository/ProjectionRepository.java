package com.isa.projekat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isa.projekat.model.MovieShow;
import com.isa.projekat.model.Projection;

@Repository
public interface ProjectionRepository extends JpaRepository<Projection, Long> {

	List<Projection> findByMovieShow(MovieShow movieShow);
	
}
