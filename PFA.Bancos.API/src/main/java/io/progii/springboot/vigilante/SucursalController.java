package io.progii.springboot.vigilante;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pfa.bancos.dal.SucursalDAL;
import pfa.bancos.model.Sucursal;
import pfa.bancos.model.Usuario;

@RestController
public class SucursalController {

	SucursalDAL sucursalDAL = new SucursalDAL();
	
	
	@RequestMapping(value = "/sucursal/crear", method = RequestMethod.POST)
	@CrossOrigin(origins = "*")
	public void crear(@RequestBody Sucursal sucursal) {
		this.sucursalDAL.crearSucursal(sucursal.getCodigoEntidad(),sucursal.getCodigo(), sucursal.getDomicilio(), sucursal.getNroEmpleados());
	}	
	
	@RequestMapping(value = "/sucursal/guardar", method = RequestMethod.PUT)
	@CrossOrigin(origins = "*")
	public void guardarSucursal(@RequestBody Sucursal sucursal) {
		this.sucursalDAL.guardarSucursal(sucursal.getCodigo(), sucursal.getDomicilio(), sucursal.getNroEmpleados());
	}
	
	@RequestMapping(value = "/sucursal/eliminar/{codigo}", method = RequestMethod.DELETE)
	@CrossOrigin(origins = "*")
	public void eliminarSucursal(@PathVariable String codigo) {
		sucursalDAL.eliminar(codigo);		
		
	}
	@RequestMapping(value="/sucursal/obtener/{codigo}", method = RequestMethod.GET)
	@CrossOrigin(origins = "*")
	public Sucursal sucursalPorCodigo(@PathVariable String codigo) {
		return sucursalDAL.getSucursalPorCodigo(codigo);
		
	}
	@RequestMapping(value = "/sucursal/traerTodas", method = RequestMethod.GET)
	@CrossOrigin(origins = "*")
	public ArrayList<Sucursal> traerSucursales(){
		return sucursalDAL.getSucursales();
	} 
	
	@RequestMapping(value = "/sucursal/traerPorEntidad/{codigo}", method = RequestMethod.GET)
	@CrossOrigin(origins = "*")
	public ArrayList<Sucursal> traerSucursalesPorCodigoEntidad(@PathVariable String codigo){
		return sucursalDAL.getSucursalesPorCodigoEntidad(codigo);
		
	}
	
	
	
	
	
	
}