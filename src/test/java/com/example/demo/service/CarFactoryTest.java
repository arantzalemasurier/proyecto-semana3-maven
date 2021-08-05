package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.demo.domain.Car;

class CarFactoryTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testCreateByType() {
		Car car;
		
		car = CarFactory.createByType("combustible");
		assertEquals(car.toString(),"Car [id=1, brand=Default brand, model=Default model, color=Default color, door=4"
				+ ", battery=Battery [id=1, capacity=14.0]"
				+ ", air=AirConditioning [id=1, on=true, temperature=24.0]"
				+ ", motor=CombustionMotor [id=1, on=true, power=150.0, fuel=PETROL, cc=1000.0]"
				+ ", tank=Battery [id=1, capacity=60.0]]");

		car = CarFactory.createByType("electrico");
		assertEquals(car.toString(),"Car [id=1, brand=Default brand, model=Default model, color=Default color, door=4"
				+ ", battery=Battery [id=1, capacity=14.0]"
				+ ", air=AirConditioning [id=1, on=true, temperature=24.0]"
				+ ", motor=ElectricMotor [id=1, on=true, power=150.0, voltage=400.0]"
				+ ", plug=Plug [id=1, plug=TYPE1]]");
		
		car = CarFactory.createByType("hibrido");
		assertEquals(car.toString(),"Car [id=1, brand=Default brand, model=Default model, color=Default color, door=4"
				+ ", battery=Battery [id=1, capacity=14.0]"
				+ ", air=AirConditioning [id=1, on=true, temperature=24.0]"
				+ ", motor=ElectricMotor [id=1, on=true, power=150.0]"
				+ ", tank=HydrogenTank [id=1, presure=80.0]]");
			
			Exception exception = assertThrows(
					IllegalArgumentException.class, 
					() ->CarFactory.createByType("notexists"));
			
			assertEquals("Unexpected value: notexists", exception.getMessage());
		}
		
	}

