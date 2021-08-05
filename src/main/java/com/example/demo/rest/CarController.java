package com.example.demo.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;

import com.example.demo.service.CarFactory;

// CRUD
@Component
@Path("/Car")
@Produces(MediaType.APPLICATION_JSON)
public class CarController {
	
	/** 
	 * http://localhost:8080/api/car
	 */
	@GET
	public Response hello() {
		String mensaje = "Hola desde CarController!";
		return Response.ok().entity(mensaje).build();
	}
	/**
	 * http://localhost:8080/api/car/CarCombustion
	 * http://localhost:8080/api/car/CarElectric
	 * http://localhost:8080/api/car/CarHybrid
	 * http://localhost:8080/api/smartdevice/dishwasher (NO EXISTE, DARÁ 404 NOTFOUND)
	 */
	@GET
	@Path("/{type}")
	public Response createByType(@PathParam("type") String type) {
		System.out.println("CarController executing createByType");
		try {
			return Response
					.ok()
					.entity(CarFactory.createByType(type))
					.build();
		} catch (IllegalArgumentException e) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}

	}
}