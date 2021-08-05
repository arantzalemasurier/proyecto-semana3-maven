package com.example.demo.domain;

import com.example.demo.domain.pieces.AirConditioning;
import com.example.demo.domain.pieces.Battery;
import com.example.demo.domain.pieces.ElectricMotor;
import com.example.demo.domain.pieces.Plug;

public class ElectricCar extends Car {

	private Plug plug;
	
	public ElectricCar(Long id, String brand, String model, String color, int door, Battery battery, AirConditioning air, ElectricMotor motor, Plug plug) {
		super(id, brand, model, color, door, battery, air, motor);
		this.plug = plug;
	}
	
	public Plug getPlug() {
		return plug;
	}

	public void setPlug(Plug plug) {
		this.plug = plug;
	}
	
	@Override
	public String toString() {
		return "Car [id=" + getId() + ", brand=" + getBrand() + ", model=" + getModel() + ", color=" + getColor() + ", door=" + getDoor() + ", battery=" + getBattery()
				+ ", air=" + getAir() + ", motor=" + getMotor() + ", plug=" + plug + "]";
	}
	 
}
