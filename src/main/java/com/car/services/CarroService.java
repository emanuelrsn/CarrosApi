package com.car.services;

import java.util.List;

import com.car.dtos.CarroDto;

public interface CarroService {
	
	public CarroDto saveCar(CarroDto carroDto);
	
	public List<CarroDto> getCars();
	
	public CarroDto getById(Integer id);
		
}
