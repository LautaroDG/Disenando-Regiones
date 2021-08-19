package codigoNegocio;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Grafo {
	private int vertices = 0;
	private Integer[][] grafo;
	private ArrayList<AristaNegocio> aristas;

	public Grafo() {
		this.grafo = new Integer[0][0];
	}
	
	public Grafo(int vertices) {
		
		if(vertices < 0)
			throw new IllegalArgumentException("Cantidad de vertices invalida");
		
		this.grafo = new Integer[vertices][vertices];
		this.vertices = vertices;
		this.aristas = new ArrayList<AristaNegocio>();

	}
	
	public void agregarVertice() {
		this.vertices += 1;
		Integer[][] nuevoGrafo = new Integer[vertices][vertices];
		
		for (int i = 0; i < this.grafo.length; i++) {
			for (int j = 0; j < this.grafo.length; j++) {
				nuevoGrafo[i][j] = this.grafo[i][j];
			}
		}
		
		this.grafo = nuevoGrafo;
	}
	
	public void agregarArista(int vertice1, int vertice2, int peso) {
		
		if(existeArista(vertice1, vertice2))
			return;
		
		if(vertice1 == vertice2) 
			throw new IllegalArgumentException("No se aceptan bucles");
		
		if(peso < 1)
			throw new IllegalArgumentException("Peso invalido");
		
		verificarVertice(vertice1);
		verificarVertice(vertice2);
		
		grafo[vertice1][vertice2] = peso;
		grafo[vertice2][vertice1] = peso;
		
		aristas.add(new AristaNegocio(vertice1,vertice2,peso));
	}
	
	public void eliminarArista(int vertice1, int vertice2) {
		
		verificarVertice(vertice1);
		verificarVertice(vertice2);
		
		aristas.remove(new AristaNegocio(vertice1, vertice2, obtenerPeso(vertice1, vertice2)));
		
		grafo[vertice1][vertice2] = null;
		grafo[vertice2][vertice1] = null;
		
	}
	
	public boolean existeArista(int vertice1, int vertice2) {
		
		verificarVertice(vertice1);
		verificarVertice(vertice2);
		
		return (grafo[vertice1][vertice2] != null);
	}
	
	public Set<Integer> vecinos(int vertice){

		verificarVertice(vertice);	
		Set<Integer> vecinos = new HashSet<>();
		
		for(int i=0; i<grafo.length; i++)
			if(grafo[vertice][i] != null) 
				vecinos.add(i);
		
		return vecinos;
	}
	
	public AristaNegocio aristaMasPesada() {
		
		int peso = 0;
		AristaNegocio masPesada = null;
		
		for(AristaNegocio arista : aristas) {
			if (arista.peso() > peso){
				peso = arista.peso();
				masPesada = arista;
			}
		}
		
		return masPesada;
	}
	
	public Grafo obtenerAGM() {
		
		return AGM.arbolGeneradorMinimo(this);
	}
	
	public void separarRegionesAGM(int cantidadRegiones) {
		
		if(cantidadRegiones > this.vertices || cantidadRegiones < 0) {
			throw new IllegalArgumentException("Cantidad de regiones invalida");
		}
		
		AristaNegocio aristaMasPesada;
		for(int i = 1; i < cantidadRegiones; i++) {
			aristaMasPesada = aristaMasPesada();
			eliminarArista(aristaMasPesada.vertice1(), aristaMasPesada.vertice2());
		}
	}
	
	public int obtenerPeso(int vertice1, int vertice2) {
		
		verificarVertice(vertice1);
		verificarVertice(vertice2);
		
		return grafo[vertice1][vertice2];
	}
	
	public ArrayList<AristaNegocio> aristas(){
		return this.aristas;
	}
	
	public int vertices() {
		return this.vertices;
	}
	
	public void verificarVertice(int vertice) {
		
		if(vertice < 0 || vertice >= this.vertices)
			throw new IllegalArgumentException("Vértice inválido");
	}
}



