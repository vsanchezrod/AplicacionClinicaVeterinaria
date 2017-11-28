package es.vsanchez.clinicaveterinaria;

import java.awt.Container;
import java.util.ArrayList;
import java.util.List;

import es.vsanchez.clinicaveterinaria.vista.VentanaPrincipalJFrame;

public class MainClass {
	
	private List<Cliente> listaClientes;
	
	public static void main(String[] args) {

		// Instanciamos la clase ventanaPrincipalJFrame para crear nuestro FRAME
		new VentanaPrincipalJFrame();
		 
		Cliente cliente = new Cliente("Pedro", "123456");
		List<Cliente> listaClientes = new ArrayList<Cliente>();
		listaClientes.add(cliente);

	}
	
	// Método para añadir un cliente nuevo al ArrayList de clientes
	/*public void addCliente(Cliente cliente) {
		listaClientes.add(cliente);
	}*/
		
	
	
}
