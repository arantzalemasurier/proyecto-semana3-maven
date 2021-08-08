package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;

import com.example.demo.domain.HybridCar;
import com.example.demo.domain.pieces.AirConditioning;
import com.example.demo.domain.pieces.Battery;
import com.example.demo.domain.pieces.HybridMotor;
import com.example.demo.domain.pieces.HydrogenTank;

@TestMethodOrder(OrderAnnotation.class)
class HybridCarServiceImplTest {

	static HybridCarServiceImpl hybridService;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		hybridService = new HybridCarServiceImpl();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	@Order(0)
	void testCount() {
		assertEquals(3, hybridService.count());
	}

	@Test
	@Order(1)
	void testFindAll() {
		List<HybridCar> result = hybridService.findAll();
		assertEquals(3, result.size());
	}

	@Test
	@Order(2)
	void testFindOne() {
		HybridCar result = hybridService.findOne(1L);
		assertEquals(1L, result.getId());
	}

	@Test
	@Order(3)
	void testSave() {
		HybridCar car = new HybridCar(4L, "BMW", "X5", "blanco", 2,
				new Battery(1L, 15D),
				new AirConditioning(3L, 25F),
				new HybridMotor(4L, 140F),
				new HydrogenTank(4L, 70D));
				
		assertEquals(car, hybridService.save(car));
		
		car = new HybridCar(null, "BMW", "X5", "blanco", 2,
				new Battery(1L, 15D),
				new AirConditioning(3L, 25F),
				new HybridMotor(4L, 140F),
				new HydrogenTank(4L, 70D));
				
		assertEquals(car, hybridService.save(car));
				
		car = new HybridCar(0L, "BMW", "X5", "blanco", 2,
				new Battery(1L, 15D),
				new AirConditioning(3L, 25F),
				new HybridMotor(4L, 140F),
				new HydrogenTank(4L, 70D));
				
		assertEquals(car, hybridService.save(car));
	}

	@Test
	@Order(4)
	void testFindByColor() {
		List<HybridCar> result = hybridService.findByColor("gris");
		assertEquals(1,  result.size());
		result = hybridService.findByColor("negro");
		assertEquals(0, result.size());
	}

	@Test
	@Order(5)
	void testFindByDoor() {
		List<HybridCar> result = hybridService.findByDoor(4);
		assertEquals(3, result.size());
	}
	
	@Test
	@Order(6)
	void testFindByBrand() {
		List<HybridCar> result = hybridService.findByBrand("Alfa");
		assertEquals(1, result.size());
		result  = hybridService.findByBrand("Infinity");
		assertEquals(0, result.size());
	}

	@Test
	@Order(7)
	void testFindStarted() {
		List<HybridCar> result = hybridService.findStarted();
		assertEquals(1, result.size());
	}
	
	@Test
	@Order(8)
	void testDelete() {
		assertEquals(6, hybridService.count());
		assertTrue(hybridService.delete(1L));
		assertEquals(5, hybridService.count());
		assertFalse(hybridService.delete(null));
		assertFalse(hybridService.delete(7L));
	}
	
	@Test
	@Order(9)
	void testDeleteAll() {
		hybridService.deleteAll();
		assertEquals(0, hybridService.count());
		hybridService.deleteAll();
		assertEquals(0, hybridService.count());
		
	}
	
	@Test
	@Order(10)
	void testGetMaxHybridCarId() {
		HybridCar car = new HybridCar(null, "BMW", "X3i", "negro", 2,
				new Battery(1L, 15D),
				new AirConditioning(3L, 25F),
				new HybridMotor(4L, 140F),
				new HydrogenTank(4L, 70D));
				
		assertEquals(car, hybridService.save(car));
		assertEquals(1L, car.getId());
		

	}
}
