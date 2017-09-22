package com.springrest.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
public class Persona extends Entities {
	
	private static final long serialVersionUID = -49559065083411492L;
	
	@Column(unique = true)
	@NotNull
	private String identificacion;
	
	@Column
	@NotNull
	private String nombre;
	
	@Column
	@NotNull
	private String apellido;

	public Persona() {
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
}
