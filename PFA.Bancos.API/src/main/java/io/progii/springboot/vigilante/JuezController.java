package io.progii.springboot.vigilante;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pfa.bancos.model.Juez;
//import pfa.bancos.model.Vigilante;
import pfa.bancos.dal.JuecesDAL;



@RestController

public class JuezController {
	
	JuecesDAL juecesDAL= new JuecesDAL();
	
	@RequestMapping(value = "/juez/traerTodos", method = RequestMethod.GET)
	public ArrayList<Juez> getjueces() {
		return juecesDAL.getJueces();
	}
	
		
	@RequestMapping( value = "/juez/crearjuez", method = RequestMethod.POST)
	public void crear (@RequestBody Juez juez) {
	this.juecesDAL.crear(juez.getNombre(), juez.getCodigo(), juez.getFechaDeIngreso());
	}

	@RequestMapping(value = "/juez/eliminarPorId/{codigo}", method = RequestMethod.DELETE)
	public void eliminar(@PathVariable String codigo) {
	juecesDAL.eliminar(codigo);
}
}
