package es.vsanchez.clinicaveterinaria.vista.paneles;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import es.vsanchez.clinicaveterinaria.Cliente;
import es.vsanchez.clinicaveterinaria.Mascota;
import es.vsanchez.clinicaveterinaria.vista.VentanaPrincipalJFrame;

public class PanelTratamiento extends JPanel {

	private static final long serialVersionUID = 1L;
	private VentanaPrincipalJFrame ventanaPrincipalJFrame;
	private Cliente clienteBuscado;
	
	public PanelTratamiento(VentanaPrincipalJFrame ventanaPrincipal) {
		
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
		
		// Se instancia un JPanel con un layout de tipo GRIDBAGLAYAOUT
		final JPanel panelCentral = new JPanel();
		panelCentral.setLayout(new GridBagLayout());
		
		// Se instancia un objeto de la clase GridBagConstraints para configurar las celdas
		GridBagConstraints gridConstraints = new GridBagConstraints();
		gridConstraints.insets = new Insets(10,0,10,100);
				
		/* Fila 1*/
		final JTextField campoDNICliente = new JTextField("DNI Cliente");
		gridConstraints.anchor = GridBagConstraints.WEST;
		gridConstraints.gridx = 0;
		gridConstraints.gridy = 0;
		gridConstraints.gridwidth = 1;
		gridConstraints.gridheight = 1;
		campoDNICliente.setPreferredSize(new Dimension(300, 30));
		panelCentral.add(campoDNICliente, gridConstraints);
		
		final JButton buttonBuscar = new JButton("Buscar");
		gridConstraints.anchor = GridBagConstraints.WEST;
		gridConstraints.gridx = 1;
		gridConstraints.gridy = 0;
		gridConstraints.gridwidth = 1;
		gridConstraints.gridheight = 1;
		buttonBuscar.setPreferredSize(new Dimension(100, 30));
		panelCentral.add(buttonBuscar, gridConstraints);
		
		final JComboBox<String> comboBoxMascotas = new JComboBox<String>();
		comboBoxMascotas.addItem("Mascotas");
		gridConstraints.anchor = GridBagConstraints.WEST;
		gridConstraints.gridx = 2;
		gridConstraints.gridy = 0;
		gridConstraints.gridwidth = 1;
		gridConstraints.gridheight = 1;
		comboBoxMascotas.setPreferredSize(new Dimension(300, 30));
		gridConstraints.insets = new Insets(10,0,10,0);
		panelCentral.add(comboBoxMascotas, gridConstraints);
		
		/* Fila 2*/
		final JLabel etiquetaDatosMascota = new JLabel("Datos mascota");
		gridConstraints.anchor = GridBagConstraints.WEST;
		gridConstraints.gridx = 0;
		gridConstraints.gridy = 1;
		gridConstraints.gridwidth = 1;
		gridConstraints.gridheight = 1;
		gridConstraints.insets = new Insets(0,0,50,0);
		panelCentral.add(etiquetaDatosMascota, gridConstraints);
	
		/* Fila 3*/
		final JLabel etiquetaTratamiento = new JLabel("Tratamiento");
		gridConstraints.anchor = GridBagConstraints.WEST;
		gridConstraints.gridx = 0;
		gridConstraints.gridy = 2;
		gridConstraints.gridwidth = 1;
		gridConstraints.gridheight = 1;
		gridConstraints.insets = new Insets(10,0,10,20);
		panelCentral.add(etiquetaTratamiento, gridConstraints);
	
		/* Fila 4*/
		
		final JTextField campoFecha = new JTextField("Fecha");
		gridConstraints.anchor = GridBagConstraints.WEST;
		gridConstraints.gridx = 0;
		gridConstraints.gridy = 3;
		gridConstraints.gridwidth = 1;
		gridConstraints.gridheight = 1;
		campoFecha.setEnabled(false);
		campoFecha.setPreferredSize(new Dimension(300, 30));
		panelCentral.add(campoFecha, gridConstraints);
		
		final JTextField campoTratamiento = new JTextField("Tratamiento");
		gridConstraints.anchor = GridBagConstraints.WEST;
		gridConstraints.gridx = 1;
		gridConstraints.gridy = 3;
		gridConstraints.gridwidth = 1;
		gridConstraints.gridheight = 1;
		campoTratamiento.setEnabled(false);
		campoTratamiento.setPreferredSize(new Dimension(300, 30));
		panelCentral.add(campoTratamiento, gridConstraints);

		final JButton buttonAnadir = new JButton("Añadir");
		gridConstraints.anchor = GridBagConstraints.EAST;
		gridConstraints.gridx = 2;
		gridConstraints.gridy = 3;
		gridConstraints.gridwidth = 1;
		gridConstraints.gridheight = 1;
		gridConstraints.insets = new Insets(10, 0, 0, 10);
		buttonAnadir.setPreferredSize(new Dimension(100, 30));
		panelCentral.add(buttonAnadir, gridConstraints);

		/* Fila 5*/
		final JTextArea textAreaTratamiento = new JTextArea();
		gridConstraints.anchor = GridBagConstraints.WEST;
		gridConstraints.gridx = 0;
		gridConstraints.gridy = 4;
		gridConstraints.gridwidth = 2;
		gridConstraints.gridheight = 1;
		textAreaTratamiento.setEnabled(false);
		textAreaTratamiento.setPreferredSize(new Dimension(710, 400));
		panelCentral.add(textAreaTratamiento, gridConstraints);
		

		
		// EVENTO EN EL BOTÓN BUSCAR - Buscará el DNI del Cliente introducido.
		buttonBuscar.addActionListener(new ActionListener(){
			public void actionPerformed (ActionEvent e){
				clienteBuscado = ventanaPrincipalJFrame.buscarCliente(campoDNICliente.getText());
				
				// Verifica si el cliente existe, y si es así le añade las mascotas al comboBox
				verificarCliente(comboBoxMascotas, campoFecha, campoTratamiento, textAreaTratamiento);
			
			}
		});
		
		buttonAnadir.addActionListener(new ActionListener(){
			public void actionPerformed (ActionEvent e){
						
				// Tengo que coger el INDEX de la mascota seleccionada en el comboBox y añadirle un tratamiento
				if(!verificarSiClienteBuscadoEsNulo()) {
					int posicionMascota = comboBoxMascotas.getSelectedIndex();
					
					Mascota mascotaBuscada = clienteBuscado.getMascotas().get(posicionMascota);
					
					// Añado el tratamiento a la mascota
					mascotaBuscada.addTratamiento(campoFecha.getText(),campoTratamiento.getText());
					
					// Muestro por consola el tratamiento
					System.out.println("Tratamiento añadido a " + mascotaBuscada.getNombre() + " a fecha de: " + campoFecha.getText() 
							+ " corresponde con un tratamiento de: " + campoTratamiento.getText() + ". Descripción del tratamiento: " 
							+ textAreaTratamiento.getText());
					
					resetearCamposTratamiento(campoFecha, campoTratamiento, textAreaTratamiento);
					
					// VEO LOS TRATAMIENTOS DE ESA MASCOTA
					mascotaBuscada.mostrarTratamientos();
				}
			}	
		});
					
		return panelCentral; 
		
	}
	
	private void verificarCliente(JComboBox<String> comboBoxMascotas, JTextField fecha, JTextField tratamiento, JTextArea areaTratamiento){
				
		if (clienteBuscado == null) {
			System.out.println("No existe cliente con ese DNI!");
			comboBoxMascotas.removeAllItems();
			deshabilitarTratamiento(fecha, tratamiento, areaTratamiento);
		}
		else {
			addMascotasComboBox(comboBoxMascotas);
			habilitarTratamiento(fecha, tratamiento, areaTratamiento);
		}
	}
	
	private boolean verificarSiClienteBuscadoEsNulo() {
		if(clienteBuscado == null) {
			System.out.println("No existe cliente con ese DNI!");
			return true;
		}
		else {
			return false;
		}
		
	}
	
	private void addMascotasComboBox(JComboBox<String> comboBoxMascotas) {
		comboBoxMascotas.removeAllItems();
		
		List<Mascota> listaMascota = clienteBuscado.getMascotas();
		for(Mascota mascota : listaMascota) {
			comboBoxMascotas.addItem(mascota.getNombre());
		}
	}
	
	private void habilitarTratamiento(JTextField fecha, JTextField tratamiento, JTextArea areaTratamiento) {
		fecha.setEnabled(true);
		tratamiento.setEnabled(true);
		areaTratamiento.setEnabled(true);
	}
	
	private void deshabilitarTratamiento(JTextField fecha, JTextField tratamiento, JTextArea areaTratamiento) {
		fecha.setEnabled(false);
		tratamiento.setEnabled(false);
		areaTratamiento.setEnabled(false);
	}

	private void resetearCamposTratamiento(JTextField fecha, JTextField tratamiento, JTextArea areaTratamiento) {
		fecha.setText("Fecha");
		tratamiento.setText("Tratamiento");
		areaTratamiento.setText(null);
	}
		
}
