package es.vsanchez.vetilernaproject;

public class Mascota {

	// Se declaran los atributos de clase encapsulados con private
	private String nombre;
	private String codigo;
	private String genero;
	
	// Constructor vacío
	public Mascota() {
		this.nombre = "";
		this.codigo = "";
		this.genero = "";
	}
	
	// Constructor con paso de parámetros
	public Mascota(String nombre, String codigo, String genero) {
		this.nombre = nombre;
		this.codigo = codigo;
		this.genero = genero;
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
	
	// Meétodo toString que sobrescribe al método con el mismo nombre heredado de la clase Object
	@Override
	public String toString() {
		return this.nombre + " con el código " + this.codigo + " es " + this.genero;
	}
}
