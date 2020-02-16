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

	AsaltosDAL asaltosDAL = new AsaltosDAL();
	
	//***public ArrayList<Asalto> getAsaltosPorDelincuente(String codigoDelincuente)
	//**public ArrayList<Asalto> getAsaltos()
	//**public Asalto getAsaltoPorId(int id)
	//**public ArrayList<Asalto> getAsaltoPorSucursal(String codigoSucursal)
	// PREGUNTAR CON HACER CON 2 TIPOS DE DATOS EN JSON, public void guardar(int id, String fecha, String codigoJuez, String codigoSucursal, ArrayList<String> delincuentes)
	//PREGUNTAR CON HACER CON 2 TIPOS DE DATOS EN JSON, public void crear(String fecha, String codigoJuez, String codigoSucursal, ArrayList<String> delincuentes)
	//**public void eliminarAsalto(int id)
	
	
	/*@RequestMapping(value = "/asalto/porCodigoDelincuente/{codigo}", method = RequestMethod.GET)
	public ArrayList<Asalto> getAsaltosPorDelincuente(@PathVariable String codigo){
		return asaltosDAL.getAsaltosPorDelincuente(codigo);		
	}
	*/
	
	@RequestMapping(value = "/asalto/obtenerTodos", method = RequestMethod.GET)
	@CrossOrigin(origins = "*")
	public ArrayList<Asalto> getAsaltos(){
		return asaltosDAL.getAsaltos();		
	}
	
	@RequestMapping(value = "/asalto/ObtenerPorId/{id}", method = RequestMethod.GET)
	@CrossOrigin(origins = "*")
	public Asalto getAsaltoPorId(@PathVariable int id) {
		return asaltosDAL.getAsaltoPorId(id);
	}
	
	@RequestMapping(value = "/asalto/obtenerPorSucursal/{codigo}", method = RequestMethod.GET)
	@CrossOrigin(origins = "*")
	public ArrayList<Asalto> getAsaltoPorSucursal(@PathVariable String codigo){
		return asaltosDAL.getAsaltoPorSucursal(codigo);
	}

	@RequestMapping(value = "/asalto/guardar", method = RequestMethod.PUT)
	@CrossOrigin(origins = "*")
	public void guardar(@RequestBody AsaltoRequestModel asaltoRM) {
		asaltosDAL.guardar(asaltoRM.getId(), asaltoRM.getFecha(), asaltoRM.getCodigoJuez(), asaltoRM.getCodigoSucursal(), 
				asaltoRM.getDelincuentes());
	}	
	
		
	@RequestMapping(value = "/asalto/crear", method = RequestMethod.POST)
	@CrossOrigin(origins = "*")
	public void crear(@RequestBody Asalto asaltoRM) {
		asaltosDAL.crear(asaltoRM.getFecha(), asaltoRM.getCodigoJuez(), asaltoRM.getCodigoSucursal(), 
				asaltoRM.getDelincuentes());
	}
	
	
	
	@RequestMapping(value = "/asalto/eliminar/{id}", method = RequestMethod.DELETE)
	@CrossOrigin(origins = "*")
	public void eliminarAsalto(@PathVariable int id) {
		asaltosDAL.eliminarAsalto(id);
	}
	
}
