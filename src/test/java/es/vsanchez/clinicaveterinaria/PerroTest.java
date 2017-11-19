package es.vsanchez.clinicaveterinaria;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import es.vsanchez.clinicaveterinaria.Perro;

public class PerroTest {

	@Test
	public void debeVerificarConstructorVacio() {
		final Perro perro = new Perro();
		assertEquals("", perro.getNombre());
		assertEquals("", perro.getCodigo());
		assertEquals("", perro.getGenero());
		assertEquals("", perro.getRaza());
	}
	
	@Test
	public void debeVerificarConstructorConParametros() {
		final Perro perro = new Perro("Bango", "001", "macho", "labrador");
		assertEquals("Bango", perro.getNombre());
		assertEquals("001", perro.getCodigo());
		assertEquals("macho", perro.getGenero());
		assertEquals("labrador", perro.getRaza());
	}
	
	@Test
	public void debeVerificarSetRaza() {
		final Perro perro = new Perro();
		perro.setRaza("labrador");
		assertEquals("labrador", perro.getRaza());
	}
	
	@Test
	public void debeVerificarToString() {
		final Perro perro = new Perro("Bango", "001", "macho", "labrador");
		assertEquals("Bango es un perro de raza labrador", perro.toString());
	}
}
