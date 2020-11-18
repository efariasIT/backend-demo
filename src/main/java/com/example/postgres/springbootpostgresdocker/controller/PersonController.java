/**
 * 
 */
package com.example.postgres.springbootpostgresdocker.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.postgres.springbootpostgresdocker.dto.PersonaDTO;
import com.example.postgres.springbootpostgresdocker.excepciones.CustomException;
import com.example.postgres.springbootpostgresdocker.service.IPersonService;

/**
 * @author RocketRoa-PC
 *
 */
@RestController
@RequestMapping("/actions")
@CrossOrigin
public class PersonController {

	private Logger logger = LogManager.getLogger(PersonController.class);

	@Autowired
	private IPersonService personService;

	@GetMapping(path = "/getAllPersons", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> obtenerPersonas() {
		try {
			return ResponseEntity.ok(personService.obtenerPersonas());
		} catch (Exception e) {
			logger.error(e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Ha ocurrido un error: " + e.getMessage());
		}
	}

	@PostMapping(path = "/savePerson", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> guardarPersona(@RequestBody PersonaDTO persona) {
		try {
			return ResponseEntity.ok(personService.guardarPersona(persona));
		} catch (CustomException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		} catch (Exception e) {
			logger.error(e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Ha ocurrido un error: " + e.getMessage());
		}
	}

}
