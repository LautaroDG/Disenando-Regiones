package interfazGrafica;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class TextAreaJSON {
private TextArea[] textAreas;
	
	public TextAreaJSON() 
	{		
		this.textAreas = leerJSON();
	}	

	public  int size() 
	{
		return this.textAreas.length;
	}
	public String generarJSONPretty() 
	{
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(this);
		return json;
	}
	
	public  TextArea[] leerJSON() 
	{
		Gson gson = new Gson();
		TextArea[] textAreaJson = null;
		
		try
		{
			BufferedReader br = new BufferedReader(new FileReader("TextAreas.JSON"));	
			textAreaJson = gson.fromJson(br, TextArea[].class); 	
			return textAreaJson;
		}catch(IOException e) 
		{
			e.printStackTrace();
		}
		return textAreaJson;		
		
	}

	public TextArea[] getTextAreas() 
	{
		return this.textAreas;
	}

}
