package com.car.services.impl;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.car.dtos.CarroDto;
import com.car.models.CarroModel;
import com.car.repositories.CarroRepository;
import com.car.services.CarroService;

@Service
public class CarroServiceImpl implements CarroService {

	@Autowired
	private CarroRepository carroRepository;
	
	
	@Override
	public CarroDto saveCar(CarroDto carroDto) {
		
		CarroModel carroModel = new CarroModel();
		carroModel.setCor(carroDto.getCor());
		carroModel.setFabricante(carroDto.getFabricante());
		
		return toCarroDto(carroRepository.save(carroModel));
		
	}

	@Override
	public List<CarroDto> getCars() {
		return carroRepository.findAll().stream().map(this::toCarroDto).collect(Collectors.toList());
		
	}
	
	@Override
	public CarroDto getById(Integer id) {
		var carroOptional = carroRepository.findById(id);
		if(carroOptional.isPresent())
			return toCarroDto(carroOptional.get());
		return null;
	}
	
	private CarroDto toCarroDto(CarroModel carroModel) {
		CarroDto carroDto = new CarroDto();
		carroDto.setCor(carroModel.getCor());
		carroDto.setFabricante(carroModel.getFabricante());
		carroDto.setId(carroModel.getId());
		return carroDto;
	}

	

}
