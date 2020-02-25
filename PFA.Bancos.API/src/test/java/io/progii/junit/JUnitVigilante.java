package io.progii.junit;

import static org.junit.Assert.*;

import org.junit.Test;

import pfa.bancos.dal.EntidadesBancariasDAL;
import pfa.bancos.dal.VigilantesDAL;
import pfa.bancos.model.EntidadBancaria;
import pfa.bancos.model.Vigilante;

public class JUnitVigilante {

	@Test
	public void test() {
		VigilantesDAL vDAL = new VigilantesDAL();
		
		vDAL.crear("VTEST01", "Tester", 20, "vtester");
		
		Vigilante vigilante = vDAL.getPorNombre("vtester");
		
		assertEquals(vigilante.getCodigo(), "VTEST01");
		
		vDAL.eliminar("TEST01");
		
		vigilante = vDAL.getPorNombre("vtester");
		
		assertEquals(vigilante, null);
		
		assertEquals(vigilante, null);
	}

}
