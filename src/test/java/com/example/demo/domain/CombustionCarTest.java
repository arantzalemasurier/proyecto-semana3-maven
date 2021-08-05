package com.example.demo.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.demo.domain.pieces.AirConditioning;
import com.example.demo.domain.pieces.Battery;
import com.example.demo.domain.pieces.CombustionMotor;
import com.example.demo.domain.pieces.FuelType;
import com.example.demo.domain.pieces.Motor;
import com.example.demo.domain.pieces.Tank;

class CombustionCarTest {

	static Battery battery;
	static	AirConditioning air;
	static CombustionMotor motor;
	static Tank tank;
	static CombustionCar car;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		battery = new Battery(1L, 14D);
		air = new AirConditioning (1L, 24F);
		motor = new CombustionMotor (1L, 150F, FuelType.PETROL, 1000F);
		tank = new Tank (1L, 60D);
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		car = new CombustionCar(1L, "Default brand", "Default model", "Default color", 4, battery, air, motor, tank);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testToString() {
		assertEquals(car.toString(),"Car [id=1, brand=Default brand, model=Default model, color=Default color, door=4"
				+ ", battery=Battery [id=1, capacity=14.0]"
				+ ", air=AirConditioning [id=1, on=false, temperature=24.0]"
				+ ", motor=CombustionMotor [id=1, on=false, power=150.0, fuel=PETROL, cc=1000.0]"
				+ ", tank=Battery [id=1, capacity=60.0]]");
	}

	@Test
	void testCombustionCar() {
		
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
			
			assertTrue(car.getTank() instanceof Tank);
			assertEquals(car.getTank().getId(),1L);
			assertEquals(car.getTank().getCapacity(),60D);
			
			assertTrue(car.getMotor() instanceof Motor);
			assertEquals(car.getMotor().getId(),1L);
			assertEquals(car.getMotor().getPower(),150);
			
	}

	@Test
	void testSetTank() {
		Tank testTank = new Tank (100L, 50D);
		car.setTank(testTank);
		
		assertTrue(car.getTank() instanceof Tank);
		assertEquals(car.getTank().getId(),100L);
		assertEquals(car.getTank().getCapacity(),50D);
	}

}
