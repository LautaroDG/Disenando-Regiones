package codigoNegocio;

public class AristaNegocio {
	private int vertice1;
	private int vertice2;
	private int peso;
	
	public AristaNegocio(int v1, int v2, int peso) {
		this.vertice1 = v1;
		this.vertice2 = v2;
		this.peso = peso;
	}
	
	public int vertice1() {
		return this.vertice1;
	}
	
	public int vertice2() {
		return this.vertice2;
	}
	
	public int peso() {
		return this.peso;
	}
	
	@Override
	public String toString() {
		return "Arista (" + vertice1 + ", " + vertice2 + ")-Peso: " + peso;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + peso;
		result = prime * result + vertice1;
		result = prime * result + vertice2;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		
		boolean ret = false;
		
		if (this == obj)
			ret = true;
		if (obj == null)
			ret = false;
		if (getClass() != obj.getClass())
			ret = false;
		AristaNegocio other = (AristaNegocio) obj;
		if ((vertice1 == other.vertice1 && vertice2 == other.vertice2)
				|| (vertice2 == other.vertice1 && vertice1 == other.vertice2)) {
			ret = true;
		}
		if(peso != other.peso)
			ret = false;
		return ret;
	}
}
