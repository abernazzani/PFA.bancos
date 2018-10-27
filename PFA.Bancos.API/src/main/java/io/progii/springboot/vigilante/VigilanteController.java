package io.progii.springboot.vigilante;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VigilanteController {
	
	//GET
	@RequestMapping(value = "/vigilate/{id}")
	public String getVigilante(@PathVariable String id) {
		//Vigilante vigilante = ClaseDAL.traerVigilante(id);
		//return vigilante;
		return "{'nombre': 'Javier', 'edad': 25}";		
	}
	
	//DELETE
	@RequestMapping(value = "/vigilate/{id}")
	public String removeVigilante(@PathVariable String id) {
		//Vigilante vigilante = ClaseDAL.traerVigilante(id);
		//return vigilante;
		return "{'nombre': 'Javier', 'edad': 25}";		
	}
	
	@RequestMapping(value = "/vigilate")
	public String traerTodos() {
		return "Te deberia traer todos los vigilantes";
	}
}

