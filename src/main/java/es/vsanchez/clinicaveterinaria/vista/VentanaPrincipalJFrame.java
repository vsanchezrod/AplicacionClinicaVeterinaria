package es.vsanchez.clinicaveterinaria.vista;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import es.vsanchez.clinicaveterinaria.vista.paneles.PanelBienvenida;

public class VentanaPrincipalJFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel panelPrincipal;

	public VentanaPrincipalJFrame() {

		super("Clínica Veterinaria VETILERNA");

		configurarVentana();

		// MenuBarPrincipal menuPrincipal = new MenuBarPrincipal(); ==> setJMenuBar(menuPrincipal);
		setJMenuBar(new MenuBarPrincipal(this));
		panelPrincipal = new PanelBienvenida();
		add(panelPrincipal, BorderLayout.CENTER);
		setVisible(true);
	}

	// Método que setea el panel que se va a mostrar en el JFrame
	public void setPanelPrincipal(JPanel panel) {

		remove(panelPrincipal);
		panelPrincipal = panel;
		add(panelPrincipal, BorderLayout.CENTER);
		panelPrincipal.updateUI();
	}

	// Configura el JFrame
	private void configurarVentana() {

		setSize(1200, 800);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
	}
}
