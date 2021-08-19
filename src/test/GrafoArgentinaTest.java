package test;

import static org.junit.Assert.*;

import org.junit.Test;

import codigoNegocio.GrafoArgentina;

public class GrafoArgentinaTest {

	
	public GrafoArgentina inicializar() {
		
		GrafoArgentina grafo = new GrafoArgentina();
		grafo.addAristas("Buenos Aires", "CABA", 6);
		grafo.addAristas("La Pampa", "Entre Rios", 4);
		grafo.addAristas("Santa Cruz", "Tierra Del Fuego", 12);
		
		return grafo;
	}
	
	@Test
	public void existeAristaTest() {
		
		GrafoArgentina grafo = inicializar();
		
		assertTrue(grafo.existeArista("Buenos Aires", "CABA"));
	}
	
	@Test
	public void noExisteAristaTest() {
		
		GrafoArgentina grafo = inicializar();
		
		assertFalse(grafo.existeArista("Buenos Aires", "Mendoza"));
	}
	
	@Test
	public void addAristaTest() {
		
		GrafoArgentina grafo = inicializar();
		
		grafo.addAristas("Santa Cruz", "Mendoza", 15);
		
		assertTrue(grafo.existeArista("Santa Cruz", "Mendoza"));
	}
	
	@Test
	public void obtenerPesoTest() {
		
		GrafoArgentina grafo = inicializar();
		
		grafo.addAristas("Santa Cruz", "Mendoza", 15);
		
		assertEquals(grafo.obtenerPeso("Santa Cruz", "Mendoza"), 15);
	}
	
	@Test
	public void obtenerProvinciaTest() {
		
		GrafoArgentina grafo = inicializar();
		
		String provincia = grafo.obtenerProvincia(0);
		
		assertEquals(provincia, "Buenos Aires");
	}
	
	@Test(expected = NullPointerException.class)
	public void provinciaMalEscritaTest() {
		
		GrafoArgentina grafo = inicializar();
		
		grafo.addAristas("Santa Cruz", "Mendozzzzza", 15);
		
		assertTrue(grafo.existeArista("Santa Cruz", "Mendozzzzza"));
	}

}
