package interfazGrafica;

public class Arista {

	private Integer peso;
    private Vertice vertice1;
    private Vertice vertice2;

	
	public Arista(Integer peso, Vertice vertice1, Vertice vertice2) {
		
		this.peso = peso;
		this.vertice1 = vertice1;
		this.vertice2 = vertice2;

		
	}

	public Integer getPeso() {
		return peso;
	}

	public void setPeso(Integer peso) {
		this.peso = peso;
	}

	public Vertice getVertice1() {
		return vertice1;
	}

	public void setVertice1(Vertice vertice1) {
		this.vertice1 = vertice1;
	}

	public Vertice getVertice2() {
		return vertice2;
	}

	public void setVertice2(Vertice vertice2) {
		this.vertice2 = vertice2;
	}

	@Override
	public String toString() {
		return "Arista [peso=" + peso + ", vertice1=" + vertice1 + ", vertice2=" + vertice2 + "]";
	}

	
	
	
}
