package es.vsanchez.clinicaveterinaria.persistencia;

import java.io.Serializable;

import es.vsanchez.clinicaveterinaria.modelo.Cliente;

public interface ServicioClientes extends Serializable{

	// Creo una interfaz que hereda de otra interfaz Serializable (que será implementada por las clases que implementen de ServicioClientes)
	
	// Método para añadir un cliente nuevo al ArrayList de clientes
	public void addCliente(Cliente cliente); 
	
	
	// Método que muestra toda la lista de clientes por consola 
	//public void listarClientes();
	
	
	// Método que busca un cliente en el ArrayList de Clientes a través del DNI 
	public Cliente buscarCliente(String dni);
		
	

	// Método que comprueba si el cliente con el DNI introducido ya existe
	public boolean buscarSiExisteCliente(String dni);

}
