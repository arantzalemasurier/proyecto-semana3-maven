package com.example.demo.domain;

import com.example.demo.domain.pieces.AirConditioning;
import com.example.demo.domain.pieces.Battery;
import com.example.demo.domain.pieces.HybridMotor;
import com.example.demo.domain.pieces.HydrogenTank;


public class HybridCar extends Car {

	private HydrogenTank tank;
	
	public HybridCar(Long id, String brand, String model, String color, int door, Battery battery, AirConditioning air, HybridMotor motor, HydrogenTank tank) {
		super(id, brand, model, color, door, battery, air, motor);
		this.tank = tank;
	}

	public HydrogenTank getTank() {
		return tank;
	}

	public void setTank(HydrogenTank tank) {
		this.tank = tank;
	}
	
	@Override
	public String toString() {
		return "Car [id=" + getId() + ", brand=" + getBrand() + ", model=" + getModel() + ", color=" + getColor() + ", door=" + getDoor() + ", battery=" + getBattery()
		+ ", air=" + getAir() + ", motor=" + getMotor() + ", tank=" + tank + "]";
	}
	 
}
