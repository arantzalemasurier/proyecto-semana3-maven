package com.example.demo.domain;

import com.example.demo.domain.pieces.AirConditioning;
import com.example.demo.domain.pieces.Battery;
import com.example.demo.domain.pieces.CombustionMotor;
import com.example.demo.domain.pieces.Tank;

public class CombustionCar extends Car {

	private Tank tank;
	
	public CombustionCar(Long id, String brand, String model, String color, int door, Battery battery, AirConditioning air, CombustionMotor motor, Tank tank) {
		super(id, brand, model, color, door, battery, air, motor);
		this.tank = tank;
	}

	public Tank getTank() {
		return tank;
	}

	public void setTank(Tank tank) {
		this.tank = tank;
	}
	
	@Override
	public String toString() {
		return "Car [id=" + getId() + ", brand=" + getBrand() + ", model=" + getModel() + ", color=" + getColor() + ", door=" + getDoor() +", battery=" + getBattery()
				+ ", air=" + getAir() + ", motor=" + getMotor() + ", tank=" + tank + "]";
	}
	 
}
