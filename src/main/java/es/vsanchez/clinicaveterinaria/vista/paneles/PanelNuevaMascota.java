package es.vsanchez.clinicaveterinaria.vista.paneles;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelNuevaMascota extends JPanel{

	private static final long serialVersionUID = 1L;

	public PanelNuevaMascota() {
		setLayout(new BorderLayout());
		JLabel panelNuevaMascota = new JLabel("Nueva Mascota");
		panelNuevaMascota.setHorizontalAlignment(JLabel.CENTER);
		add(panelNuevaMascota, BorderLayout.CENTER);
	}
}
