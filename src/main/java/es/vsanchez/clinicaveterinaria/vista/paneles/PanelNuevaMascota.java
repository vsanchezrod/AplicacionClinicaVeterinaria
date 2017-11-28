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
import es.vsanchez.clinicaveterinaria.vista.VentanaPrincipalJFrame;

public class PanelNuevaMascota extends JPanel {

	private static final long serialVersionUID = 1L;
	private VentanaPrincipalJFrame ventanaPrincipalJFrame;
	
	public PanelNuevaMascota(VentanaPrincipalJFrame ventanaPrincipal) {

		this.ventanaPrincipalJFrame = ventanaPrincipal;
		
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

		final JPanel panelCentral = new JPanel();
		panelCentral.setLayout(new GridLayout(12, 3, 100, 20));

		/* Fila 1 */
		final JLabel etiquetaIntroduceCliente = new JLabel("Introduce el DNI del cliente");
		panelCentral.add(etiquetaIntroduceCliente);
		panelCentral.add(new JPanel());
		panelCentral.add(new JPanel());

		/* Fila 2 */
		final JTextField campoDNICliente = new JTextField("DNI Cliente");
		panelCentral.add(campoDNICliente);
		JButton buttonBuscar = new JButton("Buscar");
		panelCentral.add(buttonBuscar);
		panelCentral.add(new JPanel());

		/* Fila 3 */
		panelCentral.add(new JPanel());
		panelCentral.add(new JPanel());
		panelCentral.add(new JPanel());

		/* Fila 4 */
		panelCentral.add(new JPanel());
		panelCentral.add(new JPanel());
		panelCentral.add(new JPanel());

		/* Fila 5 */
		final JTextField campoNombreMascota = new JTextField("Nombre Mascota");
		panelCentral.add(campoNombreMascota);
		panelCentral.add(new JPanel());
		panelCentral.add(new JPanel());

		/* Fila 6 */
		panelCentral.add(new JPanel());
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
		panelCentral.add(new JPanel());
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
		final JButton buttonInsertar = new JButton("Insertar");
		panelCentral.add(buttonInsertar);
		panelCentral.add(new JPanel());
		panelCentral.add(new JPanel());
		
		// Agrupación de botones en grupo para evitar selección múltiple
		ButtonGroup grupoTipoMascota = new ButtonGroup();
		grupoTipoMascota.add(radioButtonGato);
		grupoTipoMascota.add(radioButtonPerro);
		grupoTipoMascota.add(radioButtonRoedor);
		
		ButtonGroup grupoTipoRoedor = new ButtonGroup();
		grupoTipoRoedor.add(radioButtonConejo);
		grupoTipoRoedor.add(radioButtonRaton);
				
		ButtonGroup grupoGenero = new ButtonGroup();
		grupoGenero.add(radioButtonMacho);
		grupoGenero.add(radioButtonHembra);
		
		
		// EVENTO EN EL BOTÓN BUSCAR - Buscará el DNI del Cliente introducido.
		buttonBuscar.addActionListener(new ActionListener(){
			public void actionPerformed (ActionEvent e){
			
				// REVISAR ALGO FALLA
				
				/*for(int i = 0; i < listaClientes.size(); i++) {
					
					Cliente cliente = listaClientes.get(i);
					
					if (campoDNICliente.getText() = cliente.getDni()) {
						
						System.out.println("Se ha encontrado el cliente con DNI: " + cliente.getDni());
					}
				}*/							
			}
		});
		
		buttonInsertar.addActionListener(new ActionListener(){
			public void actionPerformed (ActionEvent e){
											
				// SI EL USUARIO NO EXISTE:
				System.out.println("No existe cliente con DNI: " + campoDNICliente.getText());
				
				
				
				
				// SI EL USUARIO EXISTE: ===> CREAR MASCOTA Y AÑADIRLA AL CLIENTE
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
					
					// AQUI HAY QUE PONER EL NOMBRE DEL OBJETO CLIENTE clienteNuevo.addMascota(gatoNuevo);
				}
				
				if (radioButtonPerro.isSelected()) {
					final Perro perroNuevo = new Perro (campoNombreMascota.getText(), "2", genero, campoRaza.getText());
					// AQUI HAY QUE PONER EL NOMBRE DEL OBJETO CLIENTE clienteNuevo.addMascota(perroNuevo);
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
					// AQUI HAY QUE PONER EL NOMBRE DEL OBJETO CLIENTE clienteNuevo.addMascota(roedorNuevo);
				}
				
			}
		});

		ActionListener tipoMascotaActionListener = new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if (e.getSource().equals(radioButtonGato)) {
					campoColor.setEnabled(true);
					campoRaza.setEnabled(false);
					//etiquetaEspecializacionRoedor.setEnabled(false);           EN ESTE PANEL NO EXISTE ESTA ETIQUETA
					radioButtonRaton.setEnabled(false);
					radioButtonConejo.setEnabled(false);
				}
				if (e.getSource().equals(radioButtonPerro)){
					campoColor.setEnabled(false);
					campoRaza.setEnabled(true);
					//etiquetaEspecializacionRoedor.setEnabled(false);           EN ESTE PANEL NO EXISTE ESTA ETIQUETA
					radioButtonRaton.setEnabled(false);
					radioButtonConejo.setEnabled(false);
				}
				if (e.getSource().equals(radioButtonRoedor)) {
					campoColor.setEnabled(false);
					campoRaza.setEnabled(false);
					//etiquetaEspecializacionRoedor.setEnabled(true);            EN ESTE PANEL NO EXISTE ESTA ETIQUETA
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
