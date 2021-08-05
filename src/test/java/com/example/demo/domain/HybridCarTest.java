package com.example.demo.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.demo.domain.pieces.AirConditioning;
import com.example.demo.domain.pieces.Battery;
import com.example.demo.domain.pieces.HybridMotor;
import com.example.demo.domain.pieces.HydrogenTank;
import com.example.demo.domain.pieces.Motor;

class HybridCarTest {
	
	static Battery battery;
	static	AirConditioning air;
	static HybridMotor motor;
	static HydrogenTank tank;
	static HybridCar car;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		battery = new Battery(1L, 14D);
		air = new AirConditioning (1L, 24F);
		motor = new HybridMotor (1L, 150F);
		tank =new HydrogenTank(1L, 80D);
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		car = new HybridCar(1L, "Default brand", "Default model", "Default color", 4, battery, air, motor, tank);
		
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testToString() {
		assertEquals(car.toString(),"Car [id=1, brand=Default brand, model=Default model, color=Default color, door=4"
				+ ", battery=Battery [id=1, capacity=14.0]"
				+ ", air=AirConditioning [id=1, on=false, temperature=24.0]"
				+ ", motor=ElectricMotor [id=1, on=false, power=150.0]"
				+ ", tank=HydrogenTank [id=1, presure=80.0]]");
	}

	@Test
	void testHybridCar() {
		
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
		assertEquals(car.getAir().getTemperature(),24F);
		assertFalse(car.getAir().getOn());
		
		assertTrue(car.getTank() instanceof HydrogenTank);
		assertEquals(car.getTank().getId(),1L);
		assertEquals(car.getTank().getPresure(),80F);
		
		assertTrue(car.getMotor() instanceof Motor);
		assertEquals(car.getMotor().getId(),1L);
		assertEquals(car.getMotor().getPower(),150);
		
	}

	@Test
	void testSetTank() {
		HydrogenTank testTank = new HydrogenTank (200L, 100D);
		car.setTank(testTank);
		
		assertTrue(car.getTank() instanceof HydrogenTank);
		assertEquals(car.getTank().getId(),200L);
		assertEquals(car.getTank().getPresure(),100D);
	}

}
