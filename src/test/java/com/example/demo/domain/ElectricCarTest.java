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

		assertEquals(1L, car.getId());
		assertEquals("Default brand", car.getBrand());
		assertEquals("Default model", car.getModel());
		assertEquals("Default color", car.getColor());
		assertEquals(4, car.getDoor());
		
		assertTrue(car.getBattery() instanceof Battery);
		assertEquals(1L, car.getBattery().getId());
		assertNotEquals(15D, car.getBattery().getCapacity());
		assertEquals(14D, car.getBattery().getCapacity());
		
		assertTrue(car.getAir() instanceof AirConditioning);
		assertEquals(1L, car.getAir().getId());
		assertEquals(24L, car.getAir().getTemperature());
		
		assertTrue(car.getPlug() instanceof Plug);
		assertEquals(1L, car.getPlug().getId());
		assertEquals(PlugType.TYPE1, car.getPlug().getPlug());
		
		assertTrue(car.getMotor() instanceof Motor);
		assertEquals(1L, car.getMotor().getId());
		assertEquals(150, car.getMotor().getPower());

	}
		
	@Test
	void testSetPlug() {
		Plug testPlug = new Plug (200L, PlugType.TYPE2);
		car.setPlug(testPlug);
		
		assertTrue(car.getPlug() instanceof Plug);
		assertEquals(200L, car.getPlug().getId());
		assertEquals(PlugType.TYPE2, car.getPlug().getPlug());
		
	}
}
