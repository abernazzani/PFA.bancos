package io.progii.springboot.vigilante;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pfa.bancos.model.Usuario;
import pfa.bancos.model.Vigilante;
import pfa.bancos.dal.UsuariosDAL;

@RestController
public class UsuarioController {

	UsuariosDAL usuariosDAL = new UsuariosDAL();

	@RequestMapping(value = "/usuario")
	public ArrayList<Usuario> getUsuarios() {
		return usuariosDAL.getUsuarios();
	}

	@RequestMapping(value = "/usuario/{id}")
	public Usuario getObtenerUsuarioPorID(@PathVariable int id) {
		return usuariosDAL.getObtenerUsuarioPorID(id);
	}

	@RequestMapping(value = "/usario/{codigo}", method = RequestMethod.DELETE)
	public void eliminar(@PathVariable int codigo) {
		usuariosDAL.eliminar(codigo);
	}

	@RequestMapping(value = "/usuario", method = RequestMethod.POST)
	public void crear(@RequestBody Usuario usuario) {		
		this.usuariosDAL.crear(usuario.getNombre(), usuario.getContraseña(), usuario.getRolID());		
	}
	
	@RequestMapping(value = "/usuario", method = RequestMethod.PUT)
	public void actualizar(@RequestBody Usuario usuario) {		
		this.usuariosDAL.guardarUsuario(usuario.getNombre(), usuario.getContraseña(), usuario.getRolID());		
	}
}

class ClaseConDecorador {

	@RequestMapping(value = "/usuario")
	public void asdfasdf() {

	}
}