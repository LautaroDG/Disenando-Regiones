package test;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Test;

import codigoNegocio.*;

public class GrafoTest {

	
	public Grafo inicializar() {
		Grafo grafo = new Grafo(5);
		grafo.agregarArista(0, 2, 6);
		grafo.agregarArista(1, 3, 11);
		grafo.agregarArista(0, 4, 76);
		grafo.agregarArista(4, 2, 5);
		
		return grafo;
	}
	
	@Test
	public void existeAristaTest() {
		
		Grafo grafo = inicializar();
		assertTrue(grafo.existeArista(0,2));
	}
	
	@Test
	public void noExisteAristaTest() {
		
		Grafo grafo = inicializar();
		assertFalse(grafo.existeArista(0,1));
	}

	@Test
	public void agregarAristaTest() {
		
		Grafo grafo = inicializar();
		
		grafo.agregarArista(4, 1, 9);
		
		assertTrue(grafo.existeArista(4,1));
	}
	
	@Test
	public void agregarAristaOpuestaTest() {
		
		Grafo grafo = inicializar();
		
		grafo.agregarArista(4, 1, 9);
		
		assertTrue(grafo.existeArista(1,4));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void agregarBucleTest() {
		
		Grafo grafo = inicializar();
		
		grafo.agregarArista(4, 4, 9);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void agregarAristaInvalidaTest() {
		
		Grafo grafo = inicializar();
		
		grafo.agregarArista(4, -1, 9);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void agregarPesoInvalidoTest() {
		
		Grafo grafo = inicializar();
		
		grafo.agregarArista(4, 1, -9);
	}
	
	@Test
	public void eliminarAristaTest() {
		
		Grafo grafo = inicializar();

		grafo.eliminarArista(0, 2);
		
		assertFalse(grafo.existeArista(0, 2));

	}
	
	@Test
	public void vecinosTest() {
		
		Grafo grafo = inicializar();
		
		Set<Integer> alcanzables = grafo.vecinos(0);
		int[] esperado = {2,4};
		
		Assert.iguales(alcanzables, esperado);
		
	}
	
	@Test
	public void vecinosConAgregarTest() {
		
		Grafo grafo = inicializar();
		grafo.agregarArista(0, 1, 3);
		
		Set<Integer> alcanzables = grafo.vecinos(0);
		int[] esperado = {1,2,4};
		
		Assert.iguales(alcanzables, esperado);
		
	}
	
	@Test
	public void agregarVerticeTest() {
		
		Grafo grafo = inicializar();
		
		grafo.agregarVertice();
		
		assertEquals(grafo.vertices(), 6);	
	}
	
	
}
