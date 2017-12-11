package es.vsanchez.clinicaveterinaria.persistencia.implementaciones;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import es.vsanchez.clinicaveterinaria.modelo.Cliente;
import es.vsanchez.clinicaveterinaria.modelo.excepciones.DniInvalidoException;
import es.vsanchez.clinicaveterinaria.persistencia.ServicioClientes;

public class ServicioClientesFichero extends ServicioClientes{

	// Esto ya implementa Serializable, porque la interfaz ServicioClientes extiende de Serializable
	
	private static final long serialVersionUID = 1L;
	private List<Cliente> listaClientes = new ArrayList<Cliente>();
	
	
	private void escribirArrayListEnFichero() throws IOException {
		
		// Se construye un flujo de salida de datos
		ObjectOutputStream escribiendoFichero = new ObjectOutputStream(new FileOutputStream ("listaClientes.txt"));
		escribiendoFichero.writeObject(listaClientes);
		escribiendoFichero.close();
	}
	
	@SuppressWarnings("unchecked")
	private void recuperarArrayListDeFichero() throws IOException {
		
		// Se crea flujo de entrada de datos
		ObjectInputStream recuperandoFichero = new ObjectInputStream(new FileInputStream ("listaClientes.txt"));
		try {
			listaClientes = (ArrayList<Cliente>) recuperandoFichero.readObject();
		} catch (ClassNotFoundException e) {
			System.out.println("El fichero no ha sido encontrado.");
			e.printStackTrace();
		}
		recuperandoFichero.close();
	}
	
	public void addCliente(Cliente cliente) throws DniInvalidoException, IOException {
		validarDni(cliente.getDni());
		listaClientes.add(cliente);
		System.out.println("Un cliente ha sido añadido.");
		System.out.println("Añadiendo cliente a fichero...");
		escribirArrayListEnFichero();
	}

	public Cliente buscarClientePorDNI(String dni) {
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

	public boolean comprobarSiExisteClientePorDNI(String dni) {
		for (Cliente cliente : listaClientes) {
			if (cliente.getDni().equals(dni)) {
				System.out.println("El cliente con DNI " + cliente.getDni() + " ya existe.");
				return true;
			}
		}
		return false;
	}

	public void listarClientes() throws IOException {
		listaClientes = new ArrayList<Cliente>();
		recuperarArrayListDeFichero();
		System.out.println("Recuperando lista de clientes del fichero...");
		System.out.println("Listando clientes...");
		for (Cliente cliente: listaClientes) { 
		 	System.out.println("Nombre del cliente: " + cliente.getNombre() + ". DNI: " + cliente.getDni() + ". Mascotas: " + cliente.getMascotas()); 
		}
	}
	
}
