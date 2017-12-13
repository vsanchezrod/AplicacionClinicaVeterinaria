package es.vsanchez.clinicaveterinaria.persistencia;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import es.vsanchez.clinicaveterinaria.modelo.Cliente;
import es.vsanchez.clinicaveterinaria.modelo.excepciones.DniInvalidoException;

public abstract class ServicioClientes implements Serializable{

	private static final long serialVersionUID = 1L;
	private List<Cliente> listaClientes;
	
	// Creo una interfaz que hereda de otra interfaz Serializable (que será implementada por las clases que implementen de ServicioClientes)
	
	// Método para añadir un cliente nuevo al ArrayList de clientes
	public abstract void addCliente (Cliente cliente) throws DniInvalidoException, IOException; 
	
	// Método que muestra toda la lista de clientes por consola 
	/////////////////7public abstract void listarClientes() throws IOException;
	
	//////////////////////////////////////////////////
	public List<Cliente> getListaClientes(){
		return this.listaClientes;
	}
		
	// Método que busca un cliente en el ArrayList de Clientes a través del DNI 
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
			
	// Método que comprueba si el cliente con el DNI introducido ya existe
	public boolean comprobarSiExisteClientePorDNI(String dni) {
		for (Cliente cliente : listaClientes) {
			if (cliente.getDni().equals(dni)) {
				System.out.println("El cliente con DNI " + cliente.getDni() + " ya existe.");
				return true;
			}
		}
		return false;
	}
	
	
	protected void validarDni(String dni) throws DniInvalidoException {
		
		String numeroDniCadena = dni.substring(0, dni.length()-1);
		char letraDni = dni.toUpperCase().charAt(dni.length()-1);
		
		validarFormatoDNI(dni, letraDni, numeroDniCadena);
		int numeroDni = Integer.parseInt(numeroDniCadena);
		validarLetraDNI(dni, letraDni, numeroDni);
				
	}
		
	private void validarFormatoDNI(String dni, char letraDni, String numeroDniCadena) throws DniInvalidoException {
		// 1. Validamos que tenga un formato con 9 caracteres (8 numeros + 1 letra)
		if (dni.length() != 9) {
			throw new DniInvalidoException(DniInvalidoException.DNI_LONGITUD_INCORRECTA);
		}
		
		// 2. Validamos la parte numérica
		try {
			Integer.parseInt(numeroDniCadena);
		} catch (Exception e) {
			throw new DniInvalidoException(DniInvalidoException.DNI_NUMERICO_INCORRECTO);
		}
	
		// 3. El último caracter tiene que ser una letra
		if (!Character.isLetter(letraDni)) {
			throw new DniInvalidoException(DniInvalidoException.DNI_LETRA_INCORRECTA);
		}
	}
	
	private void validarLetraDNI(String dni, char letraDni, int numeroDni) throws DniInvalidoException {
		
		// Constante de tipo String que tiene las posibles letras que puede tener un DNI
		final String LETRA_DNI = "TRWAGMYFPDXBNJZSQVHLCKE";
		final int NUMERO_DE_LETRAS_POSIBLES = 23;
		
		int resto = numeroDni % NUMERO_DE_LETRAS_POSIBLES;
		char letraValida = LETRA_DNI.charAt(resto);
		
		if (!(letraValida == letraDni)) {
			throw new DniInvalidoException("DNI '" + dni + "' no es válido.");
		}
	}
	
}
