/**
 * 
 */
package com.example.postgres.springbootpostgresdocker.excepciones;

/**
 * @author efarias
 *
 */
public class CustomException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomException() {
		super();
	}

	public CustomException(String mensaje) {
		super(mensaje);
	}

}
