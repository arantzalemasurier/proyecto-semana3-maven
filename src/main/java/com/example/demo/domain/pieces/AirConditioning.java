package com.example.demo.domain.pieces;

public class AirConditioning {

	private Long id;
	private Boolean on = false;
	private Float temperature;
	
	public AirConditioning(Long id, Float temperature) {
		this.id = id;
		this.temperature = temperature;
		this.on = false;
	}
	
	public void start() {
		System.out.println("Encendiendo aire acondicionado");
		this.on = true;
	}
	
	public void stop() {
		System.out.println("Apagando aire acondicionado");
		this.on = false;
	}	
	
	public Long getId() {
		return id;
	}
	
	public Boolean getOn() {
		return on;
	}
	
	public Float getTemperature() {
		return temperature;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setTemperature(Float temperature) {
		this.temperature = temperature;
	}
	@Override
	public String toString() {
		return "AirConditioning [id=" + id + ", on=" + on + ", temperature=" + temperature + "]";
	}
	
}

