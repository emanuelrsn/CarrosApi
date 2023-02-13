package com.car.models;



import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import lombok.Data;

@Entity(name="carro")
@Data
public class CarroModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String fabricante;
	private String cor;
}
