package com.springrest.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.domain.Persona;
import com.springrest.repository.PersonaRepository;
import com.springrest.service.PersonaService;

@Service
public class PersonaServiceImpl implements PersonaService {
	
	@Autowired
	private PersonaRepository personaRepository;

	@Override
	public Persona getByIdentificacion(String identificacion) {
		return personaRepository.getByIdentificacion(identificacion);
	}

	@Override
	public Persona getById(Long id) {
		return personaRepository.findOne(id);
	}

	@Override
	public List<Persona> findAll() {
		return personaRepository.findAll();
	}

	@Override
	public void save(Persona persona) {
		personaRepository.save(persona);
	}

	@Override
	public void delete(Long id) {
		personaRepository.delete(id);
	}

}
