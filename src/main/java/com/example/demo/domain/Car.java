// Constructores de las piezas comunes a todos los coches con sus setter and getter para poder usarlos
// Esta será la clase padre de la herencia de CombustionCar, ElectricCar e HybridCar
package com.example.demo.domain;

import com.example.demo.domain.pieces.AirConditioning;
import com.example.demo.domain.pieces.Battery;
import com.example.demo.domain.pieces.Motor;

public abstract class Car {

	private Long id;
	private String brand;
	private String model;
	private String color;
	private int door;
	private Battery battery;
	private AirConditioning air;
	private Motor motor;
		
	
	protected Car(Long id, String brand, String model, String color, int door, Battery battery, AirConditioning air, Motor motor) {
		 this.id = id;
		 this.brand = brand;
		 this.model=model;
		 this.color = color;
		 this.door = door;
		 this.battery = battery;
		 this.air = air;
		 this.motor = motor;
	 }

	public Long getId() {
		return id;
	}

	public String getBrand() {
		return brand;
	}

	public String getModel() {
		return model;
	}

	public String getColor() {
		return color;
	}

	public Battery getBattery() {
		return battery;
	}

	public AirConditioning getAir() {
		return air;
	}

	public Motor getMotor() {
		return motor;
	}
	
	public int getDoor() {
		return door;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void setBattery(Battery battery) {
		this.battery = battery;
	}

	public void setAir(AirConditioning air) {
		this.air = air;
	}

	public void setMotor(Motor motor) {
		this.motor = motor;
	}
	
	public void setDoor(int door) {
		this.door = door;
	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", brand=" + brand + ", model=" + model + ", color=" + color + ", battery=" + battery
				+ ", air=" + air + ", motor=" + motor + ", door=" + door+"]";
	}
	 
}