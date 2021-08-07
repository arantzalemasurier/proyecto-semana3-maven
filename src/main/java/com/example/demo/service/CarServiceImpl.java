package com.example.demo.service;

import java.util.HashMap;
import java.util.Map;

import com.example.demo.domain.ElectricCar;

public class CarServiceImpl {
	
	private static final Map<Long, ElectricCar> cars = new HashMap<>();
	
    public void deleteAll() {
        if (!cars.isEmpty())
            cars.clear();
    }
	

}
