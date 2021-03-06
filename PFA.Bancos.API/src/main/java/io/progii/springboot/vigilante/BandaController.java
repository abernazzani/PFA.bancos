package io.progii.springboot.vigilante;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pfa.bancos.dal.BandasDAL;
import pfa.bancos.model.Banda;

@RestController
public class BandaController {
	org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger("main-logger");

	BandasDAL bandasDAL = new BandasDAL();
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/banda/obtenerBandas", method = RequestMethod.GET)
	public ArrayList<Banda> obtenerBandas(){
		logger.info("GET: /banda/obtenerBandas");
		return bandasDAL.obtenerBandas();
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/banda/porCodigo/{codigo}", method = RequestMethod.GET)
	public Banda obtenerBanda(@PathVariable String codigo) {
		logger.info("GET: /banda/porCodigo/"+codigo);
		return bandasDAL.obtenerBanda(codigo);
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/banda/crear", method = RequestMethod.POST)
	public void crear(@RequestBody Banda banda) {
		logger.info("POST: /banda/crear");
		bandasDAL.crear(banda.getCodigoBanda(), banda.getNroDeMiembros());		
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/banda/actualizar", method = RequestMethod.PUT)
	public void update(@RequestBody Banda banda) {
		logger.info("PUT: /banda/actualizar");
		bandasDAL.update(banda.getCodigoBanda(), banda.getNroDeMiembros());
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/banda/eliminar/{codigo}", method = RequestMethod.DELETE)
	public void eliminar(@PathVariable String codigo) {
		logger.info("DELETE: /banda/eliminar/"+codigo);
		bandasDAL.eliminar(codigo);
	}
	
	
	
	
}