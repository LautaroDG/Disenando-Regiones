package interfazGrafica;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import org.openstreetmap.gui.jmapviewer.Coordinate;
import org.openstreetmap.gui.jmapviewer.JMapViewer;
import org.openstreetmap.gui.jmapviewer.MapMarkerDot;
import org.openstreetmap.gui.jmapviewer.MapPolygonImpl;
import org.openstreetmap.gui.jmapviewer.interfaces.MapMarker;
import org.openstreetmap.gui.jmapviewer.interfaces.MapPolygon;

import Controler.AristaTO;

@SuppressWarnings("serial")
public class Mapa extends JMapViewer{
	
	private Coordinate coordArgentina;
	private ArrayList<Vertice> vertices;
	private ArrayList<Arista> aristas;
	private VerticeJSON datosVertices;

	
	public Mapa(){
		this.coordArgentina = new Coordinate(-40.416097,-63.616672);
	    this.vertices= new ArrayList<Vertice>();
	    this.aristas = new ArrayList<Arista>();
	    this.datosVertices = new VerticeJSON();
		configurarMapa();	
		inicializarVertices();
		colocarVertices();
		
	}
	
	public void configurarMapa() {		
		
		setDisplayPosition(this.coordArgentina, 5);			
		setLayout(new GridLayout(0, 1, 0, 0));
		setBounds(461,0,573,1011);		
		setZoomControlsVisible(false);
		
	}
	public void inicializarVertices() {
		for(int i=0;i < this.datosVertices.size(); i++) 
		{
			Vertice vertice = new Vertice(new Coordinate(this.datosVertices.getVertices()[i].getDatosCoordenadas()[0],this.datosVertices.getVertices()[i].getDatosCoordenadas()[1]),this.datosVertices.getVertices()[i].getNombre());					
			vertices.add(vertice);
		}	
	}
	public void colocarVertices() {
		
		for(Vertice v : this.vertices) {
			MapMarker vertice= new MapMarkerDot(v.getNombre(), v.getCoordenada());
			vertice.getStyle().setBackColor(Color.black);
			addMapMarker(vertice);			
		}
	}
	public void colocarAristas() {

		for (Arista a : aristas) {
			MapPolygon arista= new MapPolygonImpl(a.getVertice1().getCoordenada(),
					                                                       a.getVertice2().getCoordenada(), 
					                                                       a.getVertice1().getCoordenada());
			addMapPolygon(arista);		
		}
	}
	
	public void actualizarAristas(ArrayList<AristaTO> aristasTO) {
		
		List<MapPolygon> listaAristas = this.getMapPolygonList();
		
		listaAristas.clear();
		
		dibujarAristas(aristasTO);
		
	}
	
public void dibujarAristas(ArrayList<AristaTO> aristasTO ) {
		
		String provincia1;
		String provincia2;
		
		Vertice vertice1;
		Vertice vertice2;
		
		MapPolygon mapPolygon;
		
		for(AristaTO arista : aristasTO) {
			provincia1 = arista.getVertice1();
			provincia2 = arista.getVertice2();
			
			vertice1 = this.getVertice(provincia1);
			vertice2 = this.getVertice(provincia2);
			
			mapPolygon = new MapPolygonImpl(vertice1.getCoordenada(), vertice2.getCoordenada(), vertice1.getCoordenada());
			
			this.addMapPolygon(mapPolygon);
		}
	}
	
	public Vertice getVertice(String nombreProvincia) {
		
		for(Vertice vertice : this.vertices) {
			if(vertice.getNombre().equals(nombreProvincia))
				return vertice;
		}
		
		throw new IllegalArgumentException("Provincia inválida");
	}

	
	public ArrayList<Vertice> getVertices() {
		return vertices;
	}

	public void setVertices(ArrayList<Vertice> vertices) {
		this.vertices = vertices;
	}

	public ArrayList<Arista> getAristas() {
		return aristas;
	}

	public void setAristas(ArrayList<Arista> aristas) {
		this.aristas = aristas;
	}

	@Override
	public String toString() {
		return "Mapa [aristas=" + aristas + "]";
	}

	
}
