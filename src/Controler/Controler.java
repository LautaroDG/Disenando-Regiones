package Controler;

import java.util.ArrayList;
import codigoNegocio.GrafoArgentina;

public class Controler  {
	private ArrayList<AristaTO> aristasTOCompletas;
	private ArrayList<AristaTO> aristasTORegiones;
	private GrafoArgentina grafoArgentina;
	
	public Controler() {
		
		this.aristasTOCompletas = new ArrayList<AristaTO>();		

	}	

	public ArrayList<AristaTO> enviarAlNegocio(ArrayList<AristaTO> aristas) {
		
		this.grafoArgentina = new GrafoArgentina(aristas);
		this.aristasTOCompletas = this.grafoArgentina.getAristasTO();
		return this.aristasTOCompletas;
	}
	
	public ArrayList<AristaTO> separarRegiones(Integer cantRegiones) {	
	
		this.grafoArgentina = new GrafoArgentina(this.aristasTOCompletas);		
		this.grafoArgentina.separarRegionesAGM(cantRegiones);		
		this.aristasTORegiones = this.grafoArgentina.getAristasTO();		
		return this.aristasTORegiones;
	}	
	
}




