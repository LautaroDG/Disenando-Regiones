package Controler;

public class AristaTO {

	private Integer peso;
	private String vertice1;
	private String vertice2;
	
	public AristaTO(Integer peso, String vertice1, String vertice2) {
		
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

	public String getVertice1() {
		return vertice1;
	}

	public void setVertice1(String vertice1) {
		this.vertice1 = vertice1;
	}

	public String getVertice2() {
		return vertice2;
	}

	public void setVertice2(String vertice2) {
		this.vertice2 = vertice2;
	}

	@Override
	public String toString() {
		return "AristaTO [peso=" + peso + ", vertice1=" + vertice1 + ", vertice2=" + vertice2 + "]";
	}
	
	
	

}
