package es.vsanchez.clinicaveterinaria.persistencia.implementaciones;

import java.io.IOException;

import es.vsanchez.clinicaveterinaria.modelo.Cliente;
import es.vsanchez.clinicaveterinaria.modelo.Mascota;
import es.vsanchez.clinicaveterinaria.modelo.excepciones.DniInvalidoException;
import es.vsanchez.clinicaveterinaria.persistencia.ServicioClientes;

public class ServicioClientesMemoria extends ServicioClientes {

	private static final long serialVersionUID = 1L;
	
	// Método para añadir un cliente nuevo al ArrayList de clientes
	public void addCliente(Cliente cliente) throws DniInvalidoException {
		validarDni(cliente.getDni());
		getListaClientes().add(cliente);
		System.out.println("Un cliente ha sido añadido.");
	}

	@Override
	public void addMascotaAlCliente(Cliente clienteModificado, Mascota mascotaNueva) throws DniInvalidoException, IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addTratamientoAMascota(Mascota mascota, String fechaTratamiento, String nombreTratamiento)
			throws DniInvalidoException, IOException {
		// TODO Auto-generated method stub
		
	}
	
}
