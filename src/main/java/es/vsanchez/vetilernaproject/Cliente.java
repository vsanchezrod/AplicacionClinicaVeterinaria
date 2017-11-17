package es.vsanchez.vetilernaproject;

public class Cliente {

	// Se declaran los atributos de clase encapsulados con private
	private String nombre;
	private String dni;
	
	// Constructor vacío
	public Cliente() {
		this.nombre = "";
		this.dni = "";
	}
	
	// Constructor con paso de parámetros
	public Cliente(String nombre, String dni) {
		this.nombre = nombre;
		this.dni = dni;
	}

	// Métodos Setters
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setDni(String dni) {
		this.dni = dni;
	}
	
	// Métodos Getters
	public String getNombre() {
		return this.nombre;
	}
	
	public String getDni() {
		return this.dni;
	}
	
	// Meétodo toString que sobrescribe al método con el mismo nombre heredado de la clase Object
	@Override
	public String toString() {
		return this.nombre + " con DNI " + this.dni + ".";
	}
	
	
}
