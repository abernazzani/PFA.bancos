package io.progii.springboot.vigilante;

import java.util.ArrayList;

import javax.jws.WebMethod;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pfa.bancos.dal.VigilantesDAL;
import pfa.bancos.model.Vigilante;

@RestController
public class VigilanteController {
	VigilantesDAL vigilanteDAL = new VigilantesDAL();
		
	
	@RequestMapping(value = "/vigilante/{id}", method = RequestMethod.GET)
	public Vigilante getPorNombre(@PathVariable String id) {
		return vigilanteDAL.getPorNombre(id);
	}
	
	@RequestMapping(value = "/vigilante")
	public ArrayList<Vigilante> traerTodos() {		
		return vigilanteDAL.getVigilantes();		
	}
	
	@RequestMapping(value = "/vigilante", method = RequestMethod.POST)
	public void crear(@RequestBody Vigilante vigilante) {		
		vigilanteDAL.crear(vigilante.getCodigo(), vigilante.getNombre(), vigilante.getEdad(), vigilante.getUsuario());	
	}
	
	@RequestMapping(value ="/vigilante/{id}", method = RequestMethod.DELETE)
	public void eliminar(@PathVariable String id) {
	vigilanteDAL.eliminar(id);
	
	}
	
}


