package io.progii.springboot.vigilante;

import java.util.ArrayList;

import org.hibernate.validator.constraints.URL;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pfa.bancos.dal.DelincuentesDAL;
import pfa.bancos.model.Delincuente;


@RestController
public class DelincuenteController {

	DelincuentesDAL delincuentesDAL = new DelincuentesDAL();
	
	@RequestMapping(value = "/delincuentes", method = RequestMethod.GET)
	@CrossOrigin(origins = "*")
	public ArrayList<Delincuente> getDelincuentes(){
		return delincuentesDAL.getDelincuentes();		
	}
	
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/delincuentes/{codigo}", method = RequestMethod.GET)
	public Delincuente getDelincuente(@PathVariable String codigo){
		return delincuentesDAL.getPorCodigo(codigo);		
	}
	
	@RequestMapping(value = "/delincuentes/asalto/{asaltoId}", method = RequestMethod.GET)
	@CrossOrigin(origins = "*")
	public ArrayList<Delincuente> getDelincuentesPorAsalto(@PathVariable int asaltoId){
		return delincuentesDAL.getPorAsalto(asaltoId);		
	}
	
	@RequestMapping(value = "/delincuentes", method = RequestMethod.POST)
	@CrossOrigin(origins = "*")
	public void createDelincuente(@RequestBody Delincuente delincuente){
		delincuentesDAL.crear(delincuente.getCodigo(), delincuente.getNombre(), delincuente.getDetenido(), 
				delincuente.getCodigoBanda());		
	}
	
	@RequestMapping(value = "/delincuentes", method = RequestMethod.PUT)
	@CrossOrigin(origins = "*")
	public void updateDelincuente(@RequestBody Delincuente delincuente){
		delincuentesDAL.guardar(delincuente.getCodigo(), delincuente.getNombre(), delincuente.getDetenido(), 
				delincuente.getCodigoBanda());		
	}
	
	@RequestMapping(value = "/delincuentes/{codigo}", method = RequestMethod.DELETE)
	@CrossOrigin(origins = "*")
	public void eliminarDelincuente(@PathVariable String codigo){
		delincuentesDAL.eliminar(codigo);		
	}
}
