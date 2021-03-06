package es.vsanchez.clinicaveterinaria.modelo;

import java.io.Serializable;

public class Gato extends Mascota implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String color;
	
	// Constructor vacío
	public Gato(){
		super();
		this.color = "";
	}
	
	// Constructor con parámetros tanto los de mascota como el atributo de la clase hija
	public Gato(String nombre, String codigo, String genero, String color){
		super(nombre, codigo, genero);
		this.color = color;
	}
	
	// Método SET
	public void setColor(String color) {
		this.color = color;
	}
	
	// Método GETTER
	public String getColor() {
		return this.color;
	}
	
	// Método TOSTRING - Sobrescribe al método toString de la clase padre y a su vez de la clase Object 
	@Override
	public String toString() {
		return getNombre() + " es un gato de color " + this.color + " de género " + getGenero();
	}
}
