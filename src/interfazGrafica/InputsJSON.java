package interfazGrafica;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class InputsJSON 
{
	private Input[] inputs;
	
	public InputsJSON() 
	{		
		this.inputs = leerJSON();
	}	

	public  int size() 
	{
		return this.inputs.length;
	}
	public String generarJSONPretty() 
	{
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(this);
		return json;
	}
	
	public  Input[] leerJSON() 
	{
		Gson gson = new Gson();
		Input[] inputsJson = null;
		
		try
		{
			BufferedReader br = new BufferedReader(new FileReader("Inputs.JSON"));	
			inputsJson = gson.fromJson(br, Input[].class); 	
			return inputsJson;
		}catch(IOException e) 
		{
			e.printStackTrace();
		}
		return inputsJson;		
		
	}

	public Input[] getInputs() 
	{
		return inputs;
	}

	
	
}
