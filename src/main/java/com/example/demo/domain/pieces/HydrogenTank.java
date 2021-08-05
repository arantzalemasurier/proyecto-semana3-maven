package com.example.demo.domain.pieces;

public class HydrogenTank {
	
	private Long id;
	private Double presure;
	
	public HydrogenTank(Long id, Double presure) {
		this.id = id;
		this.presure = presure;
	}
	public Long getId() {
		return id;
	}
	public Double getPresure() {
		return presure;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setPresure(Double presure) {
		this.presure = presure;
	}
	@Override
	public String toString() {
		return "HydrogenTank [id=" + id + ", presure=" + presure + "]";
	}
	
}
