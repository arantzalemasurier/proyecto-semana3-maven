package com.example.demo.service;

import com.example.demo.domain.Car;

public class CarFactory {
	
	private static final String FUEL = "combustible";
	private static final String ELECTRIC = "electrico";
	private static final String HYBRID = "hibrido";
	
	private CarFactory() {}
	
	public static Car createByType(String type) {
		
		return switch (type) {
			case FUEL -> CarFacade.createCombustionCar();
			case ELECTRIC-> CarFacade.createElectricCar();
			case HYBRID-> CarFacade.createHybridCar();
			default-> throw new IllegalArgumentException("Unexpected value: " + type);
		};
	}
}
