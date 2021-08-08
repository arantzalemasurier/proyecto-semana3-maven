package com.example.demo.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;

import com.example.demo.domain.ElectricCar;
import com.example.demo.service.ElectricCarService;

@Path("/ElectricCar")
@Component
@Produces(MediaType.APPLICATION_JSON) // Indicaremos que devuelve o produce un JSON
@Consumes(MediaType.APPLICATION_JSON) // y aqui que recibe o consume un JSON
public class ElectricCarController {

	private ElectricCarService electricCarService;

	public ElectricCarController(ElectricCarService electricCarService) {
		this.electricCarService = electricCarService;
	}
	
	/**
	 * GET http://localhost:8080/api/ElectricCar
	 */
    @GET
    public List<ElectricCar> findAll(){
        return electricCarService.findAll();
    }

    /**
     * GET
     * http://localhost:8080/api/ElectricCar/1
     * http://localhost:8080/api/ElectricCar/2
     * http://localhost:8080/api/ElectricCar/3
     */
    @GET
    @Path("{id}")
    public Response findOne(@PathParam("id") Long id){
    	ElectricCar car = electricCarService.findOne(id);
        if (car == null)
            return Response.status(Response.Status.NOT_FOUND).build();

        return Response.ok(car).build();
    }
    
    @GET // Podremos elegir por color cuantos vehículos electricos hay de ese color
    @Path("/color/{color}")
    public List<ElectricCar> findByColor(@PathParam("color") String color){
        return electricCarService.findByColor(color);
    }
    
    /**
     * GET ejemplo
     * http://localhost:8080/api/ElectricCar/door/4
     */
    @GET // Podremos elegir por números de puertas cuantos vehículos electricos hay
    @Path("/door/{door}")
    public List<ElectricCar> findByDoor(@PathParam("door") int door){
        return electricCarService.findByDoor(door);
    }
    
    /**
     * GET ejemplo
     * http://localhost:8080/api/ElectricCar/brand/ibiza
     */
    @GET
    @Path("/brand/{brand}") // Podremos elegir por modelo de coche y nos lo mostrará
    public List<ElectricCar> findByBrand(@PathParam("brand") String brand){
        return electricCarService.findByBrand(brand);
    }
    
    /**
     * GET ejemplo
     * http://localhost:8080/api/ElectricCar/started
     */
    @GET // Mostraremos todos los coches que están encendidos
    @Path("/started")
    public List<ElectricCar> findStarted(){
        return electricCarService.findStarted();
    }

    @POST // Crearé un vehículo nuevo
    public Response create(ElectricCar car){
        if (car.getId() != null)
            return Response.status(Response.Status.BAD_REQUEST).build();
        
        ElectricCar result = electricCarService.save(car);
        return Response.ok(result).build();
    }

    @PUT // modificaré un coche ya creado, sólo algunas de sus características
    public Response update(ElectricCar car){
        if (car.getId() == null || car.getId() == 0) 
            return Response.status(Response.Status.BAD_REQUEST).build();
        
        ElectricCar result = electricCarService.save(car);
        return Response.ok(result).build();
    }
    
    /**
     * DELETE
     * http://localhost:8080/api/ElectricCar/1
     * http://localhost:8080/api/ElectricCar/2
     * http://localhost:8080/api/ElectricCar/3
     */
    @DELETE // Borraremos solo el vehiculo del id que seleccionemos
    @Path("{id}")
    public Response deleteOne(@PathParam("id") Long id){
        if(!electricCarService.delete(id))
        	return Response.status(Response.Status.NOT_FOUND).build();
        
        return Response.ok(Response.Status.OK).build();
    }

    @DELETE // Borraremos todos los vehículos electrico
    public Response deleteAll(){
    	electricCarService.deleteAll();
        return Response.ok(Response.Status.OK).build();
    }
	
}
