package interfazGrafica;

import org.openstreetmap.gui.jmapviewer.Coordinate;

public class Vertice {

	private Coordinate coordenada;
	private float[] datosCoordenadas;
	private String nombre;
	
	public Vertice (float[] datosCoordenadas, String nombre) {
		this.datosCoordenadas = datosCoordenadas;
		this.coordenada= new Coordinate(datosCoordenadas[0],datosCoordenadas[1]);
		this.nombre = nombre;
		
	}
	
	public Vertice (Coordinate coordenada, String nombre) {
		this.coordenada= coordenada;
		this.nombre = nombre;		
	}

	public Coordinate getCoordenada() {
		return coordenada;
	}

	public void setCoordenada(Coordinate coordenada) {
		this.coordenada = coordenada;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	

	public float[] getDatosCoordenadas() {
		return datosCoordenadas;
	}

	public void setDatosCoordenadas(float[] datosCoordenadas) {
		this.datosCoordenadas = datosCoordenadas;
	}

	@Override
	public String toString() {
		return "Vertice [coordenada=" + coordenada + ", nombre=" + nombre + "]";
	}
	
	
	
}
