package es.vsanchez.clinicaveterinaria.persistencia.implementaciones;

import java.util.List;

import es.vsanchez.clinicaveterinaria.modelo.Cliente;
import es.vsanchez.clinicaveterinaria.modelo.excepciones.DniInvalidoException;
import es.vsanchez.clinicaveterinaria.persistencia.ServicioClientes;

public class ServicioClientesMemoria extends ServicioClientes {

	private static final long serialVersionUID = 1L;
	private List<Cliente> listaClientes = getListaClientes();

	// Método para añadir un cliente nuevo al ArrayList de clientes
	public void addCliente(Cliente cliente) throws DniInvalidoException {
		validarDni(cliente.getDni());
		listaClientes.add(cliente);
		System.out.println("Un cliente ha sido añadido.");
	}

	// Método que muestra toda la lista de clientes por consola
	 public void mostrarClientesPorConsola() { 
		 System.out.println("Listando clientes...");
		 for (Cliente cliente: listaClientes) { 
			 System.out.println("Nombre del cliente: " + cliente.getNombre() + ". DNI: " + cliente.getDni() + ". Mascotas: " + cliente.getMascotas()); 
		 }
	 }
}
