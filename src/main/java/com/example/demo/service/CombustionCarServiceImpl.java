package com.example.demo.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo.domain.CombustionCar;
import com.example.demo.domain.pieces.AirConditioning;
import com.example.demo.domain.pieces.Battery;
import com.example.demo.domain.pieces.CombustionMotor;
import com.example.demo.domain.pieces.FuelType;
import com.example.demo.domain.pieces.Tank;

@Service
public class CombustionCarServiceImpl implements CombustionCarService {

	protected static final Map<Long, CombustionCar> cars = new HashMap<>();

	static {

		CombustionCar car1 = new CombustionCar(1L, "Seat", "Ibiza", "rojo", 2, new Battery(1L, 14D),
				new AirConditioning(1L, 24F), new CombustionMotor(1L, 150F, FuelType.PETROL, 1000F), new Tank(1L, 60D));

		CombustionCar car2 = new CombustionCar(2L, "Audi", "A3", "negro", 4, new Battery(1L, 16D),
				new AirConditioning(1L, 26F), new CombustionMotor(1L, 180F, FuelType.DIESEL, 1000F), new Tank(1L, 80D));
		car2.getMotor().start();

		CombustionCar car3 = new CombustionCar(3L, "Toyota", "Auris", "blanco", 4, new Battery(1L, 16D),
				new AirConditioning(1L, 26F), new CombustionMotor(1L, 180F, FuelType.DIESEL, 1000F), new Tank(1L, 80D));
		car3.getMotor().start();

		cars.put(1L, car1);
		cars.put(2L, car2);
		cars.put(3L, car3);

	}

	@Override
	public Integer count() {
		return cars.keySet().size();
	}

	@Override
	public List<CombustionCar> findAll() {
		return new ArrayList<>(cars.values());
	}

	@Override
	public CombustionCar findOne(Long id) {
		return cars.get(id);
	}

	@Override
	public CombustionCar save(CombustionCar car) {

		if (car.getId() == null || car.getId() == 0L)
			car.setId(getMaxCombustionCarId() + 1);

		cars.remove(car.getId());
		cars.put(car.getId(), car);
		return car;
	}

	private Long getMaxCombustionCarId() {
		if (cars.isEmpty()) {
			return 0L;
		}
			
		return Collections.max(cars.entrySet(), (entry1, entry2) -> (int) (entry1.getKey() - entry2.getKey())).getKey();
	}

	@Override
	public boolean delete(Long id) {
		if (id == null || !cars.containsKey(id))
			return false;
		cars.remove(id);
		return true;
	}
	
    @Override
    public void deleteAll() {
        if (!cars.isEmpty())
            cars.clear();
    }

    @Override
	public List<CombustionCar> findByColor(String color) {
		var results = new ArrayList<CombustionCar>();

		for (CombustionCar car : cars.values())
			if (car.getColor().equals(color))
				results.add(car);
		return results;
	}

	@Override
	public List<CombustionCar> findByDoor(int door) {
		var results = new ArrayList<CombustionCar>();

		for (CombustionCar car : cars.values())
			if (car.getDoor() == (door))
				results.add(car);
		return results;
	}

	@Override
	public List<CombustionCar> findByBrand(String brand) {
		var results = new ArrayList<CombustionCar>();

		for (CombustionCar car : cars.values())
			if (car.getBrand().equals(brand))
				results.add(car);
		return results;
	}

	@Override
	public List<CombustionCar> findStarted() {
		var results = new ArrayList<CombustionCar>();

		for (CombustionCar car : cars.values())
			if (car.getMotor().getOn() != null && car.getMotor().getOn()) {
				
				Boolean.TRUE.equals(car.getMotor().getOn());	
				results.add(car);
			}
		return results;
	}
}
