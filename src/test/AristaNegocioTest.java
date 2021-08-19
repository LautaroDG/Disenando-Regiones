package test;

import static org.junit.Assert.*;

import org.junit.Test;

import codigoNegocio.AristaNegocio;

public class AristaNegocioTest {

	@Test
	public void aristasIgualesTest() {
		AristaNegocio arista1 = new AristaNegocio(1,2,9);
		AristaNegocio arista2 = new AristaNegocio(1,2,9);
		
		assertEquals(arista1, arista2);
	}
	
	@Test
	public void aristasIgualesInvertidasTest() {
		AristaNegocio arista1 = new AristaNegocio(2,1,9);
		AristaNegocio arista2 = new AristaNegocio(1,2,9);
		
		assertEquals(arista1, arista2);
	}
	
	@Test
	public void aristasDistintoPesoTest() {
		AristaNegocio arista1 = new AristaNegocio(1,2,4);
		AristaNegocio arista2 = new AristaNegocio(1,2,9);
		
		assertNotEquals(arista1, arista2);
	}
	
	@Test
	public void aristasDistintasTest() {
		AristaNegocio arista1 = new AristaNegocio(7,4,4);
		AristaNegocio arista2 = new AristaNegocio(2,5,9);
		
		assertNotEquals(arista1, arista2);
	}

}
