package com.example.demo.domain.pieces;

public class Motor {
	
	private Long id;
	private Boolean on = false;
	private Float power;
	
	public Motor(Long id, Float power) {
		this.id = id;
		this.power = power;
		this.on = false;
	}
	
	public void start() {
		System.out.println("Encendiendo Motor");
		this.on = true;
	}
	
	public void stop() {
		System.out.println("Apagando Motor");
		this.on = false;
	}	
	
	public Long getId() {
		return id;
	}
	
	public Boolean getOn() {
		return on;
	}
	
	public Float getPower() {
		return power;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setPower(Float power) {
		this.power = power;
	}
	@Override
	public String toString() {
		return "Motor [id=" + id + ", on=" + on + ", power=" + power + "]";
	}
	
}
