package es.vsanchez.clinicaveterinaria.modelo.excepciones;

public class DniInvalidoException extends Exception {

	private static final long serialVersionUID = 1L;

	public DniInvalidoException() {
		super();
	}
	
	public DniInvalidoException(String mensaje) {
		super(mensaje);
	}
	
}
