/**
 * 
 */
package com.example.postgres.springbootpostgresdocker.dto;

/**
 * @author RocketRoa-PC
 *
 */
public class PersonaDTO {

	private String documento;
	private String name;
	private String genero;
	private String tipo;
	
	public PersonaDTO() {
		
	}

	public PersonaDTO(String documento, String name, String genero, String tipo) {
		super();
		this.documento = documento;
		this.name = name;
		this.genero = genero;
		this.tipo = tipo;
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
