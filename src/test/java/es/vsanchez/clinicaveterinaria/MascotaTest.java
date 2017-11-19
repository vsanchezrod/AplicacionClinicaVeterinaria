package es.vsanchez.clinicaveterinaria;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import es.vsanchez.clinicaveterinaria.Mascota;

public class MascotaTest {

	@Test
	public void debeVerificarConstructorVacio() {
		final Mascota mascota = new Mascota();
		assertEquals("", mascota.getNombre());
		assertEquals("", mascota.getCodigo());
		assertEquals("", mascota.getGenero());
	}
	
	@Test
	public void debeVerificarConstructorConNombreCodigoGenero() {
		final Mascota mascota = new Mascota("Bango", "001", "macho");
		assertEquals("Bango", mascota.getNombre());
		assertEquals("001", mascota.getCodigo());
		assertEquals("macho", mascota.getGenero());
	}
	
	@Test
	public void debeVerificarSetNombre() {
		final Mascota mascota = new Mascota();
		mascota.setNombre("Bango");
		assertEquals("Bango", mascota.getNombre());
	}
	
	@Test
	public void debeVerificarSetCodigo() {
		final Mascota mascota = new Mascota();
		mascota.setCodigo("001");
		assertEquals("001", mascota.getCodigo());
	}
	
	@Test
	public void debeVerificarSetGenero() {
		final Mascota mascota = new Mascota();
		mascota.setGenero("macho");
		assertEquals("macho", mascota.getGenero());
	}
	
	@Test
	public void debeVerificarToString() {
		final Mascota mascota = new Mascota("Bango", "001", "macho");
		assertEquals("Bango con el código 001 es macho", mascota.toString());
	}
}
