package es.vsanchez.clinicaveterinaria;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import es.vsanchez.clinicaveterinaria.Gato;

public class GatoTest {

	@Test
	public void debeVerificarConstructorVacio(){
		final Gato gato = new Gato();
		assertEquals("", gato.getNombre());
		assertEquals("", gato.getCodigo());
		assertEquals("", gato.getGenero());
		assertEquals("", gato.getColor());
	}
		
	@Test
	public void debeVerificarConstructorConParametros() {
		final Gato gato = new Gato("Manolo", "002", "macho", "morado");
		assertEquals("Manolo", gato.getNombre());
		assertEquals("002", gato.getCodigo());
		assertEquals("macho", gato.getGenero());
		assertEquals("morado", gato.getColor());
	}
	
	@Test
	public void debeVerificarSetColor() {
		final Gato gato = new Gato();
		gato.setColor("amarillo");
		assertEquals("amarillo", gato.getColor());
	}
	
	@Test
	public void debeVerificarToString() {
		final Gato gato = new Gato("Manolo", "002", "macho","morado");
		assertEquals("Manolo es un gato de color morado de género macho", gato.toString());
	}
	
}
