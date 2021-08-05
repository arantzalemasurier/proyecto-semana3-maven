package com.example.demo.domain.pieces;

public class HybridMotor extends Motor {
	
	public HybridMotor(Long id, Float power) {
		super(id, power);
	}

	@Override
	public String toString() {
		return "ElectricMotor [id=" + getId() + ", on=" + getOn() + ", power=" + getPower() + "]";
	}
}
