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
		listarClientes();
	}
	
	public void listarClientes() {
		System.out.println("Listando clientes.......");
		for (Cliente c: listaClientes) {
			System.out.println(c.getNombre() + c.getDni() + c.getMascotas());
		}
	}
	
	public Cliente buscarCliente(String dni) {
		System.out.println("Buscando cliente.........");
		System.out.println("El DNI introducido es: " + dni);
		for(int i = 0; i < listaClientes.size(); i++) {
			Cliente cliente = listaClientes.get(i);
			System.out.println("El cliente de la posición de la lista: " + i + " tiene un DNI: " + cliente.getDni());
			if (cliente.getDni().equals(dni)) {
				System.out.println("Se ha encontrado el cliente con DNI: " + cliente.getDni());
				return cliente;
			}
		}
		
		System.out.println("No ha encontrado el cliente con ese DNI!");
		return null;
	}

	public boolean buscarSiExisteCliente(String dni) {
		System.out.println("Buscando si el cliente ya existe");
		for(int i = 0; i < listaClientes.size(); i++) {
			Cliente cliente = listaClientes.get(i);
			if (cliente.getDni().equals(dni)) {
				System.out.println("El cliente con DNI " + cliente.getDni() + " ya existe.");
				return true;
			}
		}
		
		System.out.println("No existe el cliente, REGISTREMOSLO!");
		return false;
	}
	
	public String generarCodigo() {
		
		Random aleatorio = new Random();
		return String.valueOf(aleatorio.nextInt(5000));
	}
	
}
