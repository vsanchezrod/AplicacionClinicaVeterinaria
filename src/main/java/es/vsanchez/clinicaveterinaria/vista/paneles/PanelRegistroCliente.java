package es.vsanchez.clinicaveterinaria.vista.paneles;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import es.vsanchez.clinicaveterinaria.modelo.Cliente;
import es.vsanchez.clinicaveterinaria.modelo.Gato;
import es.vsanchez.clinicaveterinaria.modelo.Mascota;
import es.vsanchez.clinicaveterinaria.modelo.Perro;
import es.vsanchez.clinicaveterinaria.modelo.Roedor;
import es.vsanchez.clinicaveterinaria.modelo.excepciones.DniInvalidoException;
import es.vsanchez.clinicaveterinaria.persistencia.ServicioClientes;
import es.vsanchez.clinicaveterinaria.vista.VentanaPrincipalJFrame;

public class PanelRegistroCliente extends JPanel {

	private static final long serialVersionUID = 1L;
	private VentanaPrincipalJFrame ventanaPrincipalJFrame;
	private ServicioClientes servicioClientes;

	public PanelRegistroCliente(VentanaPrincipalJFrame ventanaPrincipal) {
		
		this.ventanaPrincipalJFrame = ventanaPrincipal;
		servicioClientes = ventanaPrincipal.getServicioClientes();
		
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
		
		// Se han establecido por defecto los radiobuttons marcados de : gato, color, conejo y macho
		// A fin de evitar que se queden datos sin rellenar de la mascota.
		
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
		final JLabel etiquetaValidacionDNI = new JLabel();
		panelCentral.add(etiquetaValidacionDNI);
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
		radioButtonGato.setSelected(true);
		panelCentral.add(radioButtonGato);
		final JTextField campoColor = new JTextField("Color");
		panelCentral.add(campoColor);
		final JRadioButton radioButtonMacho = new JRadioButton("Macho");
		radioButtonMacho.setSelected(true);
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
		radioButtonConejo.setSelected(true);
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
		

		// Evento que ocurre cuando se presiona el botón añadir del panel
		buttonInsertar.addActionListener(new ActionListener(){
			public void actionPerformed (ActionEvent e){
				
				// Se comprueba si ya existe el cliente
				final boolean existeCliente = servicioClientes.comprobarSiExisteClientePorDNI(campoDNICliente.getText().toUpperCase());
				
				if (existeCliente) {
					System.out.println("ERROR! Ese cliente ya existe.");
					etiquetaValidacionDNI.setText("El cliente ya existe!");
					reiniciarFormulario(campoNombreCliente, campoDNICliente, campoDireccionCliente, campoNombreMascota, campoColor, campoRaza);
				}
				
				else {
					// CREA CLIENTE
					final Cliente clienteNuevo = new Cliente(campoNombreCliente.getText(), campoDNICliente.getText().toUpperCase());
									
					// CREA MASCOTA Y SE LA AÑADE AL CLIENTE
					String genero;
					Mascota mascotaCliente = null;
					
					if (radioButtonMacho.isSelected()) {
						genero = "macho";
					}
					
					else {
						genero = "hembra";
					}
				
					if (radioButtonGato.isSelected()) {
						mascotaCliente = new Gato (campoNombreMascota.getText(), ventanaPrincipalJFrame.generarCodigo(), genero, campoColor.getText());
						clienteNuevo.addMascota(mascotaCliente);
					}
					
					if (radioButtonPerro.isSelected()) {
						mascotaCliente = new Perro (campoNombreMascota.getText(), ventanaPrincipalJFrame.generarCodigo(), genero, campoRaza.getText());
						clienteNuevo.addMascota(mascotaCliente);
					}
					
					if (radioButtonRoedor.isSelected()) {
						String tipo;
						
						if (radioButtonConejo.isSelected()) {
							tipo = "conejo";
						}
						else {
							tipo = "ratón";
						}					
						
						mascotaCliente = new Roedor (campoNombreMascota.getText(), ventanaPrincipalJFrame.generarCodigo(), genero, tipo);
						clienteNuevo.addMascota(mascotaCliente);
					}
					
					// Añadimos el cliente, utilizando excepciones
					try {
						try {
							servicioClientes.addCliente(clienteNuevo);
							servicioClientes.addMascotaAlCliente(clienteNuevo, mascotaCliente);
							// Se reinicia el formulario para poder ser usado nuevamente
							reiniciarFormulario(campoNombreCliente, campoDNICliente, campoDireccionCliente,campoNombreMascota, campoColor, campoRaza);
						} catch (IOException e1) {
							System.out.println("La lista de clientes no ha podido ser guardada en el fichero");
							reiniciarCampoDni(campoDNICliente);
						}
						System.out.println("Cliente: " + clienteNuevo);
						resetearEtiquetaDNI(etiquetaValidacionDNI);
					
					} catch (DniInvalidoException dniInvalidoException) {
						dniInvalidoException.printStackTrace();
						etiquetaValidacionDNI.setText("DNI inválido!");
					}
									
				}
								
			}
		});

		// Este actionlistener, controla los campos y botones que se pueden usar en función de la mascota elegida.
		ActionListener tipoMascotaActionListener = new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if (e.getSource().equals(radioButtonGato)) {
					campoColor.setEnabled(true);
					campoRaza.setText("raza");
					campoRaza.setEnabled(false);
					etiquetaEspecializacionRoedor.setEnabled(false);
					radioButtonRaton.setEnabled(false);
					radioButtonConejo.setEnabled(false);
				}
				if (e.getSource().equals(radioButtonPerro)){
					campoColor.setText("color");
					campoColor.setEnabled(false);
					campoRaza.setEnabled(true);
					etiquetaEspecializacionRoedor.setEnabled(false);
					radioButtonRaton.setEnabled(false);
					radioButtonConejo.setEnabled(false);
				}
				if (e.getSource().equals(radioButtonRoedor)) {
					campoColor.setText("color");
					campoColor.setEnabled(false);
					campoRaza.setText("raza");
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
	
	// Método que reinicia el formulario de registro
	private void reiniciarFormulario(JTextField nombre, JTextField dni, JTextField direccion, JTextField mascota, JTextField color, JTextField raza) {
		
		nombre.setText("Nombre Cliente");
		dni.setText("DNI Cliente");
		direccion.setText("Dirección Cliente");
		mascota.setText("Nombre Mascota");
		color.setText("color");
		raza.setText("raza");
	}

	private void resetearEtiquetaDNI(JLabel etiquetaValidacionDNI) {
		etiquetaValidacionDNI.setText("");
	}
	
	private void reiniciarCampoDni(JTextField dni) {
		dni.setText("Introduce DNI válido");
	}
}



