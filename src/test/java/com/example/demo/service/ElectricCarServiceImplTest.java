package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import com.example.demo.domain.ElectricCar;
import com.example.demo.domain.pieces.AirConditioning;
import com.example.demo.domain.pieces.Battery;
import com.example.demo.domain.pieces.ElectricMotor;
import com.example.demo.domain.pieces.ElectricPlug;
import com.example.demo.domain.pieces.PlugType;

@TestMethodOrder(OrderAnnotation.class)
class ElectricCarServiceImplTest {
	
	static ElectricCarServiceImpl electricService;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		electricService = new ElectricCarServiceImpl();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	@Order(0)
	void testCount() {
		assertEquals(3, electricService.count());
	}

	@Test
	@Order(1)
	void testFindAll() {
		List<ElectricCar> result = electricService.findAll();
		assertEquals(3, result.size());
		
	}

	@Test
	@Order(2)
	void testFindOne() {
		ElectricCar result = electricService.findOne(1L);
		assertEquals(1L, result.getId());
	}

	@Test
	@Order(3)
	void testSave() {
		ElectricCar car = new ElectricCar(4L, "BMW", "X3i", "negro", 2,
				new Battery(1L, 15D),
				new AirConditioning(3L, 25F),
				new ElectricMotor(4L, 140F, 500F),
				new ElectricPlug(4L, PlugType.TYPE2));
				
		assertEquals(car, electricService.save(car));
		
		car = new ElectricCar(null, "BMW", "X3i", "negro", 2,
				new Battery(1L, 15D),
				new AirConditioning(3L, 25F),
				new ElectricMotor(4L, 140F, 500F),
				new ElectricPlug(4L, PlugType.TYPE2));
		
		assertEquals(car, electricService.save(car));
				
		car = new ElectricCar(0L, "BMW", "X3i", "negro", 2,
				new Battery(1L, 15D),
				new AirConditioning(3L, 25F),
				new ElectricMotor(4L, 140F, 500F),
				new ElectricPlug(4L, PlugType.TYPE2));
		
		assertEquals(car, electricService.save(car));	
	}

	@Test
	@Order(4)
	void testFindByColor() {
		List<ElectricCar> result = electricService.findByColor("blanco");
		assertEquals(1, result.size());
		result = electricService.findByColor("marrón");
		assertEquals(1, result.size());
		
	}

	@Test
	 @Order(5)
	void testFindByDoor() {
		List<ElectricCar> result = electricService.findByDoor(4);
		assertEquals(2, result.size());
	}

	@Test
	@Order(6)
	void testFindByBrand() {
		List<ElectricCar> result = electricService.findByBrand("Seat");
		assertEquals(1, result.size());
		result = electricService.findByBrand("Opel");
		assertEquals(0, result.size());
	}

	@Test
	@Order(7)
	void testFindStarted() {
		List<ElectricCar> result = electricService.findStarted();
		assertEquals(1, result.size());
		
	}
	
	@Test
	@Order(8)
	void testDelete() {
		assertEquals(6, electricService.count());
		assertTrue(electricService.delete(1L));
		assertEquals(5, electricService.count());
		assertFalse(electricService.delete(7L));
		assertFalse(electricService.delete(null));
	}

	@Test
	@Order(9)
	void testDeleteAll() {
		electricService.deleteAll();
		assertEquals(0, electricService.count());
		electricService.deleteAll();
		assertEquals(0, electricService.count());
		
	}
	
	@Test
	@Order(10)
	void testGetMaxElectricCarId() {
		ElectricCar car = new ElectricCar(null, "BMW", "X3i", "negro", 2,
				new Battery(1L, 15D),
				new AirConditioning(3L, 25F),
				new ElectricMotor(1L, 150F, 400F),
				new ElectricPlug(4L, PlugType.TYPE2));
				
		assertEquals(car, electricService.save(car));
		assertEquals(1L, car.getId());

	}

}
	