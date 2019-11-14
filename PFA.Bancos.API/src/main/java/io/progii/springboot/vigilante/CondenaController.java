package io.progii.springboot.vigilante;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import pfa.bancos.dal.CondenasDAL;
import pfa.bancos.model.Condena;


@RestController
public class CondenaController {

	CondenasDAL condenasDAL = new CondenasDAL(); 
	
		
	@RequestMapping(value = "/condena/crear", method = RequestMethod.POST)
	public void create(@RequestBody Condena condena) {
		condenasDAL.create(condena.getCodigoDelDelincuente(),condena.getCodigoAsalto(), condena.getFechaDeInicio().toString(),condena.getFechaFin().toString());
	}
	
	@RequestMapping (value = "/condena/porAsaltos/{id}", method = RequestMethod.GET)
	public ArrayList<Condena> getCondenasPorAsalto(@PathVariable int id){
		return condenasDAL.getCondenasPorAsalto(id);
	}
	
	@RequestMapping(value = "/condena/asalto/{idAsalto}", method = RequestMethod.PUT)
	public void setearCondena(@RequestBody ArrayList<Condena> condena, @PathVariable int idAsalto) {
		condenasDAL.setearCondena(condena,idAsalto);
	}
	
	@RequestMapping(value = "/condena/porDelincuente/{codigo}", method = RequestMethod.GET)
	public ArrayList<Condena> getCondenaPorDelincuente(@PathVariable String codigo){
		return condenasDAL.getCondenaPorDelincuente(codigo);
	}
	
	@RequestMapping(value = "/condena/obtenerTodas", method = RequestMethod.GET)
	public ArrayList<Condena> getCondenas() {
		return condenasDAL.getCondenas();
		
	}
	
	
	
	
}