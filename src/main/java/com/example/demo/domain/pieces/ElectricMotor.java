package com.example.demo.domain.pieces;

public class ElectricMotor extends Motor {
	
	private Float voltage;
	
	public ElectricMotor(Long id, Float power, Float voltage) {
		super(id, power);
		this.voltage = voltage;
	}

	public Float getVoltage() {
		return voltage;
	}

	public void setVoltage(Float voltage) {
		this.voltage = voltage;
	}

	@Override
	public String toString() {
		return "ElectricMotor [id=" + getId() + ", on=" + getOn() + ", power=" + getPower() + ", voltage=" + voltage + "]";
	}
}
