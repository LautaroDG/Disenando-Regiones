package codigoNegocio;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class BFS {
	private static ArrayList<Integer> L;
	private static boolean[] marcados;
	
	public static boolean esConexo(Grafo grafo) {
		
		if(grafo == null) 
			throw new IllegalArgumentException("El grafo no puede ser null");
		
		if(grafo.vertices() == 0)
			return true;
		
		return alcanzables(grafo, 0).size() == grafo.vertices();
	}
	
	public static Set<Integer> alcanzables(Grafo grafo, int origen) {
		
		Set<Integer> alcanzables = new HashSet<Integer>();
		inicializar(grafo, origen);
		
		while(L.size() > 0) {
			int i = L.get(0);
			marcados[i] = true;
			alcanzables.add(i);	
			agregarVecinosPendientes(grafo, i);
			L.remove(0);
		}
		
		return alcanzables;
	}

	private static void agregarVecinosPendientes(Grafo grafo, int i) {
		
		for(int vertice : grafo.vecinos(i)) 
			if(!marcados[vertice] && !L.contains(vertice)) 
				L.add(vertice);		
	}

	private static void inicializar(Grafo grafo, int origen) {
		
		L = new ArrayList<Integer>();
		L.add(origen);
		marcados = new boolean[grafo.vertices()];		
	}
}
