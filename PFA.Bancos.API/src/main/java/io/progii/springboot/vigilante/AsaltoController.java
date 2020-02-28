package io.progii.springboot.vigilante;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.progii.springboot.api.models.AsaltoRequestModel;
import pfa.bancos.dal.AsaltosDAL;
import pfa.bancos.model.Asalto;
import pfa.bancos.model.Delincuente;

@RestController
public class AsaltoController {
	org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger("main-logger");

	AsaltosDAL asaltosDAL = new AsaltosDAL();
	
	@RequestMapping(value = "/asalto/obtenerTodos", method = RequestMethod.GET)
	@CrossOrigin(origins = "*")
	public ArrayList<Asalto> getAsaltos(){
		logger.info("GET: /asalto/obtenerTodos");
		return asaltosDAL.getAsaltos();		
	}
	
	@RequestMapping(value = "/asalto/ObtenerPorId/{id}", method = RequestMethod.GET)
	@CrossOrigin(origins = "*")
	public Asalto getAsaltoPorId(@PathVariable int id) {
		logger.info("GET: /asalto/ObtenerPorId/"+id);
		return asaltosDAL.getAsaltoPorId(id);
	}
	
	@RequestMapping(value = "/asalto/obtenerPorSucursal/{codigo}", method = RequestMethod.GET)
	@CrossOrigin(origins = "*")
	public ArrayList<Asalto> getAsaltoPorSucursal(@PathVariable String codigo){
		logger.info("GET: /asalto/obtenerPorSucursal/"+codigo);
		return asaltosDAL.getAsaltoPorSucursal(codigo);
	}

	@RequestMapping(value = "/asalto/guardar", method = RequestMethod.PUT)
	@CrossOrigin(origins = "*")
	public void guardar(@RequestBody AsaltoRequestModel asaltoRM) {
		logger.info("PUT: /asalto/guardar");
		asaltosDAL.guardar(asaltoRM.getId(), asaltoRM.getFecha(), asaltoRM.getCodigoJuez(), asaltoRM.getCodigoSucursal(), 
				asaltoRM.getDelincuentes());
	}	
	
		
	@RequestMapping(value = "/asalto/crear", method = RequestMethod.POST)
	@CrossOrigin(origins = "*")
	public void crear(@RequestBody Asalto asaltoRM) {
		logger.info("POST: /asalto/crear");
		asaltosDAL.crear(asaltoRM.getFecha(), asaltoRM.getCodigoJuez(), asaltoRM.getCodigoSucursal(), 
				asaltoRM.getDelincuentes());
	}
	
	@RequestMapping(value = "/asalto/eliminar/{id}", method = RequestMethod.DELETE)
	@CrossOrigin(origins = "*")
	public void eliminarAsalto(@PathVariable int id) {
		logger.info("GET: /asalto/eliminar/"+id);
		asaltosDAL.eliminarAsalto(id);
	}
	
}
