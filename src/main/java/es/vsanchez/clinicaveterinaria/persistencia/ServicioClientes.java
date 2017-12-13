package es.vsanchez.clinicaveterinaria.persistencia;

import java.io.IOException;
import java.io.Serializable;

import es.vsanchez.clinicaveterinaria.modelo.Cliente;
import es.vsanchez.clinicaveterinaria.modelo.excepciones.DniInvalidoException;

public abstract class ServicioClientes implements Serializable{

	private static final long serialVersionUID = 1L;

	// Creo una interfaz que hereda de otra interfaz Serializable (que será implementada por las clases que implementen de ServicioClientes)
	
	// Método para añadir un cliente nuevo al ArrayList de clientes
	public abstract void addCliente (Cliente cliente) throws DniInvalidoException, IOException; 
	
	// Método que muestra toda la lista de clientes por consola 
	public abstract void listarClientes() throws IOException;
	
	// Método que busca un cliente en el ArrayList de Clientes a través del DNI 
	public abstract Cliente buscarClientePorDNI(String dni);
			
	// Método que comprueba si el cliente con el DNI introducido ya existe
	public abstract boolean comprobarSiExisteClientePorDNI(String dni);
	
	
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
