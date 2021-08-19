package codigoNegocio;

import java.util.ArrayList;
import java.util.Set;

public class AGM {
	private static ArrayList<AristaNegocio> aristasGrafo;
	private static Grafo AGM;
	
	public static Grafo arbolGeneradorMinimo(Grafo g){
		
		aristasGrafo = new ArrayList<>(g.aristas());
		AGM = new Grafo(g.vertices());	
		int aristasAGM = 1;
		
		while(aristasAGM <= AGM.vertices()-1 ) {
			AristaNegocio aristaMinima = aristaMenorPeso();
			AGM.agregarArista(aristaMinima.vertice1(), aristaMinima.vertice2(), aristaMinima.peso());
			aristasGrafo.remove(aristaMinima);
			aristasAGM++;
		}
		
		
		return AGM;
	}
	
	public static AristaNegocio aristaMenorPeso() {
		
		AristaNegocio aristaMinima = null;
		int pesoMinimo = Integer.MAX_VALUE;
		
		for(AristaNegocio arista : aristasGrafo) {
			
			if(arista.peso() < pesoMinimo && !formaCiclo(arista)) {
				aristaMinima = arista;
				pesoMinimo = arista.peso();
			}
		}
		
		if(aristaMinima == null) {
			throw new RuntimeException("No se pudo formar AGM");
		}
		
		return aristaMinima;
		
	}
	
	public static boolean formaCiclo(AristaNegocio arista) {
		
		boolean formaCiclo = false;
		Set<Integer> alcanzables = BFS.alcanzables(AGM, arista.vertice1());
		
		if(alcanzables.contains(arista.vertice2())) {
			formaCiclo = true;
		}
		
		return formaCiclo;
		
	}

}
