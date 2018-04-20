package com.isa.projekat.service;

import java.util.List;

import com.isa.projekat.model.HallSeat;

public interface HallSeatService {

	HallSeat save(HallSeat hallSeat);

	List<HallSeat> findByHall(Long hLong);

	HallSeat findByHallAndRowAndNumber(Long hallId, int row, int number);

}
