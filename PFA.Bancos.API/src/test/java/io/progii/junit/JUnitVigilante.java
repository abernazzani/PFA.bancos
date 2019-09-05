package io.progii.junit;

import static org.junit.Assert.*;

import org.junit.Test;

public class JUnitVigilante {

	@Test
	public void test() {
		int a = 0;
		a = a + 1;
		assertEquals(a, 1);
		fail("Not yet implemented");
	}

}
