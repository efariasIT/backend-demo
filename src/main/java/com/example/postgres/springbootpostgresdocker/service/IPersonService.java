/**
 * 
 */
package com.example.postgres.springbootpostgresdocker.service;

import java.util.List;

import com.example.postgres.springbootpostgresdocker.dto.PersonaDTO;
import com.example.postgres.springbootpostgresdocker.entity.PersonModel;
import com.example.postgres.springbootpostgresdocker.excepciones.CustomException;

/**
 * @author RocketRoa-PC
 *
 */
public interface IPersonService {

	public List<PersonModel> obtenerPersonas();

	public PersonModel guardarPersona(PersonaDTO persona) throws CustomException;

}
