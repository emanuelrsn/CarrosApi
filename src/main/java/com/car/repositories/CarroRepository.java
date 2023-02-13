package com.car.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.car.models.CarroModel;

public interface CarroRepository extends JpaRepository<CarroModel, Integer> {

}
