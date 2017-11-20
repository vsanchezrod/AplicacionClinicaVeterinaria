package es.vsanchez.clinicaveterinaria.vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

import es.vsanchez.clinicaveterinaria.vista.paneles.PanelBienvenida;

public class VentanaPrincipalJFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel panelPrincipal;

	public VentanaPrincipalJFrame() {

		super("Clínica Veterinaria VETILERNA");

		configurarVentana();

		// MenuBarPrincipal menuPrincipal = new MenuBarPrincipal(); ==>
		// setJMenuBar(menuPrincipal);
		setJMenuBar(new MenuBarPrincipal(this));
		//panelPrincipal = new PanelBienvenida();
		panelPrincipal = new PanelBienvenida();
		add(panelPrincipal, BorderLayout.CENTER);

		setVisible(true);

	}

	public void setPanelPrincipal(JPanel panel) {

		remove(panelPrincipal);
		panelPrincipal = panel;
		add(panelPrincipal, BorderLayout.CENTER);
		panelPrincipal.updateUI();
	}

	private void configurarVentana() {

		// Se tiene que detectar la resolucion de pantalla
		Toolkit pantallaDispositivo = Toolkit.getDefaultToolkit();

		// Se almacena en un objeto de tipo dimension el tamaño de la pantalla
		Dimension tamanoPantalla = pantallaDispositivo.getScreenSize();
		System.out.println(tamanoPantalla);

		// Esta clase Dimension tiene dos atributos de clase height y width, y vamos a
		// guardar su valor en dos variables nuevas
		int alturaPantalla = tamanoPantalla.height;
		int anchoPantalla = tamanoPantalla.width;

		// Vamos a crear configurar el tamaño del FRAME para que ocupe la mitad del
		// tamañó de la pantalla en anchura y altura
		
		setSize(1200,800);
		//setSize(anchoPantalla/2, alturaPantalla/2);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
	}

}
