package com.springrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springrest.domain.Persona;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {
	
	Persona getByIdentificacion(String identificacion);

}
