package es.vsanchez.clinicaveterinaria.vista.paneles;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import es.vsanchez.clinicaveterinaria.Cliente;
import es.vsanchez.clinicaveterinaria.Gato;
import es.vsanchez.clinicaveterinaria.Perro;
import es.vsanchez.clinicaveterinaria.Roedor;

public class PanelRegistroCliente extends JPanel {

	private static final long serialVersionUID = 1L;


	public PanelRegistroCliente() {
		
		// Layout BORDERLAYAOUT
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
		panelMargenInferior.setPreferredSize(new Dimension(getWidth(), 90));
		add(panelMargenInferior, BorderLayout.SOUTH);
	}
	
	private JPanel construirPanelCentral() {
	
		// Se instancia un JPanel con un layout de tipo GRIDLAYOUT
		final JPanel panelCentral = new JPanel();
		panelCentral.setLayout(new GridLayout(12, 3, 100, 20));		
		
		/* Fila 1 */
		final JLabel etiquetaRegistroCliente = new JLabel("Registro Cliente");
		panelCentral.add(etiquetaRegistroCliente);
		panelCentral.add(new JPanel());
		panelCentral.add(new JPanel());
		
		/* Fila 2 */
		final JTextField campoNombreCliente = new JTextField("Nombre Cliente");
		panelCentral.add(campoNombreCliente);
		final JTextField campoDNICliente = new JTextField("DNI Cliente");
		panelCentral.add(campoDNICliente);
		panelCentral.add(new JPanel());

		/* Fila 3 */
		final JTextField campoDireccionCliente = new JTextField("Dirección Cliente");
		panelCentral.add(campoDireccionCliente);
		panelCentral.add(new JPanel());
		panelCentral.add(new JPanel());
		
		/* Fila 4 */
		final JLabel etiquetaDatosMascota = new JLabel("Datos mascota");
		panelCentral.add(etiquetaDatosMascota);
		panelCentral.add(new JPanel());
		panelCentral.add(new JPanel());
		
		/* Fila 5 */
		final JTextField campoNombreMascota = new JTextField("Nombre Mascota");
		panelCentral.add(campoNombreMascota);
		panelCentral.add(new JPanel());
		panelCentral.add(new JPanel());
		
		/* Fila 6 */
		JLabel etiquetaTipo = new JLabel("Tipo");
		panelCentral.add(etiquetaTipo);
		panelCentral.add(new JPanel());
		panelCentral.add(new JPanel());
				
		/* Fila 7 */
		final JRadioButton radioButtonGato = new JRadioButton("Gato");
		panelCentral.add(radioButtonGato);
		final JTextField campoColor = new JTextField("Color");
		campoColor.setEnabled(false);
		panelCentral.add(campoColor);
		final JRadioButton radioButtonMacho = new JRadioButton("Macho");
		panelCentral.add(radioButtonMacho);
		
		/* Fila 8 */
		final JRadioButton radioButtonPerro = new JRadioButton("Perro");
		panelCentral.add(radioButtonPerro);
		final JTextField campoRaza = new JTextField("Raza");
		campoRaza.setEnabled(false);
		panelCentral.add(campoRaza);
		final JRadioButton radioButtonHembra = new JRadioButton("Hembra");
		panelCentral.add(radioButtonHembra);
		
		/* Fila 9 */
		final JRadioButton radioButtonRoedor = new JRadioButton("Roedor");
		panelCentral.add(radioButtonRoedor);
		final JLabel etiquetaEspecializacionRoedor = new JLabel("Especialización de Roedor");
		etiquetaEspecializacionRoedor.setEnabled(false);
		panelCentral.add(etiquetaEspecializacionRoedor);
		panelCentral.add(new JPanel());
		
		/* Fila 10 */
		panelCentral.add(new JPanel());
		final JRadioButton radioButtonConejo = new JRadioButton("Conejo");
		radioButtonConejo.setEnabled(false);
		panelCentral.add(radioButtonConejo);
		panelCentral.add(new JPanel());
		
		
		/* Fila 11 */
		panelCentral.add(new JPanel());
		final JRadioButton radioButtonRaton = new JRadioButton("Ratón");
		radioButtonRaton.setEnabled(false);
		panelCentral.add(radioButtonRaton);
		panelCentral.add(new JPanel());
		
		/* Fila 12 */
		JButton buttonInsertar = new JButton("Insertar");
		panelCentral.add(buttonInsertar);
		panelCentral.add(new JPanel());
		panelCentral.add(new JPanel());

		
		// Agrupación de botones en grupo para evitar selección múltiple
		final ButtonGroup grupoTipoMascota = new ButtonGroup();
		grupoTipoMascota.add(radioButtonGato);
		grupoTipoMascota.add(radioButtonPerro);
		grupoTipoMascota.add(radioButtonRoedor);
		
		final ButtonGroup grupoTipoRoedor = new ButtonGroup();
		grupoTipoRoedor.add(radioButtonConejo);
		grupoTipoRoedor.add(radioButtonRaton);
				
		final ButtonGroup grupoGenero = new ButtonGroup();
		grupoGenero.add(radioButtonMacho);
		grupoGenero.add(radioButtonHembra);
		

		
		buttonInsertar.addActionListener(new ActionListener(){
			public void actionPerformed (ActionEvent e){
				// CREAR CLIENTE
				final Cliente clienteNuevo = new Cliente(campoNombreCliente.getText(), campoDNICliente.getText());
				// Falta añadir el cliente al array de clientes
				// listaClientes.add(clienteNuevo);
								
				// CREAR MASCOTA Y AÑADIRLA AL CLIENTE
				// CAMBIARRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRR - COMO PUEDO USAR EL SETGENERO y SETTIPO????
				String genero;
				
				if (radioButtonMacho.isSelected()) {
					genero = "macho";
				}
				
				else {
					genero = "hembra";
				}
			
				if (radioButtonGato.isSelected()) {
					final Gato gatoNuevo = new Gato (campoNombreMascota.getText(), "1", genero, campoColor.getText());
					clienteNuevo.addMascota(gatoNuevo);
				}
				
				if (radioButtonPerro.isSelected()) {
					final Perro perroNuevo = new Perro (campoNombreMascota.getText(), "2", genero, campoRaza.getText());
					clienteNuevo.addMascota(perroNuevo);
				}
				
				if (radioButtonRoedor.isSelected()) {
					String tipo;
					
					if (radioButtonConejo.isSelected()) {
						tipo = "conejo";
					}
					else {
						tipo = "ratón";
					}					
					
					final Roedor roedorNuevo = new Roedor (campoNombreMascota.getText(), "3", genero, tipo);
					clienteNuevo.addMascota(roedorNuevo);
				}
				
				System.out.println("El cliente es: " + clienteNuevo);
				
			}
		});

		ActionListener tipoMascotaActionListener = new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if (e.getSource().equals(radioButtonGato)) {
					campoColor.setEnabled(true);
					campoRaza.setEnabled(false);
					etiquetaEspecializacionRoedor.setEnabled(false);
					radioButtonRaton.setEnabled(false);
					radioButtonConejo.setEnabled(false);
				}
				if (e.getSource().equals(radioButtonPerro)){
					campoColor.setEnabled(false);
					campoRaza.setEnabled(true);
					etiquetaEspecializacionRoedor.setEnabled(false);
					radioButtonRaton.setEnabled(false);
					radioButtonConejo.setEnabled(false);
				}
				if (e.getSource().equals(radioButtonRoedor)) {
					campoColor.setEnabled(false);
					campoRaza.setEnabled(false);
					etiquetaEspecializacionRoedor.setEnabled(true);
					radioButtonRaton.setEnabled(true);
					radioButtonConejo.setEnabled(true);
				}
				
			}
		};
		
		radioButtonGato.addActionListener(tipoMascotaActionListener);
		radioButtonPerro.addActionListener(tipoMascotaActionListener);
		radioButtonRoedor.addActionListener(tipoMascotaActionListener);
		
		return panelCentral;
	}
	
	

	
}



