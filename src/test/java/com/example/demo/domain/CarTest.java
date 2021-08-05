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
		// Comprobado en otros test
	}

	@Test
	void testGetModel() {
		// Comprobado en otros test
	}

	@Test
	void testGetColor() {
		// Comprobado en otros test
	}

	@Test
	void testGetBattery() {
		// Comprobado en otros test
	}

	@Test
	void testGetAir() {
		// Comprobado en otros test
	}

	@Test
	void testGetMotor() {
		// Comprobado en otros test
	}

	@Test
	void testGetDoor() {
		// Comprobado en otros test
	}

	@Test
	void testSetId() {
		// Comprobado en otros test
	}

	@Test
	void testSetBrand() {
		car.setBrand("testBrand");
		assertEquals(car.getBrand(), "testBrand");
		
	}

	@Test
	void testSetModel() {
		car.setModel("testModel");
		assertEquals(car.getModel(), "testModel");
	}

	@Test
	void testSetColor() {
		car.setColor("testColor");
		assertEquals(car.getColor(), "testColor");
	}

	@Test
	void testSetBattery() {
		Battery testBattery = new Battery (2L, 14D);
		car.setBattery(testBattery);
		
		assertEquals(car.getBattery().getId(),2L);
		assertEquals(car.getBattery().getCapacity(),14D);
	}

	@Test
	void testSetAir() {
		AirConditioning testAir = new AirConditioning (2L, 25F);
		car.setAir(testAir);
		
		assertEquals(car.getAir().getId(),2L);
		assertEquals(car.getAir().getTemperature(),25F);
		
	}

	@Test
	void testSetMotor() {
		Motor testMotor = new Motor (2L, 120F);
		car.setMotor(testMotor);
		
		assertEquals(car.getMotor().getId(),2L);
		assertEquals(car.getMotor().getPower(),120F);
	}

	@Test
	void testSetDoor() {
		car.setDoor(3);
		assertEquals(car.getDoor(), 3);
		
	}

	@Test
	void testToString() {
		// Con la implementación de Car y CombustionCar, no se probar este método.
		
	}
}
