package es.vsanchez.clinicaveterinaria.vista.paneles;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class PanelTratamiento extends JPanel {

	private static final long serialVersionUID = 1L;

	public PanelTratamiento() {
		
		//add(construirPanelCentral());
		
		setLayout(new BorderLayout());

		JPanel panelMargenSuperior = new JPanel();
		panelMargenSuperior.setPreferredSize(new Dimension(getWidth(), 20));
		add(panelMargenSuperior, BorderLayout.NORTH);

		JPanel panelMargenIzquierdo = new JPanel();
		panelMargenIzquierdo.setPreferredSize(new Dimension(100, getHeight()));
		add(panelMargenIzquierdo, BorderLayout.WEST);

		JPanel panelContenidoCentral = construirPanelCentral();
		add(panelContenidoCentral, BorderLayout.CENTER);
		
		JPanel panelMargenDerecho = new JPanel();
		panelMargenDerecho.setPreferredSize(new Dimension(50, getHeight()));
		add(panelMargenDerecho, BorderLayout.EAST);

		JPanel panelMargenInferior = new JPanel();
		panelMargenInferior.setPreferredSize(new Dimension(getWidth(), 100));
		add(panelMargenInferior, BorderLayout.SOUTH);
		
	}
	
	private JPanel construirPanelCentral() {
		
		JPanel panelCentral = new JPanel();
		panelCentral.setLayout(new GridBagLayout());
		GridBagConstraints gridConstraints = new GridBagConstraints();
		gridConstraints.insets = new Insets(5,50,5,30);
				
		
		/* Fila 1*/
		JTextField campoDNICliente = new JTextField("DNI Cliente");
		gridConstraints.fill = GridBagConstraints.HORIZONTAL;
		gridConstraints.anchor = GridBagConstraints.EAST;
		gridConstraints.gridx = 0;
		gridConstraints.gridy = 0;
		gridConstraints.gridwidth = 1;
		gridConstraints.gridheight = 1;
		campoDNICliente.setPreferredSize(new Dimension(200, 20));
		panelCentral.add(campoDNICliente, gridConstraints);
		
		JButton buttonBuscar = new JButton("Buscar");
		gridConstraints.fill = GridBagConstraints.HORIZONTAL;
		gridConstraints.anchor = GridBagConstraints.EAST;
		gridConstraints.gridx = 1;
		gridConstraints.gridy = 0;
		gridConstraints.gridwidth = 1;
		gridConstraints.gridheight = 1;
		panelCentral.add(buttonBuscar, gridConstraints);
		
		JComboBox<String> comboBoxMascotas = new JComboBox<String>();
		comboBoxMascotas.addItem("Mascotas");
		gridConstraints.fill = GridBagConstraints.HORIZONTAL;
		gridConstraints.anchor = GridBagConstraints.EAST;
		gridConstraints.gridx = 2;
		gridConstraints.gridy = 0;
		gridConstraints.gridwidth = 1;
		gridConstraints.gridheight = 1;
		comboBoxMascotas.setPreferredSize(new Dimension(200, 20));
		panelCentral.add(comboBoxMascotas, gridConstraints);
		
		/* Fila 2*/
		JLabel etiquetaDatosMascota = new JLabel("Datos mascota");
		gridConstraints.fill = GridBagConstraints.HORIZONTAL;
		gridConstraints.anchor = GridBagConstraints.EAST;
		gridConstraints.gridx = 0;
		gridConstraints.gridy = 1;
		gridConstraints.gridwidth = 1;
		gridConstraints.gridheight = 1;
		panelCentral.add(etiquetaDatosMascota, gridConstraints);
	
		/* Fila 3*/
		JLabel etiquetaTratamiento = new JLabel("Tratamiento");
		gridConstraints.fill = GridBagConstraints.HORIZONTAL;
		gridConstraints.anchor = GridBagConstraints.EAST;
		gridConstraints.gridx = 0;
		gridConstraints.gridy = 2;
		gridConstraints.gridwidth = 1;
		gridConstraints.gridheight = 1;
		gridConstraints.insets = new Insets(50, 50, -35, 50);
		panelCentral.add(etiquetaTratamiento, gridConstraints);
	
		/* Fila 4*/
		
		JTextField campoFecha = new JTextField("Fecha");
		gridConstraints.fill = GridBagConstraints.HORIZONTAL;
		gridConstraints.anchor = GridBagConstraints.EAST;
		gridConstraints.gridx = 0;
		gridConstraints.gridy = 3;
		gridConstraints.gridwidth = 1;
		gridConstraints.gridheight = 1;
		campoFecha.setEnabled(false);
		campoFecha.setPreferredSize(new Dimension(200, 20));
		panelCentral.add(campoFecha, gridConstraints);
		
		JTextField campoTratamiento = new JTextField("Tratamiento");
		gridConstraints.fill = GridBagConstraints.HORIZONTAL;
		gridConstraints.anchor = GridBagConstraints.EAST;
		gridConstraints.gridx = 1;
		gridConstraints.gridy = 3;
		gridConstraints.gridwidth = 1;
		gridConstraints.gridheight = 1;
		campoTratamiento.setEnabled(false);
		campoTratamiento.setPreferredSize(new Dimension(200, 20));
		panelCentral.add(campoTratamiento, gridConstraints);

		JButton buttonAnadir = new JButton("Añadir");
		gridConstraints.fill = GridBagConstraints.HORIZONTAL;
		gridConstraints.anchor = GridBagConstraints.WEST;
		gridConstraints.gridx = 2;
		gridConstraints.gridy = 3;
		gridConstraints.gridwidth = 1;
		gridConstraints.gridheight = 1;
		panelCentral.add(buttonAnadir, gridConstraints);

		/* Fila 5*/
		JTextArea textAreaTratamiento = new JTextArea();
		gridConstraints.fill = GridBagConstraints.HORIZONTAL;
		gridConstraints.anchor = GridBagConstraints.WEST;
		gridConstraints.gridx = 0;
		gridConstraints.gridy = 4;
		gridConstraints.gridwidth = 2;
		gridConstraints.gridheight = 1;
		textAreaTratamiento.setEnabled(false);
		textAreaTratamiento.setPreferredSize(new Dimension(450, 400));
		panelCentral.add(textAreaTratamiento, gridConstraints);
		
		return panelCentral; 
	}
			
}
