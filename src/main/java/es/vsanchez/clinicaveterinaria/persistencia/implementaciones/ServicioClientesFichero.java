package es.vsanchez.clinicaveterinaria.persistencia.implementaciones;

import es.vsanchez.clinicaveterinaria.modelo.Cliente;
import es.vsanchez.clinicaveterinaria.modelo.excepciones.DniInvalidoException;
import es.vsanchez.clinicaveterinaria.persistencia.ServicioClientes;

public class ServicioClientesFichero extends ServicioClientes{

	// Esto ya implementa Serializable, porque la interfaz ServicioClientes extiende Serializable
	
	private static final long serialVersionUID = 1L;
	
	
	
	
	
	
	

	public void addCliente(Cliente cliente) throws DniInvalidoException {
		System.out.println("Añadiendo cliente a fichero...");
		
	}

	public Cliente buscarClientePorDNI(String dni) {
		System.out.println("Buscando cliente por dni");
		return null;
	}

	public boolean comprobarSiExisteClientePorDNI(String dni) {
		System.out.println("Comprobando si existe cliente por dni");
		return false;
	}

	
	
}
