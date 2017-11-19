package es.vsanchez.clinicaveterinaria.vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import es.vsanchez.clinicaveterinaria.vista.paneles.PanelNuevaMascota;
import es.vsanchez.clinicaveterinaria.vista.paneles.PanelRegistroCliente;

public class MenuBarPrincipal extends JMenuBar {

	private static final long serialVersionUID = 1L;
	private JMenuItem registro, nuevaMascota, tratamiento;
	private VentanaPrincipalJFrame ventanaPrincipalJFrame;
	
	public MenuBarPrincipal(VentanaPrincipalJFrame ventanaPrincipal) {

		this.ventanaPrincipalJFrame = ventanaPrincipal;
		JMenu menuOpciones = crearMenuOpciones();
		add(menuOpciones);
	}

	private JMenu crearMenuOpciones() {

		ActionListener menuActionListener = new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				System.out.println("Evento: " + e.getSource());
				if (e.getSource().equals(registro)) {
					System.out.println("Hemos pulsado en registro");
					ventanaPrincipalJFrame.setPanelPrincipal(new PanelRegistroCliente());
				} else if (e.getSource().equals(nuevaMascota)) {
					System.out.println("Hemos pulsado en nuevaMascota");
					ventanaPrincipalJFrame.setPanelPrincipal(new PanelNuevaMascota());
				} else if (e.getSource().equals(tratamiento)) {
					System.out.println("Hemos pulsado en tratamiento");
					// ventanaPrincipalJFrame.setPanelPrincipal(new PanelBienvenida());
				}
			}
		};

		JMenu menuOpciones = new JMenu("Opciones", true);
		registro = new JMenuItem("Registro Cliente");
		registro.addActionListener(menuActionListener);
		nuevaMascota = new JMenuItem("Registrar Mascota");
		nuevaMascota.addActionListener(menuActionListener);
		tratamiento = new JMenuItem("Nuevo tratamiento");
		tratamiento.addActionListener(menuActionListener);

		menuOpciones.add(registro);
		menuOpciones.add(nuevaMascota);
		menuOpciones.add(tratamiento);

		return menuOpciones;
	}

}
