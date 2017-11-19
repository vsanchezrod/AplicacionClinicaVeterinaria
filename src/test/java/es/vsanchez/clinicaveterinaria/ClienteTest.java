package es.vsanchez.clinicaveterinaria;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import es.vsanchez.clinicaveterinaria.Cliente;

public class ClienteTest {

	@Test
	public void debeVerificarQueTieneConstructorVacio() {
		final Cliente cliente = new Cliente();
		assertEquals("", cliente.getNombre());
		assertEquals("", cliente.getDni());
	}
	
	@Test
	public void debeVerificarQueTieneConstructorConNombreYDni() {
		final Cliente cliente = new Cliente("Juan", "456548769Z");
		assertEquals("Juan", cliente.getNombre());
		assertEquals("456548769Z", cliente.getDni());
	}
	
	@Test
	public void debeVerificarSetNombre() {
		final Cliente cliente = new Cliente();
		cliente.setNombre("Paco");
		assertEquals("Paco", cliente.getNombre());
	}

	@Test
	public void debeVerificarSetDni() {
		final Cliente cliente = new Cliente();
		cliente.setDni("456123456A");
		assertEquals("456123456A", cliente.getDni());
	}
	
	@Test
	public void debeVerificarToString() {
		final Cliente cliente = new Cliente("Vir", "123456789Z");
		assertEquals("Vir con DNI 123456789Z.", cliente.toString());
	}
}
