package es.vsanchez.clinicaveterinaria.persistencia.implementaciones;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import es.vsanchez.clinicaveterinaria.modelo.Cliente;
import es.vsanchez.clinicaveterinaria.modelo.excepciones.DniInvalidoException;
import es.vsanchez.clinicaveterinaria.persistencia.ServicioClientes;

public class ServicioClientesFichero extends ServicioClientes{

	// Esta clase implementa Serializable, porque la clase abstracta ServicioClientes de la que hereda, ya implementa Serializable
	
	private static final long serialVersionUID = 1L;
	private List<Cliente> listaClientes = getListaClientes();
	private static final String NOMBRE_FICHERO = "listaClientes.dat";
	
	// Constructor de la clase en el que recuperamos la lista de clientes
	public ServicioClientesFichero() {
		try {
			recuperarListaClientesDeFichero();
		
		} catch(EOFException exception) {
			System.out.println("No existe ningún cliente en el fichero.");
		} catch (IOException e) {
			System.out.println("No se ha podido recuperar la lista de clientes.");
			e.printStackTrace();
		}
	}
	
	public void addCliente(Cliente cliente) throws DniInvalidoException, IOException {
		validarDni(cliente.getDni());
		listaClientes.add(cliente);
		System.out.println("Un cliente ha sido añadido.");
		System.out.println("Añadiendo cliente a fichero...");
		escribirListaClientesEnFichero();
	}

	private void escribirListaClientesEnFichero() throws IOException {
		
		// Se construye un flujo de salida de datos
		ObjectOutputStream escribiendoFichero = new ObjectOutputStream(new FileOutputStream (NOMBRE_FICHERO));
		escribiendoFichero.writeObject(listaClientes);
		escribiendoFichero.close();
	}
	
	@SuppressWarnings("unchecked")
	private void recuperarListaClientesDeFichero() throws IOException {       
		
		// Se crea flujo de entrada de datos
		try {
			ObjectInputStream recuperandoFichero = new ObjectInputStream(new FileInputStream (NOMBRE_FICHERO));
			listaClientes = (List<Cliente>) recuperandoFichero.readObject();
			recuperandoFichero.close();
		} catch (FileNotFoundException exception) {
			System.out.println("No se ha encontrado fichero. Se va a crear el fichero: " + NOMBRE_FICHERO);
			// Si el fichero no existe, lo crea.
			ObjectOutputStream escribiendoFichero = new ObjectOutputStream(new FileOutputStream (NOMBRE_FICHERO));
			escribiendoFichero.close();
		}
			
		catch (ClassNotFoundException e) {
			System.out.println("El fichero no ha sido encontrado.");
			e.printStackTrace();
		}
		
	}
}
