package com.isa.projekat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isa.projekat.model.Hall;
import com.isa.projekat.model.HallSeat;

@Repository
public interface HallSeatRepository extends JpaRepository<HallSeat, Long> {

	List<HallSeat> findSeatByHall(Hall hall);

	HallSeat findSeatByHallAndRowAndNumber(Hall hall, int row, int number);

}
