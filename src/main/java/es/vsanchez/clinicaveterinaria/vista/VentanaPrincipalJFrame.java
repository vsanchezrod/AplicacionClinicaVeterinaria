package es.vsanchez.clinicaveterinaria.vista;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

import es.vsanchez.clinicaveterinaria.Cliente;
import es.vsanchez.clinicaveterinaria.vista.paneles.PanelBienvenida;

public class VentanaPrincipalJFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel panelPrincipal;
	private List<Cliente> listaClientes;
	
	public VentanaPrincipalJFrame() {

		super("Clínica Veterinaria VETILERNA");

		configurarVentana();

		// MenuBarPrincipal menuPrincipal = new MenuBarPrincipal(); ==> setJMenuBar(menuPrincipal);
		setJMenuBar(new MenuBarPrincipal(this));
		panelPrincipal = new PanelBienvenida();
		add(panelPrincipal, BorderLayout.CENTER);
		setVisible(true);
		
		listaClientes = new ArrayList<Cliente>();
	}

	// Método que setea el panel que se va a mostrar en el JFrame
	public void setPanelPrincipal(JPanel panel) {

		remove(panelPrincipal);
		panelPrincipal = panel;
		add(panelPrincipal, BorderLayout.CENTER);
		panelPrincipal.updateUI();
	}

	// Configura el JFrame
	private void configurarVentana() {

		setSize(1200, 800);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
	}
	
	// Método para añadir un cliente nuevo al ArrayList de clientes
	public void addCliente(Cliente cliente) {
		listaClientes.add(cliente);
		System.out.println("Un cliente ha sido añadido.");
	}
	
	// Método que muestra toda la lista de clientes por consola 
	/*public void listarClientes() {
		System.out.println("Listando clientes...");
		for (Cliente cliente: listaClientes) {
			System.out.println(cliente.getNombre() + cliente.getDni() + cliente.getMascotas());
		}
	}*/
	
	// Método que busca un cliente en el ArrayList de Clientes a través del DNI 
	public Cliente buscarCliente(String dni) {
		System.out.println("Buscando cliente...");
				
		for (Cliente cliente : listaClientes) {
			if (cliente.getDni().equals(dni)) {
				System.out.println("Se ha encontrado el cliente: " + cliente.getNombre() + " con DNI: " + cliente.getDni());
				return cliente;
			}
		}
		
		return null;
	}

	// Método que comprueba si el cliente con el DNI introducido ya existe
	public boolean buscarSiExisteCliente(String dni) {
				
		for (Cliente cliente : listaClientes) {
			if (cliente.getDni().equals(dni)) {
				System.out.println("El cliente con DNI " + cliente.getDni() + " ya existe.");
				return true;
			}
		}
		return false;
	}
	
	// Método que genera un código aleatorio a las mascotas
	public String generarCodigo() {
		
		Random aleatorio = new Random();
		return String.valueOf(aleatorio.nextInt(5000));
	}
	
}
