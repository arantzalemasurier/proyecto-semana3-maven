package com.example.demo.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.demo.domain.pieces.AirConditioning;
import com.example.demo.domain.pieces.Battery;
import com.example.demo.domain.pieces.ElectricMotor;
import com.example.demo.domain.pieces.Motor;
import com.example.demo.domain.pieces.Plug;
import com.example.demo.domain.pieces.PlugType;

class ElectricCarTest {
	
	static Battery battery;
	static	AirConditioning air;
	static ElectricMotor motor;
	static Plug plug;
	static ElectricCar car;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		battery = new Battery(1L, 14D);
		air = new AirConditioning (1L, 24F);
		motor = new ElectricMotor (1L, 150F, 400F);
		plug = new Plug (1L, PlugType.TYPE1);
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		
	}

	@BeforeEach
	void setUp() throws Exception {
		car = new ElectricCar(1L, "Default brand", "Default model", "Default color", 4, battery, air, motor, plug);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testToString() {
		assertEquals(car.toString(),"Car [id=1, brand=Default brand, model=Default model, color=Default color, door=4"
				+ ", battery=Battery [id=1, capacity=14.0]"
				+ ", air=AirConditioning [id=1, on=false, temperature=24.0]"
				+ ", motor=ElectricMotor [id=1, on=false, power=150.0, voltage=400.0]"
				+ ", plug=Plug [id=1, plug=TYPE1]]");
	}

	@Test
	void testElectricCar() {

		assertEquals(car.getId(),1L);
		assertEquals(car.getBrand(),"Default brand");
		assertEquals(car.getModel(),"Default model");
		assertEquals(car.getColor(),"Default color");
		assertEquals(car.getDoor(),4);
		
		assertTrue(car.getBattery() instanceof Battery);
		assertEquals(car.getBattery().getId(),1L);
		assertNotEquals(car.getBattery().getCapacity(),15D);
		assertEquals(car.getBattery().getCapacity(),14D);
		
		assertTrue(car.getAir() instanceof AirConditioning);
		assertEquals(car.getAir().getId(),1L);
		assertEquals(car.getAir().getTemperature(),24L);
		
		assertTrue(car.getPlug() instanceof Plug);
		assertEquals(car.getPlug().getId(),1L);
		assertEquals(car.getPlug().getPlug(),PlugType.TYPE1);
		
		assertTrue(car.getMotor() instanceof Motor);
		assertEquals(car.getMotor().getId(),1L);
		assertEquals(car.getMotor().getPower(),150);

	}
		
	@Test
	void testSetPlug() {
		Plug testPlug = new Plug (200L, PlugType.TYPE2);
		car.setPlug(testPlug);
		
		assertTrue(car.getPlug() instanceof Plug);
		assertEquals(car.getPlug().getId(),200L);
		assertEquals(car.getPlug().getPlug(),PlugType.TYPE2);
		
	}
}
