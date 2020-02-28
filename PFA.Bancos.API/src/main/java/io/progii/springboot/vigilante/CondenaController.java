package io.progii.springboot.vigilante;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import pfa.bancos.dal.CondenasDAL;
import pfa.bancos.model.Condena;


@RestController
public class CondenaController {
	org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger("main-logger");

	CondenasDAL condenasDAL = new CondenasDAL(); 
	
	@CrossOrigin(origins = "*")	
	@RequestMapping(value = "/condena/crear", method = RequestMethod.POST)
	public void create(@RequestBody Condena condena) {
		logger.info("POST: /condena/crear");
		condenasDAL.create(condena.getCodigoDelDelincuente(),condena.getCodigoAsalto(), condena.getFechaDeInicio().toString(),condena.getFechaFin().toString());
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping (value = "/condena/porAsaltos/{id}", method = RequestMethod.GET)
	public ArrayList<Condena> getCondenasPorAsalto(@PathVariable int id){
		logger.info("GET: /condena/porAsaltos/{id}"+id);
		return condenasDAL.getCondenasPorAsalto(id);
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/condena/asalto/{idAsalto}", method = RequestMethod.PUT)
	public void setearCondena(@RequestBody ArrayList<Condena> condena, @PathVariable int idAsalto) {
		logger.info("PUT: /condena/asalto/"+idAsalto);
		condenasDAL.setearCondena(condena,idAsalto);
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/condena/porDelincuente/{codigo}", method = RequestMethod.GET)
	public ArrayList<Condena> getCondenaPorDelincuente(@PathVariable String codigo){
		logger.info("GET: /condena/porDelincuente/"+codigo);
		return condenasDAL.getCondenaPorDelincuente(codigo);
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/condena/obtenerTodas", method = RequestMethod.GET)
	public ArrayList<Condena> getCondenas() {
		logger.info("GET: /condena/obtenerTodas");
		return condenasDAL.getCondenas();
	}
	
	
	
	
}