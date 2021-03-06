package com.example.demo.service;

import com.example.demo.domain.Car;
import com.example.demo.domain.CombustionCar;
import com.example.demo.domain.ElectricCar;
import com.example.demo.domain.HybridCar;
import com.example.demo.domain.pieces.AirConditioning;
import com.example.demo.domain.pieces.Battery;
import com.example.demo.domain.pieces.CombustionMotor;
import com.example.demo.domain.pieces.ElectricMotor;
import com.example.demo.domain.pieces.FuelType;
import com.example.demo.domain.pieces.HybridMotor; 
import com.example.demo.domain.pieces.HydrogenTank;
import com.example.demo.domain.pieces.ElectricPlug;
import com.example.demo.domain.pieces.PlugType;
import com.example.demo.domain.pieces.Tank;

public class CarFacade {
	
	public static final String DEFAULT_BRAND = "Default brand";
	public static final String DEFAULT_MODEL = "Default model";
	public static final String DEFAULT_COLOR = "Default color";

	private CarFacade() {}
	
	public static Car createCombustionCar() {
		
		Battery battery = new Battery(1L, 14D);
		AirConditioning air = new AirConditioning (1L, 24F);
		CombustionMotor motor = new CombustionMotor (1L, 150F, FuelType.PETROL, 1000F);
		Tank tank = new Tank (1L, 60D);
		
		CombustionCar car = new CombustionCar(1L, DEFAULT_BRAND, DEFAULT_MODEL, DEFAULT_COLOR, 4, battery, air, motor, tank);
		car.getMotor().start();
		car.getAir().start();
		
		return car;
	}
	
	public static Car createElectricCar() {
		Battery battery = new Battery(1L, 14D);
		AirConditioning air = new AirConditioning (1L, 24F);
		ElectricMotor motor = new ElectricMotor (1L, 150F, 400F);
		ElectricPlug plug = new ElectricPlug (1L, PlugType.TYPE1);
		
		ElectricCar car = new ElectricCar(1L, DEFAULT_BRAND, DEFAULT_MODEL, DEFAULT_COLOR, 4, battery, air, motor, plug);
		car.getMotor().start();
		car.getAir().start();
		
		return car;		
	}
	
	public static Car createHybridCar() {
		Battery battery = new Battery(1L, 14D);
		AirConditioning air = new AirConditioning (1L, 24F);
		HybridMotor motor = new HybridMotor (1L, 150F);
		HydrogenTank tank = new HydrogenTank (1L, 80D);
	
		HybridCar car = new HybridCar(1L, DEFAULT_BRAND, DEFAULT_MODEL, DEFAULT_COLOR, 4, battery, air, motor, tank);
		car.getMotor().start();
		car.getAir().start();
		
		return car;		
	
	}
}