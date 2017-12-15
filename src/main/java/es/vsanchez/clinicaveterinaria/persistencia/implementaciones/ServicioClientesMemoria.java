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

}
