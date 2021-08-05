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

import com.example.demo.domain.CombustionCar;
import com.example.demo.service.CombustionCarService;

@Path("/CombustionCar")
@Component
@Produces(MediaType.APPLICATION_JSON) // Indicaremos que devuelve o produce un JSON
@Consumes(MediaType.APPLICATION_JSON) // y aqui que recibe o consume un JSON
public class CombustionCarController {

	private CombustionCarService combustionCarService;

	public CombustionCarController(CombustionCarService combustionCarService) {
		this.combustionCarService = combustionCarService;
	}
	
	/**
	 * GET http://localhost:8080/api/CombustionCar
	 */
    @GET
    public List<CombustionCar> findAll(){
        return combustionCarService.findAll();
    }
    
    /**
     * GET
     * http://localhost:8080/api/CombustionCar/1
     * http://localhost:8080/api/CombustionCar/2
     * http://localhost:8080/api/CombustionCar/3
     */
    @GET
    @Path("{id}")
    public Response findOne(@PathParam("id") Long id){
    	CombustionCar car = combustionCarService.findOne(id);
        if (car == null)
            return Response.status(Response.Status.NOT_FOUND).build();

        return Response.ok(car).build();
    }
    
    @GET // Podremos elegir por color cuantos vehículos de combustión hay de ese color
    @Path("/color/{color}")
    public List<CombustionCar> findByColor(@PathParam("color") String color){
        return combustionCarService.findByColor(color);
    }
    
    /**
     * GET ejemplo
     * http://localhost:8080/api/CombustionCar/door/4
     */
    @GET // Podremos elegir por números de puertas cuantos vehículos de combustible hay
    @Path("/door/{door}")
    public List<CombustionCar> findByDoor(@PathParam("door") int door){
        return combustionCarService.findByDoor(door);
    }
    
    /**
     * GET ejemplo
     * http://localhost:8080/api/CombustionCar/brand/ibiza
     */
    @GET // Podremos elegir por modelo de coche y nos lo mostrará
    @Path("/brand/{brand}")
    public List<CombustionCar> findByBrand(@PathParam("brand") String brand){
        return combustionCarService.findByBrand(brand);
    }
    
    
    /**
     * GET ejemplo
     * http://localhost:8080/api/CombustionCar/started
     */
    @GET // Mostraremos todos los coches que están encendidos
    @Path("/started")
    public List<CombustionCar> findStarted(){
        return combustionCarService.findStarted();
    }

    @POST // crearé un vehículo nuevo
    public Response create(CombustionCar car){
        if (car.getId() != null)
            return Response.status(Response.Status.BAD_REQUEST).build();

        CombustionCar result = combustionCarService.save(car);
        return Response.ok(result).build();
    }

    @PUT // modificaré un coche ya creado, sólo algunas de sus características
    public Response update(CombustionCar car){
        if (car.getId() == null || car.getId() == 0) 
            return Response.status(Response.Status.BAD_REQUEST).build();
        
        CombustionCar result = combustionCarService.save(car);
        return Response.ok(result).build();
    }
    
    /**
     * DELETE
     * http://localhost:8080/api/CombustionCar/1
     * http://localhost:8080/api/CombustionCar/2
     * http://localhost:8080/api/CombustionCar/3
     */
    @DELETE // Borraremos solo el vehiculo del id que seleccionemos
    @Path("{id}")
    public Response deleteOne(@PathParam("id") Long id){
        if(!combustionCarService.delete(id))
        	return Response.status(Response.Status.NOT_FOUND).build();
        
        return Response.ok(Response.Status.OK).build();
    }

    @DELETE // Borraremos todos los vehículos de combustible
    public Response deleteAll(){
    	combustionCarService.deleteAll();
        return Response.ok(Response.Status.OK).build();
    }
	
}
