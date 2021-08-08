package com.example.demo.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo.domain.ElectricCar;
import com.example.demo.domain.HybridCar;
import com.example.demo.domain.pieces.AirConditioning;
import com.example.demo.domain.pieces.Battery;
import com.example.demo.domain.pieces.HybridMotor;
import com.example.demo.domain.pieces.HydrogenTank;

@Service
public class HybridCarServiceImpl implements HybridCarService {

	private static final Map<Long, HybridCar> cars = new HashMap<>();

	static {

		HybridCar car1 = new HybridCar(1L, "Alfa", "Romeo", "gris", 4, new Battery(1L, 14D),
				new AirConditioning(1L, 24F), new HybridMotor(1L, 150F), new HydrogenTank(1L, 80D));

		HybridCar car2 = new HybridCar(2L, "Hyundai", "i30", "verde", 4, new Battery(1L, 14D),
				new AirConditioning(1L, 19F), new HybridMotor(1L, 160F), new HydrogenTank(1L, 70D));
		car2.getMotor().start();

		HybridCar car3 = new HybridCar(3L, "Volkswagen", "Golf", "gold", 4, new Battery(1L, 14D),
				new AirConditioning(1L, 19F), new HybridMotor(1L, 160F), new HydrogenTank(1L, 70D));

		cars.put(1L, car1);
		cars.put(2L, car2);
		cars.put(3L, car3);

	}

	@Override
	public Integer count() {
		return cars.keySet().size();
	}

	@Override
	public List<HybridCar> findAll() {
		return new ArrayList<>(cars.values());
	}

	@Override
	public HybridCar findOne(Long id) {
		return cars.get(id);
	}

	@Override
	public HybridCar save(HybridCar car) {

		if (car.getId() == null || car.getId() == 0L)
			car.setId(getMaxHybridCarId() + 1);

		cars.remove(car.getId());
		cars.put(car.getId(), car);
		return car;
	}

	private Long getMaxHybridCarId() {
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
	public List<HybridCar> findByColor(String color) {
		var results = new ArrayList<HybridCar>();

		for (HybridCar car : cars.values())
			if (car.getColor().equals(color))
				results.add(car);
		return results;
	}

	@Override
	public List<HybridCar> findByDoor(int door) {
		var results = new ArrayList<HybridCar>();

		for (HybridCar car : cars.values())
			if (car.getDoor() == (door))
				results.add(car);
		return results;
	}

	@Override
	public List<HybridCar> findByBrand(String brand) {
		var results = new ArrayList<HybridCar>();

		for (HybridCar car : cars.values())
			if (car.getBrand().equals(brand))
				results.add(car);
		return results;
	}

	@Override
	public List<HybridCar> findStarted() {
		var results = new ArrayList<HybridCar>();

		for (HybridCar car : cars.values())
			if (car.getMotor().getOn())
				results.add(car);
		return results;
	}

}
