package es.vsanchez.clinicaveterinaria.persistencia.implementaciones;

import java.util.ArrayList;
import java.util.List;

import es.vsanchez.clinicaveterinaria.modelo.Cliente;
import es.vsanchez.clinicaveterinaria.modelo.excepciones.DniInvalidoException;
import es.vsanchez.clinicaveterinaria.persistencia.ServicioClientes;

public class ServicioClientesMemoria extends ServicioClientes {

	private static final long serialVersionUID = 1L;
	private List<Cliente> listaClientes = new ArrayList<Cliente>();

	// Método para añadir un cliente nuevo al ArrayList de clientes
	public void addCliente(Cliente cliente) throws DniInvalidoException {
		validarDni(cliente.getDni());
		listaClientes.add(cliente);
		System.out.println("Un cliente ha sido añadido.");
	}

	// Método que muestra toda la lista de clientes por consola
	 public void listarClientes() { 
		 System.out.println("Listando clientes...");
		 for (Cliente cliente: listaClientes) { 
			 System.out.println("Nombre del cliente: " + cliente.getNombre() + ". DNI: " + cliente.getDni() + ". Mascotas: " + cliente.getMascotas()); 
		 }
	 }
	
	// Método que busca un cliente en el ArrayList de Clientes a través del DNI
	/*public Cliente buscarClientePorDNI(String dni) {
		System.out.println("Buscando cliente...");

		for (Cliente cliente : listaClientes) {
			if (cliente.getDni().equalsIgnoreCase(dni)) {
				System.out.println(
						"Se ha encontrado el cliente: " + cliente.getNombre() + " con DNI: " + cliente.getDni());
				return cliente;
			}
		}

		return null;
	}

	// Método que comprueba si el cliente con el DNI introducido ya existe
	public boolean comprobarSiExisteClientePorDNI(String dni) {

		for (Cliente cliente : listaClientes) {
			if (cliente.getDni().equals(dni)) {
				System.out.println("El cliente con DNI " + cliente.getDni() + " ya existe.");
				return true;
			}
		}
		return false;
	}*/
}
