package es.vsanchez.clinicaveterinaria;

import java.util.ArrayList;
import java.util.List;

public class Cliente {

	// Se declaran los atributos de clase encapsulados con private
	private String nombre;
	private String dni;
	
	private List<Mascota> listaMascotas;
	
	
	// Constructor vacío
	public Cliente() {
		this.nombre = "";
		this.dni = "";
		listaMascotas = new ArrayList<Mascota>(); 
	}
	
	// Constructor con paso de parámetros
	public Cliente(String nombre, String dni) {
		this.nombre = nombre;
		this.dni = dni;
		listaMascotas = new ArrayList<Mascota>(); 
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
	
	// Método toString que sobrescribe al método con el mismo nombre heredado de la clase Object
	@Override
	public String toString() {
		return this.nombre + " con DNI " + this.dni + " tiene la siguiente mascota: " + listaMascotas + "." ;
	}
	
	// Método para añadir mascota al ArrayList
	public void addMascota(Mascota mascota) {
		listaMascotas.add(mascota);
	}
	
}
