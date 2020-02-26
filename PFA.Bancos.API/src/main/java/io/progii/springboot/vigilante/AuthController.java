package io.progii.springboot.vigilante;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pfa.bancos.dal.UsuariosDAL;
import pfa.bancos.model.Usuario;


@RestController
public class AuthController {
	UsuariosDAL UsuarioDAL = new UsuariosDAL();
	
	
	@RequestMapping(value = "/auth/login", method = RequestMethod.POST)
	@CrossOrigin(origins = "*")
	public Usuario Login(@RequestBody Usuario loginModel) {
		return UsuarioDAL.Login(loginModel.getNombre(), loginModel.getContraseña());
		
	}
}