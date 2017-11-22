package es.vsanchez.clinicaveterinaria.vista.paneles;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelBienvenida extends JPanel {

	private static final long serialVersionUID = 1L;

	public PanelBienvenida() {

		// Se le asigna un layout de tipo BorderLayout
		setLayout(new BorderLayout());
		
		JLabel etiquetaBienvenida = new JLabel("Bienvenido a la Clínica VetIlerna");
		etiquetaBienvenida.setHorizontalAlignment(JLabel.CENTER);
		
		add(etiquetaBienvenida, BorderLayout.CENTER);
	}
}
