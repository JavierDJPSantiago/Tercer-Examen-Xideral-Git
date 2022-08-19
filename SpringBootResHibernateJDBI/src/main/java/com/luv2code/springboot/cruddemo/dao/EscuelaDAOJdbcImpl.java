package com.luv2code.springboot.cruddemo.dao;

import java.sql.*;
import java.util.*;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springboot.cruddemo.entity.Escuela;

@Repository
public class EscuelaDAOJdbcImpl implements EscuelaDAO {

	@Autowired
	DataSource dataSource;

	@Override
	public List<Escuela> findAll() {

		System.out.println("Implementación DAO con JDBC: " + dataSource);

		List<Escuela> listaEscuelas = new ArrayList<>();

		try (Connection myConn = dataSource.getConnection();
				Statement myStmt = myConn.createStatement();
				ResultSet myRs = myStmt.executeQuery("select * from escuela");) {

			// process result set
			while (myRs.next()) {

				// recuperar datos de la fila
				int id = myRs.getInt("id");
				String nombre = myRs.getString("nombre");
				String tescuela = myRs.getString("tescuela");
				String correo = myRs.getString("correo");

				// crea un nuevo objeto escuela
				Escuela tempEscuela = new Escuela(id, nombre, tescuela, correo);

				// agregarlo a la lista de escuela
				listaEscuelas.add(tempEscuela);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaEscuelas;
	}

	@Override
	public Escuela findById(int theId) {
		System.out.println("Implementación DAO con JDBC: " + dataSource);

		Escuela theEscuela = null;
		try (
				// obtener conexión db
				Connection myConn = dataSource.getConnection();
				// sql para insertar
				PreparedStatement myStmt = myConn.prepareStatement("select * from escuela where id=?");
				// ejecutar sql

		) {
			myStmt.setInt(1, theId);
			
			try(ResultSet myRs = myStmt.executeQuery()){
				
				// // recuperar datos de la fila del conjunto de resultados
				if (myRs.next()) {
					String nombre = myRs.getString("nombre");
					String tescuela = myRs.getString("tescuela");
					String correo = myRs.getString("correo");
					// usar theId durante la construcción
					theEscuela = new Escuela(theId, nombre, tescuela, correo);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return theEscuela;

	}

	@Override
	public void save(Escuela theEscuela) {
		System.out.println("Implementación DAO con JDBC: " + dataSource);
		
		if (theEscuela.getId()==0) {
		try (
				// obtener conexión db
				Connection myConn = dataSource.getConnection();

				// sql para insertar
				PreparedStatement myStmt = myConn.prepareStatement(
						"insert into escuela " + "(nombre, tescuela, correo) " + "values (?, ?, ?)");) {
			// establecer los valores de parámetro para la escuela
			myStmt.setString(1, theEscuela.getNombre());
			myStmt.setString(2, theEscuela.getTescuela());
			myStmt.setString(3, theEscuela.getCorreo());

			// ejecutar insertar sql
			myStmt.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		}else {
			try (
					// obtener conexión db
					Connection myConn = dataSource.getConnection();

					// sql para insertar
					PreparedStatement myStmt = myConn.prepareStatement("update escuela set nombre=?, tescuela=?, correo=? where id=?");) {
				// establecer los valores de parámetro para la escuela
				myStmt.setString(1, theEscuela.getNombre());
				myStmt.setString(2, theEscuela.getTescuela());
				myStmt.setString(3, theEscuela.getCorreo());
				myStmt.setInt(4, theEscuela.getId());


				// ejecutar insertar sql
				myStmt.execute();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void deleteById(int theId) {
		System.out.println("Implementación DAO con JDBC: " + dataSource);

		try (
				// obtener conexión db
				Connection myConn = dataSource.getConnection();
				// sql para insertar
				PreparedStatement myStmt = myConn.prepareStatement("delete from escuela where id=?")) {

			// establecer parámetros
			myStmt.setInt(1, theId);

			// ejecutar sentencia sql
			myStmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
