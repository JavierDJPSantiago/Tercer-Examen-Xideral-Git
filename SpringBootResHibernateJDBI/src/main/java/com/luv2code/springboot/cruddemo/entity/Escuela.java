package com.luv2code.springboot.cruddemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="escuela")//nombre de la tabla en base de datos
public class Escuela {

	// definir campos
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="tescuela")
	private String tescuela;
	
	@Column(name="correo")
	private String correo;
	
	//constructor default
	public Escuela() {
	}
	
	//constructor sin id
	public Escuela(String nombre, String tescuela, String correo) {
		super();
		this.nombre = nombre;
		this.tescuela = tescuela;
		this.correo = correo;
	}

	//constructor con id
	public Escuela(int id, String nombre, String tescuela, String correo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.tescuela = tescuela;
		this.correo = correo;
	}

	
	//Getters y Setters de cada campo
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getTescuela() {
		return tescuela;
	}


	public void setTescuela(String tescuela) {
		this.tescuela = tescuela;
	}


	public String getCorreo() {
		return correo;
	}


	public void setCorreo(String correo) {
		this.correo = correo;
	}

	//Sobre escritura del metodo to string
	@Override
	public String toString() {
		return "Escuela [id=" + id + ", nombre=" + nombre + ", tescuela=" + tescuela + ", correo=" + correo + "]";
	}
		
	

}











