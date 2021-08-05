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

import com.example.demo.domain.CombustionCar;
import com.example.demo.domain.pieces.AirConditioning;
import com.example.demo.domain.pieces.Battery;
import com.example.demo.domain.pieces.CombustionMotor;
import com.example.demo.domain.pieces.FuelType;
import com.example.demo.domain.pieces.Tank;

@TestMethodOrder(OrderAnnotation.class)
class CombustionCarServiceImplTest {

	static CombustionCarServiceImpl combustionService;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		combustionService = new CombustionCarServiceImpl();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	@Order(0)
	void testCount() {
		assertEquals(3, combustionService.count());
	}

	@Test
	@Order(1)
	void testFindAll() {
		List<CombustionCar> result = combustionService.findAll();
		assertEquals(3, result.size());
	}

	@Test
	@Order(2)
	void testFindOne() {
		CombustionCar result = combustionService.findOne(1L);
		assertEquals(1L, result.getId());
	}

	@Test
	@Order(3)
	void testSave() {
		CombustionCar car = new CombustionCar(4L, "BMW", "X3i", "negro", 2,
				new Battery(1L, 15D),
				new AirConditioning(3L, 25F),
				new CombustionMotor(4L, 140F, FuelType.DIESEL, 1200F),
				new Tank(4L, 70D));
		
		assertEquals(car, combustionService.save(car));
		
		car = new CombustionCar(null, "BMW", "X3i", "negro", 2,
				new Battery(1L, 15D),
				new AirConditioning(3L, 25F),
				new CombustionMotor(4L, 140F, FuelType.DIESEL, 1200F),
				new Tank(4L, 70D));
		
		assertEquals(car, combustionService.save(car));
				
		car = new CombustionCar(0L, "BMW", "X3i", "negro", 2,
				new Battery(1L, 15D),
				new AirConditioning(3L, 25F),
				new CombustionMotor(4L, 140F, FuelType.DIESEL, 1200F),
				new Tank(4L, 70D));
		
		assertEquals(car, combustionService.save(car));
		
	}
	
	@Test
	@Order(4)
	void testFindByColor() {
		List<CombustionCar> result = combustionService.findByColor("negro");
		assertEquals(4,  result.size());
		result = combustionService.findByColor("turquesa");
		assertEquals(0, result.size());
		
	}

	@Test
	@Order(5)
	void testFindByDoor() {
		List<CombustionCar> result = combustionService.findByDoor(2);
		assertEquals(4, result.size());
	}

	@Test
	@Order(6)
	void testFindByBrand() {
		List<CombustionCar> result = combustionService.findByBrand("Seat");
		assertEquals(1, result.size());
		result = combustionService.findByBrand("Opel");
		assertEquals(0, result.size());
	}

	@Test
	@Order(7)
	void testFindStarted() {
		List<CombustionCar> result = combustionService.findStarted();
		assertEquals(2, result.size());
	}
	
	@Test
	@Order(8)
	void testDelete() {
		assertEquals(6, combustionService.count());
		assertTrue(combustionService.delete(1L));
		assertEquals(5, combustionService.count());
		assertFalse(combustionService.delete(7L));
		assertFalse(combustionService.delete(null));
		
	}

	@Test
	@Order(9)
	void testDeleteAll() {
		combustionService.deleteAll();
		assertEquals(0, combustionService.count());
		combustionService.deleteAll();
		assertEquals(0, combustionService.count());
		
	}
	
	@Test
	@Order(10)
	void testGetMaxCombustionCarId() {
		CombustionCar car = new CombustionCar(null, "BMW", "X3i", "negro", 2,
				new Battery(1L, 15D),
				new AirConditioning(3L, 25F),
				new CombustionMotor(4L, 140F, FuelType.DIESEL, 1200F),
				new Tank(4L, 70D));
				
		assertEquals(car, combustionService.save(car));
		assertEquals(1L, car.getId());
	}


}
