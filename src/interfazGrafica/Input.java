package interfazGrafica;

public class Input
{
	private String[] bounds;
	private String columns;
	private String nombre1;
	private String nombre2;
	
	public Input (	 String[] bounds,	 String columns,	 String nombre1,	 String nombre2) 
	{
		this.bounds= bounds;
		this.columns= columns;
		this.nombre1 = nombre1;
		this.nombre2 = nombre2;
		
	}

	public String[] getBounds() {
		return bounds;
	}

	public void setBounds(String[] bounds) {
		this.bounds = bounds;
	}

	public String getColumns() {
		return columns;
	}

	public void setColumns(String columns) {
		this.columns = columns;
	}

	public String getNombre1() {
		return nombre1;
	}

	public void setNombre1(String nombre1) {
		this.nombre1 = nombre1;
	}

	public String getNombre2() {
		return nombre2;
	}

	public void setNombre2(String nombre2) {
		this.nombre2 = nombre2;
	}
	
	

}
