package es.vsanchez.clinicaveterinaria;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import es.vsanchez.clinicaveterinaria.Roedor;

public class RoedorTest {

	@Test
	public void debeVerificarConstructorVacio() {
		final Roedor roedor = new Roedor();
		assertEquals("", roedor.getNombre());
		assertEquals("", roedor.getCodigo());
		assertEquals("", roedor.getGenero());
		assertEquals("", roedor.getTipo());
	}
	
	@Test
	public void debeVerificarConstructorConParametros() {
		final Roedor roedor = new Roedor("Zelda", "003", "hembra", "conejo");
		assertEquals("Zelda", roedor.getNombre());
		assertEquals("003", roedor.getCodigo());
		assertEquals("hembra", roedor.getGenero());
		assertEquals("conejo", roedor.getTipo());
	}
	
	@Test
	public void debeVerificarSetTipo() {
		final Roedor roedor = new Roedor();
		roedor.setTipo("conejo");
		assertEquals("conejo", roedor.getTipo());
	}
	
	@Test
	public void debeVerificarToString() {
		final Roedor roedor = new Roedor("Zelda", "003", "hembra", "conejo");
		assertEquals("Zelda es un conejo de género hembra", roedor.toString());
	}
}
