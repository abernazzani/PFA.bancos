package io.progii.springboot.vigilante;

import java.sql.Date;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pfa.bancos.dal.ContratacionesDAL;
import pfa.bancos.model.Contratacion;



@RestController
public class ContratacionController {



	ContratacionesDAL contratacionesDAL = new ContratacionesDAL();
	
	
	//***crear(String codigoSucursal, String codigoVigilante, String fecha, Boolean armas)
	//**ArrayList<Contratacion> getContrataciones()
	//**ArrayList<Contratacion> getContratacionesPorCodigoVigilante(String codigo)
	//**ArrayList<Contratacion> getContratacionesPorCodigoSucursal(String codigo)
	//ArrayList<Contratacion> getContratacionesPorFecha(Date fecha)
	
	//eliminar(String codigoVigilante, Date fecha)
	
		
	@RequestMapping(value = "/contrataciones", method = RequestMethod.POST)
	@CrossOrigin(origins = "*")
	public void createContratacion(@RequestBody Contratacion contratacion){
		contratacionesDAL.crear(contratacion.getCodigoSucursal(), contratacion.getCodigoVigilante(), contratacion.getFecha(), contratacion.getArmas());		
	}
	
	@RequestMapping(value = "/contrataciones", method = RequestMethod.PUT)
	@CrossOrigin(origins = "*")
	public void UpdateContratacion(@RequestBody Contratacion contratacion){
		contratacionesDAL.guardar(contratacion.getCodigoSucursal(), contratacion.getCodigoVigilante(), contratacion.getFecha(), contratacion.getArmas());		
	}
	
	//ArrayList<Contratacion> getContrataciones()
	
	@RequestMapping(value = "/contrataciones", method = RequestMethod.GET)
	@CrossOrigin(origins = "*")
	public ArrayList<Contratacion> getContrataciones(){
		return contratacionesDAL.getContrataciones();		
	}
	
	//ArrayList<Contratacion> getContratacionesPorCodigoVigilante(String codigo)
		
	@RequestMapping(value = "/contrataciones/PorCodigoVigilante/{id}", method = RequestMethod.GET)
	@CrossOrigin(origins = "*")
	public ArrayList<Contratacion> getContratacionesPorAsalto(@PathVariable String id){
		return contratacionesDAL.getContratacionesPorCodigoVigilante(id);		
	}
	
	//ArrayList<Contratacion> getContratacionesPorCodigoSucursal(String codigo)
	
		@RequestMapping(value = "/contrataciones/PorCodigoSucursal/{id}", method = RequestMethod.GET)
		@CrossOrigin(origins = "*")
		public ArrayList<Contratacion> getContratacionesPorSucursal(@PathVariable String id){
			return contratacionesDAL.getContratacionesPorCodigoSucursal(id);		
		}
		
	//ArrayList<Contratacion> getContratacionesPorFecha(Date fecha)
		@RequestMapping(value = "/contrataciones/PorFecha/{fecha}", method = RequestMethod.GET)
		@CrossOrigin(origins = "*")
		public ArrayList<Contratacion> getContratacionesPorFecha(@PathVariable String fecha){
			return contratacionesDAL.getContratacionesPorFecha(fecha);		
		}
		
		
		
		
		@RequestMapping(value = "/contrataciones/getPorFechaYCodVigilante/{codigo}/{fecha}", method = RequestMethod.GET)
		@CrossOrigin(origins = "*")
		public Contratacion getContratacionesPorCodigoYFecha(@PathVariable String codigo, @PathVariable String fecha){
			System.out.println(codigo);
			System.out.println(fecha);
			
			return contratacionesDAL.getPorFechaYCodVigilante(codigo, fecha);		
		}                            
		
		
		
		
	//eliminar(String codigoVigilante, Date fecha)	
		@RequestMapping(value = "/contrataciones/{codigo}/{fecha}", method = RequestMethod.DELETE)
		@CrossOrigin(origins = "*")
		public void delete(@PathVariable String codigo, @PathVariable String fecha){
			contratacionesDAL.eliminar(codigo, fecha);		
		
		}
		
		
			
}
	
	
	
	
	
	