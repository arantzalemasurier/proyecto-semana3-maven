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

import com.example.demo.domain.HybridCar;
import com.example.demo.service.HybridCarService;

@Path("/HybridCar")
@Component
@Produces(MediaType.APPLICATION_JSON) // Indicaremos que devuelve o produce un JSON
@Consumes(MediaType.APPLICATION_JSON) // y aqui que recibe o consume un JSON
public class HybridCarController {

	private HybridCarService hybridCarService;

	public HybridCarController(HybridCarService hybridCarService) {
		this.hybridCarService = hybridCarService;
	}
	
	/**
	 * GET http://localhost:8080/api/HybridCar
	 */
    @GET
    public List<HybridCar> findAll(){
        return hybridCarService.findAll();
    }

    /**
     * GET
     * http://localhost:8080/api/HybridCar/1
     * http://localhost:8080/api/HybridCar/2
     * http://localhost:8080/api/HybridCar/3
     */
    @GET
    @Path("{id}")
    public Response findOne(@PathParam("id") Long id){
    	HybridCar car = hybridCarService.findOne(id);
        if (car == null)
            return Response.status(Response.Status.NOT_FOUND).build();

        return Response.ok(car).build();
    }
    
    @GET // Podremos elegir por color cuantos vehículos híbridos hay de ese color
    @Path("/color/{color}")
    public List<HybridCar> findByColor(@PathParam("color") String color){
        return hybridCarService.findByColor(color);
    }
    
    /**
     * GET ejemplo
     * http://localhost:8080/api/HybridCar/door/4
     */
    @GET // Podremos elegir por números de puertas cuantos vehículos híbridos hay
    @Path("/door/{door}")
    public List<HybridCar> findByDoor(@PathParam("door") int door){
        return hybridCarService.findByDoor(door);
    }
    
    /**
     * GET ejemplo
     * http://localhost:8080/api/HybridCar/brand/ibiza
     */
    @GET
    @Path("/brand/{brand}") // Podremos elegir por modelo de coche y nos lo mostrará
    public List<HybridCar> findByBrand(@PathParam("brand") String brand){
        return hybridCarService.findByBrand(brand);
    }
    
    /**
     * GET ejemplo
     * http://localhost:8080/api/HybridCar/started
     */
    @GET // Mostraremos todos los coches que están encendidos
    @Path("/started")
    public List<HybridCar> findStarted(){
        return hybridCarService.findStarted();
    }

    @POST // Crearé un vehículo nuevo
    public Response create(HybridCar car){
        if (car.getId() != null)
            return Response.status(Response.Status.BAD_REQUEST).build();
        
        HybridCar result = hybridCarService.save(car);
        return Response.ok(result).build();
    }

    @PUT // modificaré un coche ya creado, sólo algunas de sus características
    public Response update(HybridCar car){
        if (car.getId() == null || car.getId() == 0) 
            return Response.status(Response.Status.BAD_REQUEST).build();
        
        HybridCar result = hybridCarService.save(car);
        return Response.ok(result).build();
    }

    /**
     * DELETE
     * http://localhost:8080/api/HybridCar/1
     * http://localhost:8080/api/HybridCar/2
     * http://localhost:8080/api/HybridCar/3
     */
    @DELETE // Borraremos solo el vehiculo del id que seleccionemos
    @Path("{id}")
    public Response deleteOne(@PathParam("id") Long id){
        if(!hybridCarService.delete(id))
        	return Response.status(Response.Status.NOT_FOUND).build();
        
        return Response.ok(Response.Status.OK).build();
    }

    @DELETE // Borraremos todos los vehículos electrico
    public Response deleteAll(){
    	hybridCarService.deleteAll();
        return Response.ok(Response.Status.OK).build();
    }
	
}
