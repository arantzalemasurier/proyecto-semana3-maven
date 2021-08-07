package com.example.demo.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo.domain.ElectricCar;
import com.example.demo.domain.pieces.AirConditioning;
import com.example.demo.domain.pieces.Battery;
import com.example.demo.domain.pieces.ElectricMotor;
import com.example.demo.domain.pieces.Plug;
import com.example.demo.domain.pieces.PlugType;

@Service
public class ElectricCarServiceImpl implements ElectricCarService {

	private static final Map<Long, ElectricCar> cars = new HashMap<>();
	CarServiceImpl service = new CarServiceImpl();

	static {

		ElectricCar car1 = new ElectricCar(1L, "Seat", "León", "blanco", 4, new Battery(1L, 14D),
				new AirConditioning(1L, 24F), new ElectricMotor(1L, 150F, 400F), new Plug(1L, PlugType.TYPE1));

		ElectricCar car2 = new ElectricCar(2L, "BMW", "X3i", "negro", 2, new Battery(1L, 18D),
				new AirConditioning(1L, 22F), new ElectricMotor(1L, 180F, 400F), new Plug(1L, PlugType.TYPE2));
		car2.getMotor().start();

		ElectricCar car3 = new ElectricCar(3L, "Skoda", "Octavia", "marrón", 4, new Battery(1L, 18D),
				new AirConditioning(1L, 20F), new ElectricMotor(1L, 150F, 400F), new Plug(1L, PlugType.CCS));

		cars.put(1L, car1);
		cars.put(2L, car2);
		cars.put(3L, car3);

	}

	@Override
	public Integer count() {
		return cars.keySet().size();
	}

	@Override
	public List<ElectricCar> findAll() {
		return new ArrayList<>(cars.values());
	}

	@Override
	public ElectricCar findOne(Long id) {
		return cars.get(id);
	}

	@Override
	public ElectricCar save(ElectricCar car) {

		if (car.getId() == null || car.getId() == 0L)
			car.setId(getMaxElectricCarId() + 1);

		cars.remove(car.getId());
		cars.put(car.getId(), car);
		return car;
	}

	public Long getMaxElectricCarId() {
    	if (cars.isEmpty()) {
			return 0L;
    	}

		return Collections.max(cars.entrySet(),(entry1,entry2)->(int)(entry1.getKey()-entry2.getKey())).getKey();
	}

	@Override
    public boolean delete(Long id) {
        if (id == null || !cars.containsKey(id))
            return false;
        cars.remove(id);
        return true;
    }

	@Override
    public List<ElectricCar> findByColor(String color) {
    	List<ElectricCar> results = new ArrayList<ElectricCar>();
    	
    	for (ElectricCar car: cars.values())
    		if (car.getColor().equals(color))
    				results.add(car);
    	return results;
    }

	@Override
    public List<ElectricCar> findByDoor(int door) {
    	List<ElectricCar> results = new ArrayList<ElectricCar>();
    	
    	for (ElectricCar car: cars.values())
    		if (car.getDoor()==(door))
    				results.add(car);
    	return results;
    }

	@Override
    public List<ElectricCar> findByBrand(String brand) {
    	List<ElectricCar> results = new ArrayList<ElectricCar>();
    	
    	for (ElectricCar car: cars.values())
    		if (car.getBrand().equals(brand))
    				results.add(car);
    	return results;
    }

	@Override
    public List<ElectricCar> findStarted() {
    	List<ElectricCar> results = new ArrayList<ElectricCar>();
    	
    	for (ElectricCar car: cars.values())
    		if (car.getMotor().getOn())
    				results.add(car);
    	return results;

	}

}
