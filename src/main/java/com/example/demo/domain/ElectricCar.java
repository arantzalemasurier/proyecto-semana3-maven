package com.example.demo.domain;

import com.example.demo.domain.pieces.AirConditioning;
import com.example.demo.domain.pieces.Battery;
import com.example.demo.domain.pieces.ElectricMotor;
import com.example.demo.domain.pieces.ElectricPlug;

public class ElectricCar extends Car {

	private ElectricPlug plug;
	
	public ElectricCar(Long id, String brand, String model, String color, int door, Battery battery, AirConditioning air, ElectricMotor motor, ElectricPlug plug) {
		super(id, brand, model, color, door, battery, air, motor);
		this.plug = plug;
	}
	
	public ElectricPlug getPlug() {
		return plug;
	}

	public void setPlug(ElectricPlug plug) {
		this.plug = plug;
	}
	
	@Override
	public String toString() {
		return "Car [id=" + getId() + ", brand=" + getBrand() + ", model=" + getModel() + ", color=" + getColor() + ", door=" + getDoor() + ", battery=" + getBattery()
				+ ", air=" + getAir() + ", motor=" + getMotor() + ", plug=" + plug + "]";
	}
	 
}
