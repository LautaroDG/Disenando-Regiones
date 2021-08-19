package test;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Test;

import codigoNegocio.BFS;
import codigoNegocio.Grafo;

public class BFSTest {
	
	public Grafo inicializar() {
		
		Grafo grafo = new Grafo(5);
		grafo.agregarArista(0, 1, 5);
		grafo.agregarArista(1, 2, 4);
		grafo.agregarArista(3, 2, 7);
		
		return grafo;
	}
	
	@Test
	public void esConexoTest(){
		
		Grafo grafo = inicializar();
		grafo.agregarArista(4, 1, 9);
		assertTrue(BFS.esConexo(grafo));
	}
	
	@Test
	public void noConexoTest(){
		
		Grafo grafo = inicializar();
		assertFalse(BFS.esConexo(grafo));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void BFSGrafoNullTest() {
		
		BFS.esConexo(null);
	}
	
	@Test
	public void alcanzablesTest() {
		Grafo grafo = inicializar();
		Set<Integer> alcanzables = BFS.alcanzables(grafo, 0);
		int[] esperados = {0,1,2,3};
		Assert.iguales(alcanzables, esperados);
		
	}

}
