package com.isa.projekat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isa.projekat.model.MovieShow;
import com.isa.projekat.model.MovieShowGenre;
import com.isa.projekat.model.MovieShowType;

@Repository
public interface MovieShowRepository extends JpaRepository<MovieShow, Long> {

	public MovieShow findById(Long id);
	public List<MovieShow> findByType(MovieShowType msType);
	public List<MovieShow> findByGenre(MovieShowGenre msGenre);	
}
