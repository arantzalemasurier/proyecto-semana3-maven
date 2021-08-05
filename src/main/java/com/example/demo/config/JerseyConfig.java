/** Creación de un proyecto java con SpringBoot y Jersey
 * @author: Arantza del Barrio
 * @since: 2021/07/14
 * @version: 3.3
 */

package com.example.demo.config;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;
/**
 * Estas serán las anotcaciones de Jersey para especificar la ruta base http de entrada a la aplicacion y la
 * anotación de Spring para que se creen los objetos automaticamente 
 */
@ApplicationPath("/api")
@Component
public class JerseyConfig extends ResourceConfig{

	public JerseyConfig() {
		
		this.packages("com.example.demo.rest"); // declararo donde estarán las clases controladoras
	}
}