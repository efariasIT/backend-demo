/**
 * 
 */
package com.example.postgres.springbootpostgresdocker.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.postgres.springbootpostgresdocker.dto.PersonaDTO;
import com.example.postgres.springbootpostgresdocker.entity.PersonModel;
import com.example.postgres.springbootpostgresdocker.excepciones.CustomException;
import com.example.postgres.springbootpostgresdocker.repository.PersonRespository;

/**
 * @author efarias
 *
 */
@Service
@Transactional
public class PersonService implements IPersonService {
	
	// Constantes
	public static final String EXISTE_DOCUMENTO = "El numero de documento ya existe, por favor verifique.";

	@Autowired
	private PersonRespository personRespository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public List<PersonModel> obtenerPersonas() {
		return personRespository.findAll();
	}

	@Override
	public PersonModel guardarPersona(PersonaDTO persona) throws CustomException {
		List<PersonModel> search = findByDocument(persona.getDocumento());
		if (!search.isEmpty())
			throw new CustomException(EXISTE_DOCUMENTO);
		PersonModel personaSave = new PersonModel(persona.getDocumento(), persona.getName(), persona.getGenero(),
				persona.getTipo());
		return personRespository.save(personaSave);
	}

	private PersonaDTO convertToDto(PersonModel person) {
		return modelMapper.map(person, PersonaDTO.class);
	}

	private List<PersonModel> findByDocument(String documento) {
		return personRespository.findAll().stream().filter(person -> person.getDocumento().equals(documento))
				.collect(Collectors.toList());
	}

}
