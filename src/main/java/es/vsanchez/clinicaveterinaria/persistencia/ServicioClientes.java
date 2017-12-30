package es.vsanchez.clinicaveterinaria.persistencia;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import es.vsanchez.clinicaveterinaria.modelo.Cliente;
import es.vsanchez.clinicaveterinaria.modelo.Mascota;
import es.vsanchez.clinicaveterinaria.modelo.excepciones.DniInvalidoException;

public abstract class ServicioClientes implements Serializable{

	private static final long serialVersionUID = 1L;
	private List<Cliente> listaClientes = new ArrayList<Cliente>();
		
	// Se crea una clase Abstracta implementa la interfaz Serializable
	
	// Método para añadir un cliente nuevo al ArrayList de clientes
	public abstract void addCliente(Cliente cliente) throws DniInvalidoException, IOException; 
	
	public abstract void addMascotaAlCliente(Cliente clienteModificado, Mascota mascotaNueva) throws DniInvalidoException, IOException;
	
	public abstract void addTratamientoAMascota(Mascota mascota, String fechaTratamiento, String nombreTratamiento) throws DniInvalidoException, IOException;
	
	// Método que muestra toda la lista de clientes por consola 
	public void mostrarClientesPorConsola(){
		System.out.println("Listando clientes...");
		for (Cliente cliente: listaClientes) { 
		 	System.out.println("Nombre del cliente: " + cliente.getNombre() + ". DNI: " + cliente.getDni() + ". Mascotas: " + cliente.getMascotas()); 
		}
	}
	
	// GETTER que devuelve la lista de Clientes
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
	
	// Método que valida si el DNI es correcto
	protected void validarDni(String dni) throws DniInvalidoException {
		
		String numeroDniCadena = dni.substring(0, dni.length()-1);
		char letraDni = dni.toUpperCase().charAt(dni.length()-1);
		
		validarFormatoDNI(dni, letraDni, numeroDniCadena);
		int numeroDni = Integer.parseInt(numeroDniCadena);
		validarLetraDNI(dni, letraDni, numeroDni);
				
	}
	
	// Método de validación del formato de DNI	
	private void validarFormatoDNI(String dni, char letraDni, String numeroDniCadena) throws DniInvalidoException {
		// 1.Que contenga 9 caracteres
		if (dni.length() != 9) {
			throw new DniInvalidoException(DniInvalidoException.DNI_LONGITUD_INCORRECTA);
		}
		
		// 2.Que los 8 primeros caracteres sean números
		try {
			Integer.parseInt(numeroDniCadena);
		} catch (Exception e) {
			throw new DniInvalidoException(DniInvalidoException.DNI_NUMERICO_INCORRECTO);
		}
	
		// 3.Que último caracter sea una letra
		if (!Character.isLetter(letraDni)) {
			throw new DniInvalidoException(DniInvalidoException.DNI_LETRA_INCORRECTA);
		}
	}
	
	// Método de validación de que la letra es la correcta
	private void validarLetraDNI(String dni, char letraDni, int numeroDni) throws DniInvalidoException {
		
		// Se definen dos constantes:
		final String LETRA_DNI = "TRWAGMYFPDXBNJZSQVHLCKE";
		final int NUMERO_DE_LETRAS_POSIBLES = 23;
		
		int resto = numeroDni % NUMERO_DE_LETRAS_POSIBLES;
		char letraValida = LETRA_DNI.charAt(resto);
		
		if (!(letraValida == letraDni)) {
			throw new DniInvalidoException("DNI '" + dni + "' no es válido.");
		}
	}
	
}
