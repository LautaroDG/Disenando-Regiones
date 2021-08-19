package interfazGrafica;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import Controler.AristaTO;
import Controler.Controler;



@SuppressWarnings("serial")
public class Menu extends JPanel{
	private JTextField cantRegionesInput;
	private JEditorPane titulo;
	private JButton calcularRegionesButton;
	private JButton mostrarGrafoCompletoButton;
	private ArrayList<JTextField> inputs;
	private ArrayList<JTextArea> texts;
	private Mapa mapa;
	private InputsJSON datosInputs;
	private TextAreaJSON datosTextAreas;
	private Controler controller;
	private ArrayList<AristaTO> aristasTOCompletas;
	
	
	
	public Menu(Mapa mapa) {
		this.mapa = mapa;
		this.inputs = new ArrayList<JTextField>();
		this.texts = new ArrayList<JTextArea>();
		this.datosInputs = new InputsJSON();
		this.datosTextAreas = new TextAreaJSON();	
		this.aristasTOCompletas = new ArrayList<AristaTO>();
		configurarMenu();
		inicializarTitulo();
		inicializarInputs();	
		inicializarTextAreas();
		inicializarBotones();	
		this.controller = new Controler();		
		
		this.mostrarGrafoCompletoButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) 
			{						    
					agregarAristas();
					mapa.actualizarAristas(controller.enviarAlNegocio(aristasTOCompletas));;					
			}	
		});
		this.calcularRegionesButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) 
			{		
					mapa.actualizarAristas(controller.separarRegiones(Integer.parseInt(cantRegionesInput.getText())));		
				
			}	
		});	
	}
	
    public void configurarMenu() {
		setBounds(0,0,461,1011);		
		setLayout(null);
    }   
	
	public void inicializarInputs() {
		
		for(int i=0;i < this.datosInputs.size(); i++) 
		{
			JTextField textField = new JTextField();
			textField.setBounds(Integer.parseInt(this.datosInputs.getInputs()[i].getBounds()[0]),
					                     Integer.parseInt(this.datosInputs.getInputs()[i].getBounds()[1]),
					                     Integer.parseInt(this.datosInputs.getInputs()[i].getBounds()[2]),
				                         Integer.parseInt(this.datosInputs.getInputs()[i].getBounds()[3]));
			textField.setColumns(Integer.parseInt(this.datosInputs.getInputs()[i].getColumns()));
			add(textField);
			this.inputs.add(textField);
			generarArista(this.datosInputs.getInputs()[i].getNombre1(),this.datosInputs.getInputs()[i].getNombre2());
		}	
		this.cantRegionesInput = new JTextField();
		this.cantRegionesInput.setColumns(10);
		this.cantRegionesInput.setBounds(315, 930, 31, 20);
		add(this.cantRegionesInput);		
	}	

    public void inicializarTextAreas() {
	for(int i=0;i < this.datosTextAreas.size(); i++) {
		JTextArea textArea = new JTextArea();
		textArea.setLineWrap(this.datosTextAreas.getTextAreas()[i].isLineWrap());
		textArea.setFont(new Font("Tahoma", Font.PLAIN,Integer.parseInt(this.datosTextAreas.getTextAreas()[i].getFont())));
		textArea.setEditable(this.datosTextAreas.getTextAreas()[i].isEditable());
		textArea.setText(this.datosTextAreas.getTextAreas()[i].getText());
		textArea.setBounds(Integer.parseInt(this.datosTextAreas.getTextAreas()[i].getBounds()[0]),
                Integer.parseInt(this.datosTextAreas.getTextAreas()[i].getBounds()[1]),
                Integer.parseInt(this.datosTextAreas.getTextAreas()[i].getBounds()[2]),
                Integer.parseInt(this.datosTextAreas.getTextAreas()[i].getBounds()[3]));
		add(textArea);		
	}
}

	public void inicializarTitulo() {
		
		this.titulo = new JEditorPane();
		this.titulo.setEditable(false);
		this.titulo.setText("Introdusca los pesos de las aristas");
		this.titulo.setBounds(111, 0, 243, 22);
		add(this.titulo);
		
	}
	public void inicializarBotones() {
		
		this.calcularRegionesButton = new JButton("Calcular");
		this.calcularRegionesButton.setBounds(200, 927, 90, 23);
		add(this.calcularRegionesButton);	
		
		this.mostrarGrafoCompletoButton = new JButton("Mapa Completo");
		this.mostrarGrafoCompletoButton.setBounds(25, 927, 150, 23);
		add(this.mostrarGrafoCompletoButton);	
		
	}

	public void generarArista(String nombre1, String nombre2) {
		@SuppressWarnings("unused")
		boolean v1 = true;
		@SuppressWarnings("unused")
		boolean v2 = true;
		Vertice vertice1= null;
		Vertice vertice2 = null;		
			for (Vertice v : this.mapa.getVertices()) {				
				if (v.getNombre().equals(nombre1)) {
					vertice1 = new Vertice(v.getCoordenada(), v.getNombre());
					v1 = false;
				}
				if (v.getNombre().equals(nombre2)) {
					vertice2 = new Vertice(v.getCoordenada(), v.getNombre());
					v2 = false;
				}
			}		
		this.mapa.getAristas().add(new Arista(0,vertice1,vertice2));
	}
	
	public void agregarAristas() {
		
		for(int i = 0; i<inputs.size(); i++) 
	   {			
			int peso = 1000;
			if(!inputs.get(i).getText().equals("")) 
			{
				peso = Integer.parseInt(inputs.get(i).getText());	
			}
			mapa.getAristas().get(i).setPeso(peso);
		}
		generarTO(mapa.getAristas());
	}
	
	public void generarTO(ArrayList<Arista> aristas) {
		
		this.aristasTOCompletas.clear();
		for(int i = 0; i<aristas.size(); i++) {
			this.aristasTOCompletas.add(new AristaTO(aristas.get(i).getPeso(),aristas.get(i).getVertice1().getNombre(),aristas.get(i).getVertice2().getNombre()));
		}
	}
	
	public JButton getCalcularRegionesButton() {
		return this.calcularRegionesButton;
	}
	public JButton getMostrarGrafoCompletoButton() {
		return this.mostrarGrafoCompletoButton;
	}
	public JTextField getCantRegionesInput() {
		return this.cantRegionesInput;
	}
	public ArrayList<JTextField> getInputsPesos(){
		return this.inputs;
	}
	public ArrayList<JTextArea> getTexts(){
		return this.texts;
	}
}


