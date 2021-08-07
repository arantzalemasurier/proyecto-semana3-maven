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

class CarTest {	

	static Battery battery;
	static AirConditioning air;
	static CombustionMotor motor;
	static Tank tank;
	static CombustionCar car;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		battery = new Battery(1L, 14D);
		air = new AirConditioning(1L, 24F);
		motor = new CombustionMotor (1L, 150F, FuelType.DIESEL, 1100F);
		tank = new Tank(1L, 60D);
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
	void testCar() {
		
	}

	@Test
	void testGetId() {
		// Comprobado en otros test
	}

	@Test
	void testGetBrand() {
	}

	@Test
	void testGetModel() {
		// Comprobado en otros test
	}

	@Test
	void testGetColor() {
	}

	@Test
	void testGetBattery() {
		battery = new Battery(1L, 14D);
	}

	@Test
	void testGetAir() {
		air = new AirConditioning(1L, 24F);
	}

	@Test
	void testGetMotor() {
		motor = new CombustionMotor (1L, 150F, FuelType.DIESEL, 1100F);
	}

	@Test
	void testGetDoor() {
	}

	@Test
	void testSetId() {
		car.setId(1L);
		assertEquals(1L, car.getId());
	}

	@Test
	void testSetBrand() {
		car.setBrand("testBrand");
		assertEquals("testBrand", car.getBrand());
		
	}

	@Test
	void testSetModel() {
		car.setModel("testModel");
		assertEquals("testModel", car.getModel());
	}

	@Test
	void testSetColor() {
		car.setColor("testColor");
		assertEquals("testColor", car.getColor());
	}

	@Test
	void testSetBattery() {
		Battery testBattery = new Battery (2L, 14D);
		car.setBattery(testBattery);
		
		assertEquals(2L, car.getBattery().getId());
		assertEquals(14D, car.getBattery().getCapacity());
	}

	@Test
	void testSetAir() {
		AirConditioning testAir = new AirConditioning (2L, 25F);
		car.setAir(testAir);
		
		assertEquals(2L, car.getAir().getId());
		assertEquals(25F, car.getAir().getTemperature());
		
	}

	@Test
	void testSetMotor() {
		Motor testMotor = new Motor (2L, 120F);
		car.setMotor(testMotor);
		
		assertEquals(2L, car.getMotor().getId());
		assertEquals(120F, car.getMotor().getPower());
	}

	@Test
	void testSetDoor() {
		car.setDoor(3);
		assertEquals(3, car.getDoor());
		
	}

	@Test
	void testToString() {
		String expected = "";
        assertFalse(car.toString().matches(expected));
		
	}
}
