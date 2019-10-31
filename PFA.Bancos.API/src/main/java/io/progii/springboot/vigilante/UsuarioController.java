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

	
	//***public Usuario Login(String username, String password)
	//***public void crear(String username, String password, int rolId)
	//***public ArrayList<Usuario> getUsuarios()
	//***public void eliminar(int codigo)
	//***public Usuario getObtenerUsuarioPorID(int id)
	//***public void guardarUsuario(String nombre, String contraseña,int id)
		
	
	
	@RequestMapping(value = "/usuario/traerTodos", method = RequestMethod.GET)
	public ArrayList<Usuario> getUsuarios() {
		return usuariosDAL.getUsuarios();
	}

	@RequestMapping(value = "/usuario/usuarioPorId/{id}", method = RequestMethod.GET)
	public Usuario getObtenerUsuarioPorID(@PathVariable int id) {
		return usuariosDAL.getObtenerUsuarioPorID(id);
	}

	@RequestMapping(value = "/usario/eliminarPorId/{codigo}", method = RequestMethod.DELETE)
	public void eliminar(@PathVariable int codigo) {
		usuariosDAL.eliminar(codigo);
	}

	@RequestMapping(value = "/usuario/crear", method = RequestMethod.POST)
	public void crear(@RequestBody Usuario usuario) {		
		this.usuariosDAL.crear(usuario.getNombre(), usuario.getContraseña(), usuario.getRolID());		
	}
	
	@RequestMapping(value = "/usuario/guardar", method = RequestMethod.PUT)
	public void actualizar(@RequestBody Usuario usuario) {		
		this.usuariosDAL.guardarUsuario(usuario.getNombre(), usuario.getContraseña(),usuario.getRolID(), usuario.getId());		
	}
	
	@RequestMapping(value = "/usuario/login", method = RequestMethod.POST)
	public Usuario Login(@RequestBody  Usuario usuario) {
		return usuario;
	}
	
	
}
