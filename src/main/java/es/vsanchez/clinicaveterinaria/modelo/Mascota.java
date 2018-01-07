package es.vsanchez.clinicaveterinaria.modelo;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Mascota implements Serializable {

	private static final long serialVersionUID = 1L;
	
	// Se declaran los atributos de clase encapsulados con private
	private String nombre;
	private String codigo;
	private String genero;
	private Map<String, String> mapTratamiento;
	
	// Constructor vacío
	public Mascota() {
		this.nombre = "";
		this.codigo = "";
		this.genero = "";
		mapTratamiento = new HashMap<String, String>();
	}
	
	// Constructor con paso de parámetros
	public Mascota(String nombre, String codigo, String genero) {
		this.nombre = nombre;
		this.codigo = codigo;
		this.genero = genero;
		mapTratamiento = new HashMap<String, String>();
	}
	
	// Métodos Setters
	public void setNombre (String nombre) {
		this.nombre = nombre;
	}
	
	public void setCodigo (String codigo) {
		this.codigo = codigo;
	}
	
	public void setGenero (String genero) {
		this.genero = genero;
	}
	
	// Métodos Getters
	public String getNombre() {
		return this.nombre;
	}
	
	public String getCodigo() {
		return this.codigo;
	}
	
	public String getGenero() {
		return this.genero;
	}
	
	// Método toString que sobrescribe al método con el mismo nombre heredado de la clase Object
	@Override
	public String toString() {
		return this.nombre + " con el código " + this.codigo + " es " + this.genero;
	}
	
	// Método que añade tratamientos al HashMap
	public void addTratamiento(String fecha, String tratamiento) {
		System.out.println("Tratamiento '" + tratamiento + "' añadido con fecha '" + fecha + "' a la mascota " + getNombre() + ".");
		mapTratamiento.put(fecha, tratamiento);
	}
	
	// Método que contiene un foreach que devuelve lo que haya almacenado en el mapa de tratamientos y forma de set
	// Un set tiene como argumento un Map.Entry ==> set<Map.Entry>
	public void mostrarTratamientos() {
		System.out.println("Mostrando tratamientos para esa mascota:");
		for (Map.Entry<String, String> tratamiento: mapTratamiento.entrySet()) {
			String claveFecha = tratamiento.getKey();
			String valorTratamiento = tratamiento.getValue();
			System.out.println("Fecha del tratamiento: " + claveFecha + ". Tratamiento: " + valorTratamiento);
		}
	}	
	
}
