package io.progii.springboot.vigilante;

import java.util.ArrayList;

//import javax.jws.WebMethod;

import org.springframework.web.bind.annotation.CrossOrigin;
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
		
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/vigilante/getPorUsuario/{usuario}", method = RequestMethod.GET)
	public Vigilante getPorUsuario(@PathVariable String usuario) {
		return vigilanteDAL.getPorUsuario(usuario);
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/vigilante/getPorCodigo/{codigo}", method = RequestMethod.GET)
	public Vigilante getPorCodigo(@PathVariable String codigo) {
		return vigilanteDAL.getPorCodigo(codigo);
	}
			
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/vigilante", method = RequestMethod.GET)
	public ArrayList<Vigilante> traerTodos() {		
		return vigilanteDAL.getVigilantes();		
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/vigilante", method = RequestMethod.POST)
	public void crear(@RequestBody Vigilante vigilante) {		
		vigilanteDAL.crear(vigilante.getCodigo(), vigilante.getNombre(), vigilante.getFechaNac(), vigilante.getUsuario());	
	}
	
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/vigilante", method = RequestMethod.PUT)
	public void modificar(@RequestBody Vigilante vigilante) {		
		vigilanteDAL.guardarVigilante(vigilante.getCodigo(), vigilante.getNombre(), vigilante.getFechaNac(), vigilante.getUsuario());	
	}
	
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value ="/vigilante/{id}", method = RequestMethod.DELETE)
	public void eliminar(@PathVariable String id) {
	vigilanteDAL.eliminar(id);
	
	
	}
	
}


