package es.vsanchez.clinicaveterinaria.persistencia.implementaciones;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import es.vsanchez.clinicaveterinaria.modelo.Cliente;
import es.vsanchez.clinicaveterinaria.modelo.Gato;
import es.vsanchez.clinicaveterinaria.modelo.Mascota;
import es.vsanchez.clinicaveterinaria.modelo.Perro;
import es.vsanchez.clinicaveterinaria.modelo.Roedor;
import es.vsanchez.clinicaveterinaria.modelo.excepciones.DniInvalidoException;
import es.vsanchez.clinicaveterinaria.persistencia.ServicioClientes;


public class ServicioClientesBaseDeDatos extends ServicioClientes {

	private static final long serialVersionUID = 1L;

	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String BBDD = "jdbc:mysql://localhost/vetIlerna";
	private static final String USUARIO = "userIlerna";
	private static final String PASSWORD = "userIlerna";
	
	public ServicioClientesBaseDeDatos() {
		conectarConBaseDeDatos();
	}
	
	private void ejecutarQueryUpdate(String query) {

		final Connection conexion = conectarConBaseDeDatos();
		
		try {
			final Statement statement = conexion.createStatement();
			statement.executeUpdate(query);
			
			
		} catch (SQLException e) {
			System.out.println("Error con la base de datos. Query:'" + query + "'.");
			e.printStackTrace();
		}
				
		desconectarBaseDeDatos(conexion);
		
	}
		
	@Override
	public void addCliente(Cliente cliente) throws DniInvalidoException, IOException {
		
		final String queryInsercionCliente = crearQueryInsercionCliente(cliente);		
		ejecutarQueryUpdate(queryInsercionCliente);
	}
	
	@Override
	public void addMascotaAlCliente(Cliente cliente, Mascota mascotaNueva) throws DniInvalidoException, IOException { 
		// TODO Insert en la tabla mascota de una nueva mascota para ese cliente
		
		final String queryInsercionMascota = crearQueryInsercionMascota(cliente, mascotaNueva);
		ejecutarQueryUpdate(queryInsercionMascota);	
		
	}
	
	@Override
	public void addTratamientoAMascota(Mascota mascota, String fechaTratamiento, String nombreTratamiento) throws DniInvalidoException, IOException {

		final String queryInsercionTratamiento = crearQueryInsercionTratamiento(mascota, fechaTratamiento, nombreTratamiento);
		ejecutarQueryUpdate(queryInsercionTratamiento);
		
	}
		
	private Connection conectarConBaseDeDatos() {
		
		Connection conexion = null;
				
		try {
			Class.forName(DRIVER);
			conexion = DriverManager.getConnection(BBDD, USUARIO, PASSWORD);
		}
		
		catch (Exception exception) {
			System.out.println("Error en la conexión a la base de datos.");
			exception.printStackTrace();
			
		}
				
		return conexion;
		
	}
	
	private String crearQueryInsercionCliente(Cliente cliente) {
		return "INSERT INTO clientes VALUES ('" + cliente.getNombre() + "', '" + cliente.getDni() + "')";
	}
	
	private String crearQueryInsercionMascota(Cliente cliente, Mascota mascotaNueva) {
		
		String queryInsercionMascota = null;
		
		if (mascotaNueva instanceof Gato) {
			final Gato gatoNuevo = (Gato)mascotaNueva;
			queryInsercionMascota = crearQueryInsercionGato(cliente, gatoNuevo);
		}
		
		if (mascotaNueva instanceof Perro) {
			final Perro perroNuevo = (Perro)mascotaNueva;
			queryInsercionMascota = crearQueryInsercionPerro(cliente, perroNuevo);
		}
		
		if (mascotaNueva instanceof Roedor) {
			final Roedor roedorNuevo = (Roedor)mascotaNueva;
			queryInsercionMascota = crearQueryInsercionRoedor(cliente, roedorNuevo);
		}
		
		return queryInsercionMascota;
	}
	
	private String crearQueryInsercionGato(Cliente cliente, Gato gatoNuevo) {
		
		final StringBuilder queryInsercionMascota = new StringBuilder();
		
		queryInsercionMascota.append("INSERT INTO mascotas (nombre, tipo, codigo, genero, cliente, color) VALUES (")
		.append("'").append(gatoNuevo.getNombre()).append("',")
		.append("'").append("gato").append("',")
		.append("'").append(gatoNuevo.getCodigo()).append("',")
		.append("'").append(gatoNuevo.getGenero()).append("',")
		.append("'").append(cliente.getDni()).append("',")
		.append("'").append(gatoNuevo.getColor()).append("')");
		
		return queryInsercionMascota.toString();
	}
	
	private String crearQueryInsercionPerro(Cliente cliente, Perro perroNuevo) {
		
		final StringBuilder queryInsercionMascota = new StringBuilder();
		
		queryInsercionMascota.append("INSERT INTO mascotas (nombre, tipo, codigo, genero, cliente, raza) VALUES (")
		.append("'").append(perroNuevo.getNombre()).append("',")
		.append("'").append("perro").append("',")
		.append("'").append(perroNuevo.getCodigo()).append("',")
		.append("'").append(perroNuevo.getGenero()).append("',")
		.append("'").append(cliente.getDni()).append("',")
		.append("'").append(perroNuevo.getRaza()).append("')");
		
		return queryInsercionMascota.toString();
	}
	
	private String crearQueryInsercionRoedor(Cliente cliente, Roedor roedorNuevo) {
		
		final StringBuilder queryInsercionMascota = new StringBuilder();
		
		queryInsercionMascota.append("INSERT INTO mascotas (nombre, tipo, codigo, genero, cliente, tiporoedor) VALUES (")
		.append("'").append(roedorNuevo.getNombre()).append("',")
		.append("'").append("roedor").append("',")
		.append("'").append(roedorNuevo.getCodigo()).append("',")
		.append("'").append(roedorNuevo.getGenero()).append("',")
		.append("'").append(cliente.getDni()).append("',")
		.append("'").append(roedorNuevo.getTipo()).append("')");
		
		return queryInsercionMascota.toString();
	}
	
	private String crearQueryInsercionTratamiento(Mascota mascota, String fecha, String tratamiento) {
		
		final StringBuilder queryInsercionTratamiento = new StringBuilder();
		
		queryInsercionTratamiento.append("INSERT INTO tratamientos VALUES (")
		.append("'").append(tratamiento).append("',")
		.append("'").append(fecha).append("',")
		.append("'").append(mascota.getCodigo()).append("')");
				
		return queryInsercionTratamiento.toString();
	}
	
	private void desconectarBaseDeDatos(Connection conexion) {
		
		try {
			conexion.close();
		}
		
		catch (Exception exception) {
			System.out.println("No se ha podido cerrar la conexión con la base de datos.");
			exception.printStackTrace();
		}
	}

	
	
}


