package com.example.demo.domain.pieces;

public class CombustionMotor extends Motor {

	private FuelType fuel;
	private Float cc;
	
	public CombustionMotor(Long id, Float power, FuelType fuel, Float cc) {
		super(id, power);
		this.fuel = fuel;
		this.cc = cc;
	}

	public FuelType getFuel() {
		return fuel;
	}

	public Float getCC() {
		return cc;
	}

	public void setFuel(FuelType fuel) {
		this.fuel = fuel;
	}

	public void setCC(Float cc) {
		this.cc = cc;
	}

	@Override
	public String toString() {
		return "CombustionMotor [id=" + getId() + ", on=" + getOn() + ", power=" + getPower() +", fuel=" + fuel + ", cc=" + cc + "]";
	}
}
