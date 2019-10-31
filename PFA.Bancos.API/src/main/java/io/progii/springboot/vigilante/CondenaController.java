package io.progii.springboot.vigilante;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import pfa.bancos.dal.CondenasDAL;
import pfa.bancos.model.Condena;
import pfa.bancos.model.ArrayCondenaPorAsalto;


@RestController
public class CondenaController {

	CondenasDAL condenasDAL = new CondenasDAL(); 
	
	
	//**public void create(String codigoDelincuente, int asaltoId, String fechaInicio, String fechaFin)
	//**public ArrayList<Condena> getCondenasPorAsalto(int asaltoId)
	//(preguntar para pasar 2 parametros en json, 1: arraylist 2:int  )    public void setearCondena(ArrayList<Condena> condenas, int asaltoId)
	//**public ArrayList<Condena> getCondenaPorDelincuente(String codigoDelincuente)
	
	@RequestMapping(value = "/condenas/crear", method = RequestMethod.POST)
	public void create(@RequestBody Condena condena) {
		condenasDAL.create(condena.getCodigoDelDelincuente(),condena.getCodigoAsalto(), condena.getFechaDeInicio().toString(),condena.getFechaFin().toString());
	}
	
	@RequestMapping (value = "/condenas/porAsaltos/{id}", method = RequestMethod.GET)
	public ArrayList<Condena> getCondenasPorAsalto(@PathVariable int id){
		return condenasDAL.getCondenasPorAsalto(id);
	}
	
	@RequestMapping(value = "/condenas/asalto/{idAsalto}", method = RequestMethod.PUT)
	public void setearCondena(@RequestBody ArrayList<Condena> condena, @PathVariable int idAsalto) {
		condenasDAL.setearCondena(condena,idAsalto);
	}
	
	@RequestMapping(value = "/condenas/porDelincuente/{codigo}", method = RequestMethod.GET)
	public ArrayList<Condena> getCondenaPorDelincuente(@PathVariable String codigo){
		return condenasDAL.getCondenaPorDelincuente(codigo);
	}
	
	
}