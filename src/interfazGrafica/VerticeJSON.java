package interfazGrafica;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class VerticeJSON {
	
	private Vertice[] vertices;
	{		
		this.vertices = leerJSON();
	}	

	public  int size() 
	{
		return this.vertices.length;
	}
	public String generarJSONPretty() 
	{
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(this);
		return json;
	}
	
	public  Vertice[] leerJSON() 
	{
		Gson gson = new Gson();
		Vertice[] verticesJson = null;
		
		try
		{
			BufferedReader br = new BufferedReader(new FileReader("Vertices.JSON"));	
			verticesJson = gson.fromJson(br, Vertice[].class); 	
			return verticesJson;
		}catch(IOException e) 
		{
			e.printStackTrace();
		}
		return verticesJson;		
		
	}

	public Vertice[] getVertices() 
	{
		return this.vertices;
	}

}
