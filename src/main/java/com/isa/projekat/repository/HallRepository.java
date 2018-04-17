package com.isa.projekat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isa.projekat.model.Hall;

@Repository
public interface HallRepository extends JpaRepository<Hall, Long> {

}
