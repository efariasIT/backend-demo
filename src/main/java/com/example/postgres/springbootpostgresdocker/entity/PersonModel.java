/**
 * 
 */
package com.example.postgres.springbootpostgresdocker.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author efarias
 *
 */
@Entity
public class PersonModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;
	private String documento;
	private String name;
	private String genero;
	private String tipo;

	public PersonModel() {
	}

	public PersonModel(String documento, String name, String genero, String tipo) {
		this.documento = documento;
		this.name = name;
		this.genero = genero;
		this.tipo = tipo;
	}

	public PersonModel(String documento) {
		this.documento = documento;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}
