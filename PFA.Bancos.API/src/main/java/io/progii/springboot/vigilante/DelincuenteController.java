package io.progii.springboot.vigilante;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pfa.bancos.dal.DelincuentesDAL;
import pfa.bancos.model.Delincuente;




@RestController
public class DelincuenteController {

	DelincuentesDAL delincuentesDAL = new DelincuentesDAL();



	@RequestMapping(value = "delincuente/traerTodos", method = RequestMethod.GET)
	public ArrayList<Delincuente> getDelincuente(){
		return DelincuentesDAL.getDelincuentes();
	}

	@RequestMapping(value = "delincuente/traerPorCodigo/{codigo}", method = RequestMethod.GET)
	public Delincuente getPorCodigo( @PathVariable String codigo ) {
		return DelincuentesDAL.getPorCodigo(codigo);
	}


	@RequestMapping (value = "delincuente/eliminarPorCodigo/{codigo}", method = RequestMethod.DELETE)
	public void eliminar (@PathVariable String codigo) {
		delincuentesDAL.eliminar(codigo);
	}
	
	@RequestMapping ( value = "delincuente/crear", method = RequestMethod.POST)
	public void crear(@RequestBody Delincuente delincuente) {
		this.delincuentesDAL.crear(delincuente.getCodigo(), delincuente.getNombre(), delincuente.getDetenido(), delincuente.getCodigoBanda());
	}
	
	@RequestMapping ( value = "delincuente/guardar", method = RequestMethod.PUT)
	public void guardar (@RequestBody Delincuente delincuente) {
		this.delincuentesDAL.guardar(delincuente.getCodigo(), delincuente.getNombre(), delincuente.getDetenido(), delincuente.getCodigoBanda());
	}
	
}
