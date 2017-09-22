package com.springrest.service;

import java.util.List;

import com.springrest.domain.Persona;

public interface PersonaService {
	
	Persona getByIdentificacion(String identificacion);
	Persona getById(Long id);
	List<Persona> findAll();
	void save(Persona persona);
	void delete(Long id);
}
