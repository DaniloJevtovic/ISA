package com.isa.projekat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isa.projekat.model.Projection;
import com.isa.projekat.model.ProjectionTime;

@Repository
public interface ProjectionTimeRepository extends JpaRepository<ProjectionTime, Long> {

	List<ProjectionTime> findByProjection(Projection projection);
}
