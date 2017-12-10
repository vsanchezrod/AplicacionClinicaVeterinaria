package es.vsanchez.clinicaveterinaria.modelo.excepciones;

public class DniInvalidoException extends Exception {

	private static final long serialVersionUID = 1L;

	public static final String DNI_LONGITUD_INCORRECTA	= "La longitud del DNI es incorreta";
	public static final String DNI_NUMERICO_INCORRECTO	= "Los 8 primeros caracteres deben ser de tipo numérico";
	public static final String DNI_LETRA_INCORRECTA	= "El último caracter debe ser una letra";
	
	public DniInvalidoException() {
		super();
	}
	
	public DniInvalidoException(String mensaje) {
		super(mensaje);
	}
	
}
