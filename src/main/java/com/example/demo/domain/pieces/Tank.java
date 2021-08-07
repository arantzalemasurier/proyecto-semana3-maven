package com.example.demo.domain.pieces;


public class Tank {
	
	private Long id;
	private Double capacity;
	
	public Tank(Long id, Double capacity) {
		this.id = id;
		this.capacity = capacity;
	}
	
	public Long getId() {
		return id;
	}
	
	public Double getCapacity() {
		return capacity;
	}
	
	@Override
	public String toString() {
		return "Battery [id=" + id + ", capacity=" + capacity + "]";
	}
	
}