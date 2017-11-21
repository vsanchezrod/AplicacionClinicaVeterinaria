package es.vsanchez.clinicaveterinaria.vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import es.vsanchez.clinicaveterinaria.vista.paneles.PanelNuevaMascota;
import es.vsanchez.clinicaveterinaria.vista.paneles.PanelRegistroCliente;
import es.vsanchez.clinicaveterinaria.vista.paneles.PanelTratamiento;

public class MenuBarPrincipal extends JMenuBar {

	private static final long serialVersionUID = 1L;
	private JMenuItem registro, nuevaMascota, tratamiento;
	private VentanaPrincipalJFrame ventanaPrincipalJFrame;
	
	// Constructor de la clase MenuBarPrincipal
	public MenuBarPrincipal(VentanaPrincipalJFrame ventanaPrincipal) {

		this.ventanaPrincipalJFrame = ventanaPrincipal;
		JMenu menuOpciones = crearMenuOpciones();
		add(menuOpciones);
	}

	// Método de clase que crea los elementos del menu así como el evento de cambiar de panel
	private JMenu crearMenuOpciones() {

		// Evento para cambiar el panel que se muestra a través del menu
		ActionListener menuActionListener = new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				if (e.getSource().equals(registro)) {
					ventanaPrincipalJFrame.setPanelPrincipal(new PanelRegistroCliente());
				} else if (e.getSource().equals(nuevaMascota)) {
					ventanaPrincipalJFrame.setPanelPrincipal(new PanelNuevaMascota());
				} else if (e.getSource().equals(tratamiento)) {
					ventanaPrincipalJFrame.setPanelPrincipal(new PanelTratamiento());
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
