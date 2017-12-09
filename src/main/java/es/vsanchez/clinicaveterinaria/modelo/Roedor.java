package es.vsanchez.clinicaveterinaria.modelo;

public class Roedor extends Mascota{

	private String tipo;
	
	// Constructor vacío
	public Roedor(){
		super();
		this.tipo = "";
	}
	
	// Constructor con parámetros tanto los de mascota como el atributo de la clase hija
	public Roedor(String nombre, String codigo, String genero, String tipo){
		super(nombre, codigo, genero);
		this.tipo = tipo;
	}
	
	// Método SET
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	// Método GETTER
	public String getTipo() {
		return this.tipo;
	}
	
	// Método TOSTRING - Sobrescribe al método toString de la clase padre y a su vez de la clase Object 
	@Override
	public String toString() {
		return getNombre() + " es un " + this.tipo + " de género " + getGenero();
	}
	
}
