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
		gridConstraints.insets = new Insets(10,0,10,100);
				
		
		/* Fila 1*/
		JTextField campoDNICliente = new JTextField("DNI Cliente");
		gridConstraints.anchor = GridBagConstraints.WEST;
		gridConstraints.gridx = 0;
		gridConstraints.gridy = 0;
		gridConstraints.gridwidth = 1;
		gridConstraints.gridheight = 1;
		gridConstraints.weightx = 2.0;
		campoDNICliente.setPreferredSize(new Dimension(300, 30));
		panelCentral.add(campoDNICliente, gridConstraints);
		
		JButton buttonBuscar = new JButton("Buscar");
		gridConstraints.anchor = GridBagConstraints.WEST;
		gridConstraints.gridx = 1;
		gridConstraints.gridy = 0;
		gridConstraints.gridwidth = 1;
		gridConstraints.gridheight = 1;
		buttonBuscar.setPreferredSize(new Dimension(100, 30));
		panelCentral.add(buttonBuscar, gridConstraints);
		
		JComboBox<String> comboBoxMascotas = new JComboBox<String>();
		comboBoxMascotas.addItem("Mascotas");
		gridConstraints.anchor = GridBagConstraints.WEST;
		gridConstraints.gridx = 2;
		gridConstraints.gridy = 0;
		gridConstraints.gridwidth = 1;
		gridConstraints.gridheight = 1;
		gridConstraints.weightx = 2.0;
		comboBoxMascotas.setPreferredSize(new Dimension(300, 30));
		gridConstraints.insets = new Insets(10,0,10,0);
		panelCentral.add(comboBoxMascotas, gridConstraints);
		
		/* Fila 2*/
		JLabel etiquetaDatosMascota = new JLabel("Datos mascota");
		gridConstraints.anchor = GridBagConstraints.WEST;
		gridConstraints.gridx = 0;
		gridConstraints.gridy = 1;
		gridConstraints.gridwidth = 1;
		gridConstraints.gridheight = 1;
		gridConstraints.insets = new Insets(0,0,50,0);
		panelCentral.add(etiquetaDatosMascota, gridConstraints);
	
		/* Fila 3*/
		JLabel etiquetaTratamiento = new JLabel("Tratamiento");
		gridConstraints.anchor = GridBagConstraints.WEST;
		gridConstraints.gridx = 0;
		gridConstraints.gridy = 2;
		gridConstraints.gridwidth = 1;
		gridConstraints.gridheight = 1;
		gridConstraints.insets = new Insets(10,0,10,20);
		panelCentral.add(etiquetaTratamiento, gridConstraints);
	
		/* Fila 4*/
		
		JTextField campoFecha = new JTextField("Fecha");
		gridConstraints.anchor = GridBagConstraints.WEST;
		gridConstraints.gridx = 0;
		gridConstraints.gridy = 3;
		gridConstraints.gridwidth = 1;
		gridConstraints.gridheight = 1;
		gridConstraints.weightx = 1.0;
		campoFecha.setEnabled(false);
		campoFecha.setPreferredSize(new Dimension(300, 30));
		panelCentral.add(campoFecha, gridConstraints);
		
		JTextField campoTratamiento = new JTextField("Tratamiento");
		gridConstraints.anchor = GridBagConstraints.WEST;
		gridConstraints.gridx = 1;
		gridConstraints.gridy = 3;
		gridConstraints.gridwidth = 1;
		gridConstraints.gridheight = 1;
		gridConstraints.weightx = 1.0;
		campoTratamiento.setEnabled(false);
		campoTratamiento.setPreferredSize(new Dimension(300, 30));
		panelCentral.add(campoTratamiento, gridConstraints);

		JButton buttonAnadir = new JButton("Añadir");
		//gridConstraints.fill = GridBagConstraints.NONE;
		gridConstraints.anchor = GridBagConstraints.EAST;
		gridConstraints.gridx = 2;
		gridConstraints.gridy = 3;
		gridConstraints.gridwidth = 1;
		gridConstraints.gridheight = 1;
		gridConstraints.weightx = 1.0;
		gridConstraints.insets = new Insets(10, 0, 0, 10);
		buttonAnadir.setPreferredSize(new Dimension(100, 30));
		panelCentral.add(buttonAnadir, gridConstraints);

		/* Fila 5*/
		JTextArea textAreaTratamiento = new JTextArea();
		gridConstraints.fill = GridBagConstraints.NONE;
		gridConstraints.anchor = GridBagConstraints.WEST;
		gridConstraints.gridx = 0;
		gridConstraints.gridy = 4;
		gridConstraints.gridwidth = 2;
		gridConstraints.gridheight = 1;
		gridConstraints.weightx = 3.0;
		textAreaTratamiento.setEnabled(false);
		textAreaTratamiento.setPreferredSize(new Dimension(710, 400));
		panelCentral.add(textAreaTratamiento, gridConstraints);
		
		return panelCentral; 
	}
			
}
