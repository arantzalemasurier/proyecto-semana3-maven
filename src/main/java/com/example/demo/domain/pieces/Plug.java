package com.example.demo.domain.pieces;

public class Plug {
	
	private Long id;
	private PlugType plug;
	
	public Plug(Long id, PlugType plug) {
		this.id = id;
		this.plug = plug;
	}

	public Long getId() {
		return id;
	}

	public PlugType getPlug() {
		return plug;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setPlug(PlugType plug) {
		this.plug = plug;
	}

	@Override
	public String toString() {
		return "Plug [id=" + id + ", plug=" + plug + "]";
	}
	
}	