package interfazGrafica;

import java.awt.EventQueue;
import javax.swing.JFrame;




public class Pantalla {

	private JFrame frame;
	private Mapa mapa;
	private Menu menu;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pantalla window = new Pantalla();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Pantalla() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 1050, 1050);	
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		this.mapa = new Mapa();		
		this.menu = new Menu(mapa);		
		menu.getMostrarGrafoCompletoButton().setLocation(35, 927);
		menu.getCalcularRegionesButton().setLocation(308, 927);
		menu.getCantRegionesInput().setLocation(229, 847);
		frame.getContentPane().add(menu);
		frame.getContentPane().add(mapa);		
			
		
	}
}
