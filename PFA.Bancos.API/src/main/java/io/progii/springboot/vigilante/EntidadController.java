package io.progii.springboot.vigilante;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import pfa.bancos.dal.EntidadesBancariasDAL;
import pfa.bancos.model.EntidadBancaria;

@RestController
public class EntidadController {

	EntidadesBancariasDAL entidadesBancariasDAL = new EntidadesBancariasDAL();
	
	//***public ArrayList<EntidadBancaria> obtenerEntidades()
	//***public void eliminar(String codigo)
	//***public EntidadBancaria obtenerEntidadPorCodigo(String codigo)
	//***public void editarEntidadBancaria(String codigo, String nombre, String domicilio)
	//***public void crearEntidadBancaria(String codigo, String nombre, String domicilio)
	//Pruebas
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/entidad/obtenerEntidades", method = RequestMethod.GET)
	public ArrayList<EntidadBancaria> obtenerEntidades() throws SQLException{
		return entidadesBancariasDAL.obtenerEntidades();
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/entidad/eliminar/{codigo}", method = RequestMethod.DELETE)
	public void eliminar(@PathVariable String codigo) {
		entidadesBancariasDAL.eliminar(codigo);	
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/entidad/obtenerEntidadPorCodigo/{codigo}", method = RequestMethod.GET)
	public EntidadBancaria obtenerEntidadPorCodigo(@PathVariable String codigo){
		return entidadesBancariasDAL.obtenerEntidadPorCodigo(codigo);
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/entidad/editar", method = RequestMethod.PUT)
	public void editarEntidadBancaria(@RequestBody EntidadBancaria entidad) {
		entidadesBancariasDAL.editarEntidadBancaria(entidad.getCodigo(),entidad.getNombre(), entidad.getDomicilio());
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "entidad/crear",method = RequestMethod.POST)
	public void crearEntidadBancaria(@RequestBody EntidadBancaria entidad) {
		entidadesBancariasDAL.crearEntidadBancaria(entidad.getCodigo(), entidad.getNombre(), entidad.getDomicilio());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
