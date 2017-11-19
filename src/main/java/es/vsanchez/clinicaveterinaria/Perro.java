package es.vsanchez.clinicaveterinaria;

public class Perro extends Mascota{

	private String raza;
	
	// Constructor vacío
	public Perro(){
		super();
		this.raza = "";
	}
	
	// Constructor con parámetros tanto los de mascota como el atributo de la clase hija
	public Perro(String nombre, String codigo, String genero, String raza){
		super(nombre, codigo, genero);
		this.raza = raza;
	}
	
	// Método SET
	public void setRaza(String raza) {
		this.raza = raza;
	}
	// Método GETTER
	public String getRaza() {
		return this.raza;
	}
	
	// Método TOSTRING - Sobrescribe al método toString de la clase padre y a su vez de la clase Object 
	@Override
	public String toString() {
		return getNombre() + " es un perro de raza " + this.raza;
	}
	
}
