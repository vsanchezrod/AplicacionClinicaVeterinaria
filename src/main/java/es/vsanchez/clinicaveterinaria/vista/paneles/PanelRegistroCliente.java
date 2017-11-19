package es.vsanchez.clinicaveterinaria.vista.paneles;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class PanelRegistroCliente extends JPanel {

	private static final long serialVersionUID = 1L;


	public PanelRegistroCliente() {
		
		//setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		setLayout(new BorderLayout());
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
		panelCentral.setLayout(new GridLayout(12, 3, 100, 20));		
		
		/* Fila 1 */
		JLabel etiquetaRegistroCliente = new JLabel("Registro Cliente");
		panelCentral.add(etiquetaRegistroCliente);
		panelCentral.add(new JPanel());
		panelCentral.add(new JPanel());
		
		/* Fila 2 */
		JTextField campoNombreCliente = new JTextField("Nombre Cliente");
		campoNombreCliente.setPreferredSize(new Dimension(50, 20));
		panelCentral.add(campoNombreCliente);
		JTextField campoDNICliente = new JTextField("DNI Cliente");
		panelCentral.add(campoDNICliente);
		panelCentral.add(new JPanel());

		/* Fila 3 */
		JTextField campoDireccionCliente = new JTextField("Dirección Cliente");
		panelCentral.add(campoDireccionCliente);
		panelCentral.add(new JPanel());
		panelCentral.add(new JPanel());
		
		/* Fila 4 */
		JLabel etiquetaDatosMascota = new JLabel("Datos mascota");
		panelCentral.add(etiquetaDatosMascota);
		panelCentral.add(new JPanel());
		panelCentral.add(new JPanel());
		
		/* Fila 5 */
		JTextField campoNombreMascota = new JTextField("Nombre Mascota");
		panelCentral.add(campoNombreMascota);
		panelCentral.add(new JPanel());
		panelCentral.add(new JPanel());
		
		/* Fila 6 */
		JLabel etiquetaTipo = new JLabel("Tipo");
		panelCentral.add(etiquetaTipo);
		panelCentral.add(new JPanel());
		panelCentral.add(new JPanel());
				
		/* Fila 7 */
		JRadioButton radioButtonGato = new JRadioButton("Gato");
		panelCentral.add(radioButtonGato);
		JTextField campoColor = new JTextField("Color");
		campoColor.setEnabled(false);
		panelCentral.add(campoColor);
		JRadioButton radioButtonMacho = new JRadioButton("Macho");
		panelCentral.add(radioButtonMacho);
		
		/* Fila 8 */
		JRadioButton radioButtonPerro = new JRadioButton("Perro");
		panelCentral.add(radioButtonPerro);
		JTextField campoRaza = new JTextField("Raza");
		campoRaza.setEnabled(false);
		panelCentral.add(campoRaza);
		JRadioButton radioButtonHembra = new JRadioButton("Hembra");
		panelCentral.add(radioButtonHembra);
		
		/* Fila 9 */
		JRadioButton radioButtonRoedor = new JRadioButton("Roedor");
		panelCentral.add(radioButtonRoedor);
		JLabel etiquetaEspecializacionRoedor = new JLabel("Especialización de Roedor");
		etiquetaEspecializacionRoedor.setEnabled(false);
		panelCentral.add(etiquetaEspecializacionRoedor);
		panelCentral.add(new JPanel());
		
		/* Fila 10 */
		panelCentral.add(new JPanel());
		JRadioButton radioButtonConejo = new JRadioButton("Conejo");
		radioButtonConejo.setEnabled(false);
		panelCentral.add(radioButtonConejo);
		panelCentral.add(new JPanel());
		
		
		/* Fila 11 */
		panelCentral.add(new JPanel());
		JRadioButton radioButtonRaton = new JRadioButton("Ratón");
		radioButtonRaton.setEnabled(false);
		panelCentral.add(radioButtonRaton);
		panelCentral.add(new JPanel());
		
		/* Fila 12 */
		JButton buttonInsertar = new JButton("Insertar");
		panelCentral.add(buttonInsertar);
		panelCentral.add(new JPanel());
		panelCentral.add(new JPanel());

		return panelCentral;
	}
}