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
	
	@RequestMapping(value = "/vigilate/{id}", method = RequestMethod.GET)
	public Vigilante getVigilante(@PathVariable String id) {
		return vigilanteDAL.getPorCodigo(id);
	}
	
	@RequestMapping(value = "/vigilate")
	public ArrayList<Vigilante> traerTodos() {		
		return vigilanteDAL.getVigilantes();		
	}
	
	@RequestMapping(value = "/vigilate", method = RequestMethod.POST)
	public void crear(@RequestBody Vigilante vigilante) {		
		vigilanteDAL.crear(vigilante.getCodigo(), vigilante.getNombre(), vigilante.getEdad(), vigilante.getUsuario());	
	}	
}

