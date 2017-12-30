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
import es.vsanchez.clinicaveterinaria.modelo.Mascota;
import es.vsanchez.clinicaveterinaria.modelo.excepciones.DniInvalidoException;
import es.vsanchez.clinicaveterinaria.persistencia.ServicioClientes;

public class ServicioClientesFichero extends ServicioClientes{

	// Esta clase implementa Serializable, porque la clase abstracta ServicioClientes de la que hereda, ya implementa Serializable
	
	private static final long serialVersionUID = 1L;
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
		getListaClientes().add(cliente);
		System.out.println("Un cliente ha sido añadido.");
		System.out.println("Añadiendo cliente a fichero...");
		escribirListaClientesEnFichero();
	}
	
	public void addMascotaAlCliente(Cliente clienteModificado, Mascota mascotaNueva) throws DniInvalidoException, IOException {
		validarDni(clienteModificado.getDni());
		escribirListaClientesEnFichero();
		
	}
	
	@Override
	public void addTratamientoAMascota(Mascota mascota, String fechaTratamiento, String nombreTratamiento) throws DniInvalidoException, IOException {
		escribirListaClientesEnFichero();
	}

	private void escribirListaClientesEnFichero() throws IOException {
		
		// Se construye un flujo de salida de datos
		ObjectOutputStream escribiendoFichero = new ObjectOutputStream(new FileOutputStream (NOMBRE_FICHERO));
		escribiendoFichero.writeObject(getListaClientes());
		escribiendoFichero.close();
	}
	
	@SuppressWarnings("unchecked")
	private void recuperarListaClientesDeFichero() throws IOException {       
		
		// Se crea flujo de entrada de datos
		try {
			ObjectInputStream recuperandoFichero = new ObjectInputStream(new FileInputStream (NOMBRE_FICHERO));
			List<Cliente> listaClientesRecuperados = (List<Cliente>) recuperandoFichero.readObject();
			getListaClientes().addAll(listaClientesRecuperados);
			System.out.println("Recuperando lista de clientes de fichero.");
			System.out.println("Número de clientes recuperados: " + getListaClientes().size());
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
