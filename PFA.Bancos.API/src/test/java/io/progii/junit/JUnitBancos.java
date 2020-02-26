package io.progii.junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.sql.Array;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import pfa.bancos.dal.EntidadesBancariasDAL;
import pfa.bancos.model.EntidadBancaria;

public class JUnitBancos {

	@Test
	public void crearObtenerBanco() {
		EntidadesBancariasDAL eb = new EntidadesBancariasDAL();
		
		eb.crearEntidadBancaria("TEST01", "Entidad de Test", "Av Tester 1234");
		
		EntidadBancaria entidad = eb.obtenerEntidadPorCodigo("TEST01");
		
		assertEquals(entidad.getCodigo(), "TEST01");
		
		eb.eliminar("TEST01");
		
		entidad = eb.obtenerEntidadPorCodigo("TEST01");
		
		assertEquals(entidad, null);
	}

}
