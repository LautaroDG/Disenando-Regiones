package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import codigoNegocio.AGM;
import codigoNegocio.AristaNegocio;
import codigoNegocio.Grafo;

public class AGMTest {

	public Grafo inicializar() {
		Grafo grafo = new Grafo(6);
		grafo.agregarArista(0, 1, 5);
		grafo.agregarArista(0, 2, 15);
		grafo.agregarArista(0, 3, 12);
		grafo.agregarArista(0, 4, 9);
		
		return grafo;
	}
	

	@Test
	public void grafoAGMTest() {
		Grafo grafo = inicializar();
		grafo.agregarArista(0, 5, 11);
		grafo.agregarArista(2, 5, 19);
		grafo.agregarArista(3, 4, 17);
		grafo.agregarArista(1, 2, 23);
		
		@SuppressWarnings("unused")
		Grafo agm = AGM.arbolGeneradorMinimo(grafo);
		ArrayList<AristaNegocio> aristasAGM = grafo.aristas();
		
		ArrayList<AristaNegocio> aristasEsperadas= new ArrayList<>();
		aristasEsperadas.add(new AristaNegocio(0,1,5));
		aristasEsperadas.add(new AristaNegocio(0,2,15));
		aristasEsperadas.add(new AristaNegocio(0,3,12));
		aristasEsperadas.add(new AristaNegocio(0,4,9));
		aristasEsperadas.add(new AristaNegocio(0,5,11));
		
		for(AristaNegocio arista : aristasEsperadas) {
			assertTrue(aristasAGM.contains(arista));
		}
	}
	
	@Test
	public void grafoYaAGMTest() {
		
		Grafo grafo = inicializar();
		ArrayList<AristaNegocio> aristas = grafo.aristas();
		grafo.agregarArista(0, 5, 11);
		
		@SuppressWarnings("unused")
		Grafo agm = AGM.arbolGeneradorMinimo(grafo);
		ArrayList<AristaNegocio> aristasAGM = grafo.aristas();
		
		for(AristaNegocio arista : aristas) {
			assertTrue(aristasAGM.contains(arista));
		}		
	}
	
	@Test(expected = RuntimeException.class)
	public void grafoSinAGMTest() {
		
		Grafo grafo = inicializar();
		
		@SuppressWarnings("unused")
		Grafo agm = AGM.arbolGeneradorMinimo(grafo);
	}
	
}
