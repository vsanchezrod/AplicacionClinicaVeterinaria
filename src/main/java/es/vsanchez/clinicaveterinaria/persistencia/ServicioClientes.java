package es.vsanchez.clinicaveterinaria.persistencia;

import java.io.Serializable;

import es.vsanchez.clinicaveterinaria.modelo.Cliente;
import es.vsanchez.clinicaveterinaria.modelo.excepciones.DniInvalidoException;

public abstract class ServicioClientes implements Serializable{

	private static final long serialVersionUID = 1L;



	// Creo una interfaz que hereda de otra interfaz Serializable (que será implementada por las clases que implementen de ServicioClientes)
	
	// Método para añadir un cliente nuevo al ArrayList de clientes
	public abstract void addCliente (Cliente cliente) throws DniInvalidoException; 
	
	
	// Método que muestra toda la lista de clientes por consola 
	//public void listarClientes();
	
	
	// Método que busca un cliente en el ArrayList de Clientes a través del DNI 
	public abstract Cliente buscarClientePorDNI(String dni);
		
	

	// Método que comprueba si el cliente con el DNI introducido ya existe
	public abstract boolean comprobarSiExisteClientePorDNI(String dni);

	
	protected void validarDni(String dni) throws DniInvalidoException {
		// CREAR ALGORITMO
		
		
		// CUANDO SEA INVALIDO
		throw new DniInvalidoException("DNI '" + dni + "' no es válido.");
	}
	
	
}
