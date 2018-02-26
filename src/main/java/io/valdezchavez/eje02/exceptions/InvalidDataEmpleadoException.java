/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.valdezchavez.eje02.exceptions;

/**
 *
 * @author Christian
 */
public class InvalidDataEmpleadoException extends Exception {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     *
     */
    public InvalidDataEmpleadoException(){
        super("No cumple con la edad minima para ser empleado, debe tener 18 o más años.");
    }
    
}
