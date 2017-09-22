package com.springrest.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.springrest.domain.*;
import com.springrest.service.PersonaService;

@RestController
@RequestMapping(value = "/persona")
public class PersonaController {
	
	@Autowired
	private PersonaService personaService;
	
	@RequestMapping(value = "/listar", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Persona>> listAllPersons(){
		List<Persona> listaPersonas = personaService.findAll();
		if(listaPersonas.isEmpty()){
			return new ResponseEntity<List<Persona>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Persona>>(listaPersonas, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/select/{id}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Persona> getById(@PathVariable("id")Long id){
		Persona persona = personaService.getById(id);
		if(persona == null){
			return new ResponseEntity<Persona>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Persona>(persona, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/Iselect/{identificacion}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Persona> getByIdentificacion(@PathVariable("identificacion")String identificacion){
		Persona persona = personaService.getByIdentificacion(identificacion);
		if(persona == null){
			return new ResponseEntity<Persona>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Persona>(persona, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> add(@RequestBody Persona persona){
		
		personaService.save(persona);
		
		HttpHeaders header = new HttpHeaders();
		return new ResponseEntity<Void>(header, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> delete(@PathVariable("id") Long id){
		
		personaService.delete(id);
		
		HttpHeaders header = new HttpHeaders();
		return new ResponseEntity<Void>(header, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> update(@RequestBody Persona persona){
	
		personaService.save(persona);
		
		HttpHeaders header = new HttpHeaders();
		return new ResponseEntity<Void>(header, HttpStatus.OK);
	}

}
