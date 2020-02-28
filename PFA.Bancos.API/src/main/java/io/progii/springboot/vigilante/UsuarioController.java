package io.progii.springboot.vigilante;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pfa.bancos.model.Usuario;
import pfa.bancos.dal.UsuariosDAL;



@RestController
public class UsuarioController {
	org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger("main-logger");
	UsuariosDAL usuariosDAL = new UsuariosDAL();
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/usuario/traerTodos", method = RequestMethod.GET)
	public ArrayList<Usuario> getUsuarios() {
		logger.info("GET: /usuario/traerTodos");
		return usuariosDAL.getUsuarios();
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/usuario/usuarioPorId/{id}", method = RequestMethod.GET)
	public Usuario getObtenerUsuarioPorID(@PathVariable int id) {
		logger.info("GET: /usuario/usuarioPorId/" + id);
		return usuariosDAL.getObtenerUsuarioPorID(id);
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/usario/eliminarPorId/{codigo}", method = RequestMethod.DELETE)
	public void eliminar(@PathVariable int codigo) {
		logger.info("DELETE/: /usario/eliminarPorId/" + codigo);
		usuariosDAL.eliminar(codigo);
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/usuario/crear", method = RequestMethod.POST)
	public void crear(@RequestBody Usuario usuario) {		
		logger.info("POST: /usuario/crear" + usuario);
		this.usuariosDAL.crear(usuario.getNombre(), usuario.getContraseña(), usuario.getRolID());		
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/usuario/guardar", method = RequestMethod.PUT)
	public void actualizar(@RequestBody Usuario usuario) {		
		logger.info("PUT: /usuario/guardar" + usuario);
		this.usuariosDAL.guardarUsuario(usuario.getNombre(), usuario.getContraseña(),usuario.getRolID(), usuario.getId());		
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/usuario/login", method = RequestMethod.POST)
	public Usuario Login(@RequestBody  Usuario usuario) {
		logger.info("PUT: /usuario/login" + usuario);
		return usuario;
	}
	
	
	
	
	
	
}
