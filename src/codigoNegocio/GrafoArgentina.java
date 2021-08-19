package codigoNegocio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import Controler.AristaTO;

public class GrafoArgentina {
	Grafo grafo;
	private ArrayList<AristaTO> aristas;
	HashMap<String,Integer> vertices;
	
	public GrafoArgentina() {
		this.grafo = new Grafo(24);
		this.vertices = new HashMap<>();
		addProvincias();
	}

	public GrafoArgentina(ArrayList<AristaTO> aristas) {
		this.grafo = new Grafo(24);
		this.aristas = aristas;
		this.vertices = new HashMap<>();
		addProvincias();
		inicializarGrafoArgentina();
	}
	
	private void inicializarGrafoArgentina() {
		
		for(AristaTO arista : aristas) {			
			addAristas(arista.getVertice1(), arista.getVertice2(), arista.getPeso());
		}
		
	}

	public void obtenerAGM() {
		
		this.grafo = this.grafo.obtenerAGM();
	}
	
	public void separarRegionesAGM(int cantidadRegiones) {
		
		obtenerAGM();
		
		this.grafo.separarRegionesAGM(cantidadRegiones);
		
		actualizarAristasTO();
	}
	
	public void addAristas(String provincia1, String provincia2, int peso) {
		
		this.grafo.agregarArista(this.vertices.get(provincia1), this.vertices.get(provincia2), peso);
	}
	
	public boolean existeArista(String provincia1, String provincia2) {
		
		return this.grafo.existeArista(this.vertices.get(provincia1), this.vertices.get(provincia2));
	}
	
	public int obtenerPeso(String provincia1, String provincia2) {
		
		return this.grafo.obtenerPeso(this.vertices.get(provincia1), this.vertices.get(provincia2));
	}

	private void addProvincias() {
		
		vertices.put("Buenos Aires", 0);
		vertices.put("CABA", 1);
		vertices.put("Entre Rios", 2);
		vertices.put("Corrientes", 3);
		vertices.put("Misiones", 4);
		vertices.put("Chaco", 5);
		vertices.put("Formosa", 6);
		vertices.put("Santiago Del Estero", 7);
		vertices.put("Jujuy", 8);
		vertices.put("Salta", 9);
		vertices.put("Cordoba", 10);
		vertices.put("Tucuman", 11);
		vertices.put("Catamarca", 12);
		vertices.put("Santa Fe", 13);
		vertices.put("La Rioja", 14);
		vertices.put("San Juan", 15);
		vertices.put("Mendoza", 16);
		vertices.put("San Luis", 17);
		vertices.put("La Pampa", 18);
		vertices.put("Rio Negro", 19);
		vertices.put("Neuquen", 20);
		vertices.put("Chubut", 21);
		vertices.put("Santa Cruz", 22);
		vertices.put("Tierra Del Fuego", 23);
	}
	
	public String obtenerProvincia(int vertice) {
		
		String provincia = null;
		
		for(Map.Entry<String , Integer> entry : vertices.entrySet()) {
			if(entry.getValue() == vertice)
				provincia = entry.getKey();
		}
		
		return provincia;
	}

	private void actualizarAristasTO() {
		
		ArrayList<AristaTO> listaActualizada = new ArrayList<>();
		
		for(AristaNegocio aristaNegocio : this.grafo.aristas()) {
			String provincia1 = obtenerProvincia(aristaNegocio.vertice1());
			String provincia2 = obtenerProvincia(aristaNegocio.vertice2());
			int peso = aristaNegocio.peso();
			
			listaActualizada.add(new AristaTO(peso, provincia1, provincia2));
		}
		
		this.aristas = listaActualizada;
	}
	
	public Grafo grafo() {
		
		return this.grafo;
	}
	
	public ArrayList<AristaNegocio> aristas(){
		
		return this.grafo.aristas();
	}

	public ArrayList<AristaTO> getAristasTO() {
		
		return this.aristas;
	}
}

