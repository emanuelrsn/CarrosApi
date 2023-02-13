package com.car.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.car.dtos.CarroDto;
import com.car.services.CarroService;

@RestController
@RequestMapping("/carros")
public class CarController {
	
	@Autowired
	private CarroService carroService;
	
	@PostMapping
	public ResponseEntity<CarroDto> saveCar(@RequestBody CarroDto carroDto) {
		
		return ResponseEntity.status(HttpStatus.CREATED).body(carroService.saveCar(carroDto));
		
	}
	
	@GetMapping
	public ResponseEntity<List<CarroDto>> getAll() {
		
		return ResponseEntity.status(HttpStatus.OK).body(carroService.getCars());
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CarroDto> getById(@PathVariable(value="id") Integer id) {
		
		return ResponseEntity.status(HttpStatus.OK).body(carroService.getById(id));
		
	}

}
